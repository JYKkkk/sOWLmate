package com.ssafy.sowlmate.controller;

import com.ssafy.sowlmate.dto.MailDto;
import com.ssafy.sowlmate.dto.request.UserFindPWRequestDto;
import com.ssafy.sowlmate.dto.UserInfoDto;
import com.ssafy.sowlmate.dto.request.UserLoginDto;
import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.service.JwtService;
import com.ssafy.sowlmate.service.SendEmailService;
import com.ssafy.sowlmate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private final JwtService jwtService;
    private final UserService userService;
    private final SendEmailService sendEmailService;

    /**
     * Access-token과 로그인 결과 메세지를 반환한다.
     */
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto loginDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            User loginUser = userService.login(loginDto);
            if (loginUser != null) {
                String token = jwtService.create("userid", loginUser.getId(), "access-token"); // key, data, subject
                resultMap.put("access-token", token);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } else {
                resultMap.put("message", FAIL);
                status = HttpStatus.ACCEPTED;
            }
        } catch (Exception e) {
            log.error("로그인 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /**
     * 회원 정보를 반환한다. (로그인한 사용자 찾기)
     */
    @PostMapping("info")
    public ResponseEntity<?> getInfo(@RequestBody UserLoginDto loginDto, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        if (jwtService.isUsable(request.getHeader("access-token"))) {
            log.info("사용 가능한 토큰!!!");
            try {
                User userInfo = userService.selectById(loginDto.getId());
                UserInfoDto userInfoDto = UserInfoDto.toDto(userInfo);
                resultMap.put("userInfo", userInfoDto);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                log.error("정보조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            log.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /**
     * 구글(소셜) 가입 유저의 회원 정보를 반환한다. (로그인한 사용자 찾기)
     */
    @PostMapping("google/info")
    public ResponseEntity<?> getInfoByGoogle(@RequestBody UserLoginDto loginDto) {
        User userInfo = userService.selectById(loginDto.getId());
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        log.info(loginDto.getPassword());
        log.info(userInfo.getPassword());
        if (loginDto.getPassword().equals(userInfo.getPassword())) {
            try {
                UserInfoDto userInfoDto = UserInfoDto.toDto(userInfo);
                resultMap.put("userInfo", userInfoDto);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /**
     * Find Password by email (Email과 name의 일치여부를 check하는 controller)
     */
    @PostMapping("findpw")
    public ResponseEntity<?> findPw(@RequestBody UserFindPWRequestDto requestDto) {
        Map<String, Boolean> json = new HashMap<>();
        json.put("check", userService.userEmailCheck(requestDto));
        return ResponseEntity.ok().body(json);
    }

    /**
     * 등록된 email로 tempPassword를 발송하고, 발송된 tempPassword로 사용자의 pw를 변경하는 controller
     */
    @PostMapping("findpw/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody UserFindPWRequestDto requestDto) {
        MailDto dto = sendEmailService.createMailAndChangePassword(requestDto);
        return ResponseEntity.ok().body(sendEmailService.sendEmail(dto));
    }

    /**
     * 등록된 email로 tempPassword를 발송하고, 발송된 tempPassword로 사용자의 pw를 변경하는 controller
     */
    @PostMapping("exist/id/sendemail")
    public ResponseEntity<?> sendExistIdEmail(@RequestBody UserLoginDto dto) {
        return ResponseEntity.ok().body(sendEmailService.sendIdCheckEmail(dto.getId()));
    }
}
