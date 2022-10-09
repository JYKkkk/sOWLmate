package com.ssafy.sowlmate.controller;

import com.ssafy.sowlmate.dto.FromToUserIdDto;
import com.ssafy.sowlmate.service.PenpalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("penpal")
public class PenpalController {

    private final PenpalService penpalService;

    /**
     * 펜팔 등록
     */
    @PostMapping
    public ResponseEntity<?> enrollPenpal(@RequestBody FromToUserIdDto idDto) {
        return ResponseEntity.ok().body(penpalService.enrollPenpalByUserId(idDto));
    }

    /**
     * 펜팔 전체 조회
     */
    @GetMapping("list")
    public ResponseEntity<?> penpalList() {
        return ResponseEntity.ok().body(penpalService.selectAll());
    }

    /**
     * 유저별 펜팔 조회
     */
    @GetMapping("list/user")
    public ResponseEntity<?> penpalListByUser(HttpServletRequest request) {
        return ResponseEntity.ok().body(penpalService.selectAllByFromUserId(request.getHeader("fromUserId")));
    }

    /**
     * From, To 유저별 펜팔 조회
     */
    @GetMapping("single/user")
    public ResponseEntity<?> penpalByFromUserIdAndToUserId(HttpServletRequest request) {
        return ResponseEntity.ok().body(penpalService.selectAllByFromUserIdAndToUserId(
                request.getHeader("fromUserId"),
                request.getHeader("toUserId")));
    }

    /**
     * 유저별, 친밀도 수준별 펜팔 조회
     */
    @GetMapping("list/user-intimacy")
    public ResponseEntity<?> penpalListByUserAndIntimacy(HttpServletRequest request) {
        return ResponseEntity.ok().body(
                penpalService.selectAllByFromUserIdAndIntimacyLevel(
                        request.getHeader("fromUserId"),
                        Integer.valueOf(request.getHeader("intimacyStart")),
                        Integer.valueOf(request.getHeader("intimacyEnd"))));
    }

    /**
     * 펜팔 삭제
     */
    @DeleteMapping
    public ResponseEntity<?> deletePenpal(@RequestBody FromToUserIdDto idDto) {
        return ResponseEntity.ok().body(penpalService.deletePenpalByUserId(idDto));
    }
}

