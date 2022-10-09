package com.ssafy.sowlmate.service;

import com.ssafy.sowlmate.dto.request.LetterRequestDto;
import com.ssafy.sowlmate.dto.response.LetterResponseDto;
import com.ssafy.sowlmate.entity.BlackList;
import com.ssafy.sowlmate.entity.Letter;
import com.ssafy.sowlmate.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {

    private final LetterRepository letterRepository;
    private final BlackListService blackListService;
    private final UserService userService;

    /**
     * 받은 편지 전체 리스트 (내가 설정한 블랙리스트가 보낸 편지는 가져오지 않는다.)
     * 향후 수정 필요(블랙리스트-유저 구조 수정 선행 필요)
     */
    public List<LetterResponseDto> selectAllByToUserId(String toUserId) {
        List<LetterResponseDto> result = new ArrayList<>();
        // 편지를 받은 사람 기준 블랙리스트를 불러온다.
        List<BlackList> blackLists = blackListService.selectAllByFromUserId(toUserId);
        // 블랙리스트로 지정된 유저를 불러온다.
        List<String> userIds = new ArrayList<>();
        for (BlackList blackList : blackLists) userIds.add(blackList.getToUser().getId());
        // 편지를 보낸 사람이 블랙리스트에 포함되어 있다면 반환하지 않는다.
        for (Letter letter : letterRepository.findAllByToUserId(toUserId)) {
            if (!userIds.contains(letter.getFromUserId())) {
                result.add(LetterResponseDto.toDto(letter));
            }
        }
        return result;
    }

    /**
     * 단일 편지 조회 (읽음 표시)
     */
    @Transactional
    public LetterResponseDto selectByNo(Long letterNo) {
        Letter letter = letterRepository.findByNo(letterNo);
        letter.read();
        return LetterResponseDto.toDto(letter);
    }

    /**
     * 편지 등록
     */
    @Transactional
    public Letter enrollLetter(LetterRequestDto requestDto) {
        String fromUserNickname = userService.selectById(requestDto.getFromUserId()).getNickname();
        String toUserNickname = userService.selectById(requestDto.getToUserId()).getNickname();
        return letterRepository.save(Letter.createLetter(
                requestDto.getFromUserId(), requestDto.getToUserId(),
                fromUserNickname, toUserNickname,
                requestDto.getTitle(), requestDto.getContent(),
                requestDto.getWritingPad(), requestDto.getWritingFont()));
    }

    /**
     * 좋아요
     */
    @Transactional
    public boolean onFavorite(Long letterNo) {
        Letter letter = letterRepository.findByNo(letterNo);
        return letter.favoriteOn();
    }

    /**
     * 좋아요 취소
     */
    @Transactional
    public boolean offFavorite(Long letterNo) {
        Letter letter = letterRepository.findByNo(letterNo);
        return letter.favoriteOff();
    }

    @Transactional
    public int deleteByFromUserId(String fromUserId) {
        return letterRepository.deleteAllByFromUserId(fromUserId);
    }

    @Transactional
    public int deleteByToUserId(String toUserId) {
        return letterRepository.deleteAllByToUserId(toUserId);
    }
}
