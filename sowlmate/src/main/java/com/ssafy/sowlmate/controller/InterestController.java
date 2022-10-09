package com.ssafy.sowlmate.controller;

import com.ssafy.sowlmate.dto.request.InterestRequestDto;
import com.ssafy.sowlmate.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("interest")
public class InterestController {

    private final InterestService interestService;

    /**
     * 관심사 전체 조회
     */
    @GetMapping("list")
    public ResponseEntity<?> interestList() {
        return ResponseEntity.ok().body(interestService.selectAll());
    }

    /**
     * 유저별 관심사 등록
     */
    @PostMapping
    public ResponseEntity<?> enrollInterest(@RequestBody InterestRequestDto requestDto) {
        return ResponseEntity.ok().body(interestService.enrollInterest(requestDto.getUserId(), requestDto.getInterest()));
    }

    /**
     * 유저별 관심사 삭제
     */
    @DeleteMapping
    public ResponseEntity<?> deleteInterest(@RequestBody InterestRequestDto requestDto) {
        return ResponseEntity.ok().body(interestService.deleteInterest(requestDto.getUserId(), requestDto.getInterest().getTitle()));
    }
}
