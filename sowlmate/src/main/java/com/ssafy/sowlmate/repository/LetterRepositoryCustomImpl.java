//package com.ssafy.sowlmate.repository;
//
//import com.ssafy.sowlmate.entity.Letter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@RequiredArgsConstructor
//public class LetterRepositoryCustomImpl implements LetterRepositoryCustom {
//
//    private final EntityManager em;
//
//    /**
//     * 받은 편지 전체 리스트 (내가 설정한 블랙리스트가 보낸 편지는 가져오지 않는다.)
//     * 블랙리스트-유저 구조 변경 후 재구성할 예정
//     */
//    @Override
//    @Transactional
//    public List<Letter> findAllByToUserId(String toUserId) {
//        return em.createQuery("select l from Letter l join fetch l.toUser t where l.toUser.id=:toUserId", Letter.class)
//                .setParameter("toUserId", toUserId).getResultList();
//    }
//}
