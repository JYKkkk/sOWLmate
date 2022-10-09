package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.Intimacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntimacyRepository extends JpaRepository<Intimacy, Long> {

    List<Intimacy> findAllByFromUserId(String fromUserId);

    Intimacy findByFromUserIdAndToUserId(String fromUserId, String toUserId);

    int deleteAllByFromUserId(String fromUserId);

    int deleteAllByToUserId(String toUserId);
}
