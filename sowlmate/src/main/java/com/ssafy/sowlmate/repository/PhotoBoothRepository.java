package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.PhotoBooth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoBoothRepository extends JpaRepository<PhotoBooth, Long> {
    List<PhotoBooth> findAllByUserId(String userId);

    PhotoBooth findByNo(Long no);

    int deleteByNo(Long no);
}
