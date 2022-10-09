package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Long> {
    public BlackList findByFromUserNoAndToUserNo(long fromUserNo, long toUserNo);

    public BlackList findByFromUserIdAndToUserId(String fromUserId, String toUserId);

    @Modifying
    @Transactional
    public void deleteByFromUserNoAndToUserNo(long fromUserNo, long toUserNo);

    @Modifying
    @Transactional
    public int deleteByFromUserIdAndToUserId(String fromUserId, String toUserId);

    List<BlackList> findAllByFromUserNo(long fromUserNo);

    List<BlackList> findAllByFromUserId(String fromUserId);
}
