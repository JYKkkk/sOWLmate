//package com.ssafy.sowlmate.repository;
//
//import com.ssafy.sowlmate.entity.Interest;
//import com.ssafy.sowlmate.entity.type.InterestType;
//import com.ssafy.sowlmate.entity.User;
//import com.ssafy.sowlmate.entity.UserLanStatus;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class InterestRepositoryTest {
//
//    @Autowired UserRepository userRepository;
//    @Autowired InterestRepository interestRepository;
//
//    @Test
//    @Rollback(value = false)
//    public void enroll_interest() {
//        // given
////        User user = new User();
////        user.setId("user2");
////        user.setPassword("1234");
////        user.setNickname("user2");
////        user.setRegion("KOREA");
////        user.setLanguage(UserLanStatus.KOREAN);
//
//        User user1 = userRepository.findById("user1");
////
////        Interest interest = new Interest();
////        interest.setTitle(InterestType.MUSIC);
////        interest.setContents("Dynamite...");
////        interest.setUser(user1);
//
//        // when
////        User saveUser = userRepository.save(user);
////        Interest saveInterest = interestRepository.save(interest);
//
//        // then
////        assertEquals("유저 등록 잘 됐는지 확인", "user1", saveUser.getId());
////        assertEquals("관심사 등록 잘 됐는지 확인", interest.getTitle(), saveInterest.getTitle());
//        assertEquals("유저에 관심사 잘 등록 됐는지 확인", 2,
//                interestRepository.findAllByUser(user1).size());
//    }
//
//}