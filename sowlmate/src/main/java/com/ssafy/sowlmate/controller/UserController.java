package com.ssafy.sowlmate.controller;

import com.ssafy.sowlmate.dto.*;
import com.ssafy.sowlmate.dto.request.UserChangePwDto;
import com.ssafy.sowlmate.dto.request.UserProfileDto;
import com.ssafy.sowlmate.dto.request.UserRequestDto;
import com.ssafy.sowlmate.dto.request.UserUpdateRequestDto;
import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.service.IntimacyService;
import com.ssafy.sowlmate.service.LetterService;
import com.ssafy.sowlmate.service.PenpalService;
import com.ssafy.sowlmate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final PenpalService penpalService;
    private final IntimacyService intimacyService;
    private final LetterService letterService;

    /**
     * 유저 회원가입
     */
    @PostMapping
    public ResponseEntity<?> enrollUser(@RequestBody User user) {
        User enrolledUser = userService.enroll(user);
        return ResponseEntity.ok().body(UserInfoDto.toDto(enrolledUser));
    }

    /**
     * 사용자 리스트
     */
    @GetMapping("list")
    public ResponseEntity<?> userList() {
        return ResponseEntity.ok().body(userService.selectAll());
    }

    /**
     * 존재하는 유저 아이디 여부 확인
     */
    @GetMapping("exist/id")
    public ResponseEntity<?> userInfo(HttpServletRequest request) {
        User user = userService.selectById(request.getHeader("userId"));
        return ResponseEntity.ok().body(user == null ? "empty" : "exist");
    }

    /**
     * 존재하는 닉네임 여부 확인
     */
    @PostMapping("exist/nickname")
    public ResponseEntity<?> existNickname(@RequestBody UserRequestDto requestDto) {
        User user = userService.selectByNickname(requestDto.getUserNickname());
        return ResponseEntity.ok().body(user == null ? "empty" : "exist");
    }

    /**
     * 유저 회원가입 타입 조회
     */
    @GetMapping("login-type")
    public ResponseEntity<?> getLoginType(HttpServletRequest request) {
        return ResponseEntity.ok().body(userService.selectById(request.getHeader("userId")).getLoginType());
    }

    /**
     * 유저 정보 수정
     */
    @PutMapping
    public ResponseEntity<?> updateUserInfo(@RequestBody UserUpdateRequestDto updateDto) {
        return ResponseEntity.ok().body(userService.updateUser(updateDto));
    }

    /**
     * 유저 정보 수정 : profilePictureUrl
     */
    @PutMapping("profile")
    public ResponseEntity<?> updateUserInfo(@RequestBody UserProfileDto profileDto) {
        return ResponseEntity.ok().body(userService.updateUserProfile(profileDto));
    }

    /**
     * 유저 정보 수정 : password
     */
    @PutMapping("modifypw")
    public ResponseEntity<?> updateUserInfo(@RequestBody UserChangePwDto pwDto) {
        return ResponseEntity.ok().body(userService.modifyPassword(pwDto));
    }

    /**
     * 유저 정보 삭제
     */
    @DeleteMapping
    public ResponseEntity<?> deleteUserInfo(@RequestBody UserRequestDto requestDto) {
        penpalService.deleteByFromUserId(requestDto.getUserId());
        penpalService.deleteByToUserId(requestDto.getUserId());
        intimacyService.deleteByFromUserId(requestDto.getUserId());
        intimacyService.deleteByToUserId(requestDto.getUserId());
        letterService.deleteByFromUserId(requestDto.getUserId());
        letterService.deleteByToUserId(requestDto.getUserId());
        return ResponseEntity.ok().body(userService.deleteById(requestDto.getUserId()));
    }
}
