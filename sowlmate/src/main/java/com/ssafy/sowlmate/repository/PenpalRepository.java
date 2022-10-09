package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.Penpal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PenpalRepository extends JpaRepository<Penpal, Long> {
    Penpal findPenpalByFromUserNoAndToUserNo(long fromUserNo, long toUserNo);

    @Modifying
    @Transactional
    void deleteByFromUserNoAndToUserNo(long fromUserNo, long toUserNo);

    @Modifying
    @Transactional
    int deleteByFromUserIdAndToUserId(String fromUserId, String toUserId);

    List<Penpal> findAllByFromUserNo(long fromUserNo);
    List<Penpal> findAllByFromUserId(String fromUserId);

    Penpal findByFromUserIdAndToUserId(String fromUserId, String toUserId);

    int deleteAllByFromUserId(String fromUserId);

    int deleteAllByToUserId(String toUserId);
}
