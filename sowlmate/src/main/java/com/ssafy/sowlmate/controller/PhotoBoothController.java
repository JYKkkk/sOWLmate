package com.ssafy.sowlmate.controller;

import com.ssafy.sowlmate.dto.request.PhotoBoothRequestDto;
import com.ssafy.sowlmate.entity.PhotoBooth;
import com.ssafy.sowlmate.service.PhotoBoothService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("photo-booth")
public class PhotoBoothController {

    private final PhotoBoothService photoBoothService;

    /**
     * 전체 조회
     */
    @GetMapping("list")
    public ResponseEntity<?> getPhotoBooths() {
        return ResponseEntity.ok().body(photoBoothService.selectAll());
    }

    /**
     * 전체 조회 : 유저 아이디 기반
     */
    @GetMapping("list/user")
    public ResponseEntity<?> getPhotoBoothsByUserId(HttpServletRequest request) {
        return ResponseEntity.ok().body(photoBoothService.selectAllByUserId(request.getHeader("userId")));
    }

    /**
     * 단일 조회 : 사진 번호 기반
     */
    @GetMapping("single")
    public ResponseEntity<?> getPhotoByNo(HttpServletRequest request) {
        return ResponseEntity.ok().body(photoBoothService.selectByNo(Long.valueOf(request.getHeader("no"))));
    }

    /**
     * 저장
     */
    @PostMapping
    public ResponseEntity<?> enrollPhotoBooth(@RequestBody PhotoBooth photoBooth) {
        return ResponseEntity.ok().body(photoBoothService.enrollPhotoBooth(photoBooth));
    }

    /**
     * 삭제
     */
    @DeleteMapping
    public ResponseEntity<?> deletePhotoBooth(@RequestBody PhotoBoothRequestDto requestDto) {
        return ResponseEntity.ok().body(photoBoothService.deleteByNo(requestDto.getNo()));
    }
}
