package com.ssafy.sowlmate.controller;

import com.ssafy.sowlmate.dto.request.LetterRequestDto;
import com.ssafy.sowlmate.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/letter")
public class LetterController {

    private final LetterService letterService;

    /**
     * 받은 편지 전체 리스트 (내가 설정한 블랙리스트가 보낸 편지는 가져오지 않는다.)
     */
    @GetMapping("list")
    public ResponseEntity<?> getLettersByToUser(HttpServletRequest request) {
        return ResponseEntity.ok().body(letterService.selectAllByToUserId(request.getHeader("toUserId")));
    }

    /**
     * 단일 편지 조회
     */
    @GetMapping("single")
    public ResponseEntity<?> getLetterByNo(HttpServletRequest request) {
        return ResponseEntity.ok().body(letterService.selectByNo(Long.valueOf(request.getHeader("letterNo"))));
    }

    /**
     * 편지 보내기
     */
    @PostMapping
    public ResponseEntity<?> enrollLetter(@RequestBody LetterRequestDto requestDto) {
        return ResponseEntity.ok().body(letterService.enrollLetter(requestDto));
    }

    /**
     * 좋아요
     */
    @PutMapping("favorite/on")
    public ResponseEntity<?> onFavorite(@RequestBody LetterRequestDto requestDto) {
        return ResponseEntity.ok().body(letterService.onFavorite(requestDto.getLetterNo()));
    }

    /**
     * 좋아요 취소
     */
    @PutMapping("favorite/off")
    public ResponseEntity<?> offFavorite(@RequestBody LetterRequestDto requestDto) {
        return ResponseEntity.ok().body(letterService.offFavorite(requestDto.getLetterNo()));
    }
}
