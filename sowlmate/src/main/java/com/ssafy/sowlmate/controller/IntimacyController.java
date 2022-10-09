package com.ssafy.sowlmate.controller;

import com.ssafy.sowlmate.dto.request.IntimacyRequestDto;
import com.ssafy.sowlmate.service.IntimacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("intimacy")
public class IntimacyController {

    private final IntimacyService intimacyService;

    /**
     * 등록
     */
    @PostMapping
    public ResponseEntity<?> enrollIntimacy(@RequestBody IntimacyRequestDto requestDto) {
        return ResponseEntity.ok().body(intimacyService.enrollIntimacy(requestDto));
    }

    /**
     * 전체 조회
     */
    @GetMapping("list")
    public ResponseEntity<?> getIntimacies() {
        return ResponseEntity.ok().body(intimacyService.selectAll());
    }

    /**
     * 유저별 조회
     */
    @GetMapping("list/user")
    public ResponseEntity<?> getIntimaciesByFromUser(HttpServletRequest request) {
        return ResponseEntity.ok().body(intimacyService.selectAllByFromUserId(request.getHeader("fromUserId")));
    }

    /**
     * 단일 조회
     */
    @GetMapping("single")
    public ResponseEntity<?> getIntimacy(HttpServletRequest request) {
        Map<String, Integer> result = new HashMap<>();
        result.put("eval", intimacyService.selectByFromUserIdAndToUserId2(request.getHeader("fromUserId"),
                request.getHeader("toUserId")).getEval());
        return ResponseEntity.ok().body(result);
    }

    /**
     * 긍정 평가
     */
    @PutMapping("positive")
    public ResponseEntity<?> evalPositive(@RequestBody IntimacyRequestDto requestDto) {
        return ResponseEntity.ok().body(intimacyService.evalPositive(requestDto));
    }

    /**
     * 미팅 시간에 따른 친밀도 증가
     */
    @PutMapping("positive/time")
    public ResponseEntity<?> evalPositiveByMeetingTime(@RequestBody IntimacyRequestDto requestDto) {
        return ResponseEntity.ok().body(intimacyService.evalPositiveByMeetingTime(requestDto));
    }

    /**
     * 부정 평가
     */
    @PutMapping("negative")
    public ResponseEntity<?> evalNegative(@RequestBody IntimacyRequestDto requestDto) {
        return ResponseEntity.ok().body(intimacyService.evalNegative(requestDto));
    }
}
