package com.ssafy.sowlmate.service;

import com.ssafy.sowlmate.dto.FromToUserIdDto;
import com.ssafy.sowlmate.dto.response.PenpalResponseDto;
import com.ssafy.sowlmate.dto.response.PenpalShortResponseDto;
import com.ssafy.sowlmate.entity.Intimacy;
import com.ssafy.sowlmate.entity.Penpal;
import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.repository.PenpalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PenpalService {

    private final PenpalRepository penpalRepository;
    private final UserService userService;
    private final IntimacyService intimacyService;

    public List<PenpalShortResponseDto> selectAll() {
        List<PenpalShortResponseDto> result = new ArrayList<>();
        for (Penpal penpal : penpalRepository.findAll()) {
            PenpalShortResponseDto dto = new PenpalShortResponseDto();
            dto.setFromUserId(penpal.getFromUser().getId());
            dto.setToUserId(penpal.getToUser().getId());
            result.add(dto);
        }
        return result;
    }

    public List<Penpal> selectAllByFromUserNo(long fromUserNo) {
        return penpalRepository.findAllByFromUserNo(fromUserNo);
    }

    public List<PenpalResponseDto> selectAllByFromUserId(String fromUserId) {
        List<PenpalResponseDto> result = new ArrayList<>();
        for (Penpal penpal : penpalRepository.findAllByFromUserId(fromUserId)) {
            PenpalResponseDto dto = PenpalResponseDto.toDto(penpal);
            Intimacy intimacy = intimacyService.selectByFromUserIdAndToUserId2(penpal.getFromUser().getId(),
                    penpal.getToUser().getId());
            dto.setIntimacyEval(intimacy==null ? 0 : intimacy.getEval());
            result.add(dto);
        }
        return result;
    }

    public String selectAllByFromUserIdAndToUserId(String fromUserId, String toUserId) {
        Penpal penpal = penpalRepository.findByFromUserIdAndToUserId(fromUserId, toUserId);
        if (penpal != null) {
            return "exist";
        } else {
            return "empty";
        }
    }

//    @Transactional
//    public void enrollPenpalByUserNo(long fromUserNo, long toUserNo) {
//        User fromUser = userService.selectByNo(fromUserNo);
//        User toUser = userService.selectByNo(toUserNo);
//
//        Penpal p = new Penpal();
//        p.setFromUser(fromUser);
//        p.setToUser(toUser);
//
//        Penpal p2 = new Penpal();
//        p2.setFromUser(toUser);
//        p2.setToUser(fromUser);
//
//        penpalRepository.save(p);
//        penpalRepository.save(p2);
//    }

    @Transactional
    public List<Penpal> enrollPenpalByUserId(FromToUserIdDto idDto) {
        User fromUser = userService.selectById(idDto.getFromUserId());
        User toUser = userService.selectById(idDto.getToUserId());

        Penpal p = new Penpal();
        p.setFromUser(fromUser);
        p.setToUser(toUser);

        Penpal p2 = new Penpal();
        p2.setFromUser(toUser);
        p2.setToUser(fromUser);

        List<Penpal> res = new ArrayList<>();
        res.add(penpalRepository.save(p));
        res.add(penpalRepository.save(p2));

        return res;
    }

//    @Transactional
//    public void deletePenpalByUserNo(long fromUserNo, long toUserNo) {
//        penpalRepository.deleteByFromUserNoAndToUserNo(fromUserNo, toUserNo);
//        penpalRepository.deleteByFromUserNoAndToUserNo(toUserNo, fromUserNo);
//    }

    @Transactional
    public int deletePenpalByUserId(FromToUserIdDto idDto) {
        int res = 0;
        res += penpalRepository.deleteByFromUserIdAndToUserId(idDto.getFromUserId(), idDto.getToUserId());
        res += penpalRepository.deleteByFromUserIdAndToUserId(idDto.getToUserId(), idDto.getFromUserId());
        return res;
    }

    @Transactional
    public int deleteByFromUserId(String fromUserId) {
        return penpalRepository.deleteAllByFromUserId(fromUserId);
    }

    @Transactional
    public int deleteByToUserId(String toUserId) {
        return penpalRepository.deleteAllByToUserId(toUserId);
    }

    public List<PenpalResponseDto> selectAllByFromUserIdAndIntimacyLevel(String fromUserId, int intimacyStart, int intimacyEnd) {
        List<PenpalResponseDto> result = new ArrayList<>();
        List<PenpalResponseDto> dtos = selectAllByFromUserId(fromUserId);
        for (PenpalResponseDto dto : dtos) {
            if (dto.getIntimacyEval() >= intimacyStart && dto.getIntimacyEval() <= intimacyEnd) result.add(dto);
        }
        return result;
    }
}
