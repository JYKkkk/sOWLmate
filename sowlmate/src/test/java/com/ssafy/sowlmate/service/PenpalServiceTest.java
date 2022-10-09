//package com.ssafy.sowlmate.service;
//
//import com.ssafy.sowlmate.entity.User;
//import com.ssafy.sowlmate.entity.type.LanguageType;
//import com.ssafy.sowlmate.entity.type.RegionType;
//import com.ssafy.sowlmate.repository.PenpalRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class PenpalServiceTest {
//
//    @Autowired EntityManager em;
//    @Autowired PenpalService penpalService;
//    @Autowired PenpalRepository penpalRepository;
//    @Autowired UserService userService;
//
//    @Test
//    public void 펜팔등록() throws Exception {
//        //given
//        User user1 = createUser("user1", "1234", "user1", RegionType.ASIA, LanguageType.KOREAN);
//        User user2 = createUser("user2", "1234", "user2", RegionType.ASIA, LanguageType.KOREAN);
//        User user3 = createUser("user3", "1234", "user3", RegionType.ASIA, LanguageType.KOREAN);
//
//        userService.enroll(user1);
//        userService.enroll(user2);
//        userService.enroll(user3);
//
//        //when
//        penpalService.enrollPenpalByUserNo(user1.getNo(), user2.getNo());
//        penpalService.enrollPenpalByUserNo(user1.getNo(), user3.getNo());
//        penpalService.enrollPenpalByUserNo(user2.getNo(), user3.getNo());
//
//        //then
//        assertEquals("펜팔 등록 여부 확인", 2, penpalService.selectAllByFromUserNo(user1.getNo()).size());
//    }
//
//    @Test
//    public void 펜팔조회() throws Exception {
//        //given
//        User user1 = createUser("user1", "1234", "user1", RegionType.ASIA, LanguageType.KOREAN);
//        User user2 = createUser("user2", "1234", "user2", RegionType.ASIA, LanguageType.KOREAN);
//        userService.enroll(user1);
//        userService.enroll(user2);
//
//        //when
//        penpalService.enrollPenpalByUserNo(user1.getNo(), user2.getNo());
//
//        //then
//        assertEquals("펜팔 개수 확인", 2, penpalService.selectAll().size());
//    }
//
//    @Test
//    public void 펜팔삭제() throws Exception {
//        //given
//        User user1 = createUser("user1", "1234", "user1", RegionType.ASIA, LanguageType.KOREAN);
//        User user2 = createUser("user2", "1234", "user2", RegionType.ASIA, LanguageType.KOREAN);
//        userService.enroll(user1);
//        userService.enroll(user2);
//
//        penpalService.enrollPenpalByUserNo(user1.getNo(), user2.getNo());
//
//        //when
//        penpalService.deletePenpalByUserNo(user1.getNo(), user2.getNo());
//
//        //then
//        assertEquals("펜팔 개수 확인", 0, penpalService.selectAll().size());
//    }
//
//    private User createUser(String id, String pass, String ni, RegionType re, LanguageType language) {
//        User user = new User();
//        user.setId(id);
//        user.setPassword(pass);
//        user.setNickname(ni);
//        user.setRegion(re);
//        user.setLanguage(language);
//
//        return user;
//    }
//}