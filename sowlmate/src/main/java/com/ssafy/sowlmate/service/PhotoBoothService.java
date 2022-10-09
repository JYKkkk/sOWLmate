package com.ssafy.sowlmate.service;

import com.ssafy.sowlmate.entity.PhotoBooth;
import com.ssafy.sowlmate.repository.PhotoBoothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhotoBoothService {

    private final PhotoBoothRepository photoBoothRepository;

    /**
     * 전체 조회
     */
    public List<PhotoBooth> selectAll() {
        return photoBoothRepository.findAll();
    }

    /**
     * 유저 아이디 기반 전체 조회
     */
    public List<PhotoBooth> selectAllByUserId(String userId) {
        return photoBoothRepository.findAllByUserId(userId);
    }

    /**
     * 사진 번호 기반 단일 조회
     */
    public PhotoBooth selectByNo(Long no) {
        return photoBoothRepository.findByNo(no);
    }

    /**
     * 저장
     */
    @Transactional
    public PhotoBooth enrollPhotoBooth(PhotoBooth photoBooth) {
        return photoBoothRepository.save(photoBooth);
    }

    /**
     * 삭제
     */
    @Transactional
    public int deleteByNo(Long no) {
        return photoBoothRepository.deleteByNo(no);
    }
}
