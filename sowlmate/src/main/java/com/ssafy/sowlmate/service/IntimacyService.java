package com.ssafy.sowlmate.service;

import com.ssafy.sowlmate.dto.request.IntimacyRequestDto;
import com.ssafy.sowlmate.dto.response.IntimacyResponseDto;
import com.ssafy.sowlmate.dto.response.IntimacyShortResponseDto;
import com.ssafy.sowlmate.entity.Intimacy;
import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.repository.IntimacyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IntimacyService {

    private final IntimacyRepository intimacyRepository;
    private final UserService userService;

    /**
     * 등록
     */
    @Transactional
    public Intimacy enrollIntimacy(IntimacyRequestDto requestDto) {
        User fromUser = userService.selectById(requestDto.getFromUserId());
        User toUser = userService.selectById(requestDto.getToUserId());
        Intimacy intimacy = Intimacy.createIntimacy(fromUser, toUser, requestDto.getEval());
        return intimacyRepository.save(intimacy);
    }

    /**
     * 전체 조회
     */
    public List<IntimacyResponseDto> selectAll() {
        List<IntimacyResponseDto> result = new ArrayList<>();
        for (Intimacy intimacy : intimacyRepository.findAll()) {
            IntimacyResponseDto dto = new IntimacyResponseDto();
            dto.setFromUserId(intimacy.getFromUser().getId());
            dto.setToUserId(intimacy.getToUser().getId());
            dto.setEval(intimacy.getEval());
            result.add(dto);
        }
        return result;
    }

    /**
     * 유저별 조회
     */
    public List<IntimacyShortResponseDto> selectAllByFromUserId(String fromUserId) {
        List<IntimacyShortResponseDto> result = new ArrayList<>();
        for (Intimacy intimacy : intimacyRepository.findAllByFromUserId(fromUserId)) {
            IntimacyShortResponseDto dto = new IntimacyShortResponseDto();
            dto.setToUserId(intimacy.getToUser().getId());
            dto.setEval(intimacy.getEval());
            result.add(dto);
        }
        return result;
    }

    /**
     * 단일 조회1
     */
    public Intimacy selectByFromUserIdAndToUserId(IntimacyRequestDto requestDto) {
        return intimacyRepository.findByFromUserIdAndToUserId(requestDto.getFromUserId(), requestDto.getToUserId());
    }

    /**
     * 단일 조회2
     */
    public Intimacy selectByFromUserIdAndToUserId2(String fromUserId, String toUserId) {
        return intimacyRepository.findByFromUserIdAndToUserId(fromUserId, toUserId);
    }

    /**
     * 수정 - 긍정평가
     */
    @Transactional
    public int evalPositive(IntimacyRequestDto requestDto) {
        Intimacy intimacy = selectByFromUserIdAndToUserId(requestDto);
        intimacy.positive(requestDto.getEval());
        return intimacy.getEval();
    }

    /**
     * 수정 - 부정평가
     */
    @Transactional
    public int evalNegative(IntimacyRequestDto requestDto) {
        Intimacy intimacy = selectByFromUserIdAndToUserId(requestDto);
        intimacy.negative(requestDto.getEval());
        return intimacy.getEval();
    }

    /**
     * 수정 - 미팅 시간에 따른 긍정평가
     */
    @Transactional
    public int evalPositiveByMeetingTime(IntimacyRequestDto requestDto) {
        Intimacy intimacy = selectByFromUserIdAndToUserId(requestDto);
        intimacy.positive((int) Math.round(Math.log10(requestDto.getMeetingTime())));
        return intimacy.getEval();
    }

    @Transactional
    public int deleteByFromUserId(String fromUserId) {
        return intimacyRepository.deleteAllByFromUserId(fromUserId);
    }

    @Transactional
    public int deleteByToUserId(String toUserId) {
        return intimacyRepository.deleteAllByToUserId(toUserId);
    }
}
