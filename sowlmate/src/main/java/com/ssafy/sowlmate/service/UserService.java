package com.ssafy.sowlmate.service;

import com.ssafy.sowlmate.dto.*;
import com.ssafy.sowlmate.dto.request.*;
import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User enroll(User user) {
        return userRepository.save(user);
    }

    public User selectByNo(Long no) {
        return userRepository.findByNo(no);
    }

    public User selectById(String userId) {
        return userRepository.findById(userId);
    }

    public User selectByUserIdAndUserName(String userId, String userName) {
        return userRepository.findByIdAndName(userId, userName);
    }

    public User selectByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    public List<User> selectAll() {
        return userRepository.findAll();
    }

    @Transactional
    public int deleteById(String userId) {
        return userRepository.deleteById(userId);
    }

    /**
     * Find Password by email
     * : emil을 통해 해당 email로 가입된 정보가 있는지 확인하고,
     *   가입된 정보가 있다면 입력받은 name과 등록된 name이 일치한지 여부를 return
     */
    public boolean userEmailCheck(UserFindPWRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId());
        return user != null && user.getName().equals(requestDto.getUserName());
    }

    public User login(UserLoginDto loginDto) {
        if (loginDto.getId() == null || loginDto.getPassword() == null) {
            return null;
        }
        User findUser = userRepository.findById(loginDto.getId());
        return findUser.getPassword().equals(loginDto.getPassword()) ? findUser : null;
    }

    @Transactional
    public User updateUser(UserUpdateRequestDto updateDto) {
        UserUpdateDto user = updateDto.getUser();
        User newUser = userRepository.findById(updateDto.getUserId());

        newUser.setNickname(user.getNickname());
        newUser.setLanguage(user.getLanguage());
        newUser.setPreferenceLanguage(user.getPreferenceLanguage());
        newUser.setRegion(user.getRegion());
        newUser.setName(user.getName());

        userRepository.save(newUser);
        return newUser;
    }

    @Transactional
    public String updateUserProfile(UserProfileDto profileDto) {
        User findUser = userRepository.findById(profileDto.getUserId());
        findUser.setProfilePictureUrl(profileDto.getProfilePictureUrl());
        userRepository.save(findUser);
        return findUser.getProfilePictureUrl();
    }

    @Transactional
    public String modifyPassword(UserChangePwDto pwDto) {
        String res = "";
        User user = userRepository.findById(pwDto.getUserId());
        if (user.getPassword().equals(pwDto.getCurrentPW())) {
            user.setPassword(pwDto.getNewPW());
            userRepository.save(user);
            res = "done";
        } else {
            res = "is not match!!!";
        }
        return res;
    }
}
