package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {
    Letter findByNo(Long letterNo);
    List<Letter> findAllByToUserId(String toUserId);

    int deleteAllByFromUserId(String fromUserId);

    int deleteAllByToUserId(String toUserId);
}
