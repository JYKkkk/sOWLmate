package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.type.InterestType;
import com.ssafy.sowlmate.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class InterestRepositoryCustomImpl implements InterestRepositoryCustom {

    private final EntityManager em;

    @Override
    @Transactional
    public int deleteByUserAndType(User user, InterestType title) {
        return em.createQuery("delete from Interest i where i.user=:user and i.title=:title")
                .setParameter("user", user)
                .setParameter("title", title).executeUpdate();
    }
}
