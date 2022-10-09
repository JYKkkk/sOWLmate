package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.Interest;
import com.ssafy.sowlmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long>, InterestRepositoryCustom {
    List<Interest> findAllByUser(User user);
}
