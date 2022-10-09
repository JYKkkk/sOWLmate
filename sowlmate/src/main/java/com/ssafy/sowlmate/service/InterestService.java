package com.ssafy.sowlmate.service;

import com.ssafy.sowlmate.entity.Interest;
import com.ssafy.sowlmate.entity.type.InterestType;
import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.exception.ExistValueException;
import com.ssafy.sowlmate.repository.InterestRepository;
import com.ssafy.sowlmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InterestService {

    private final InterestRepository interestRepository;
    private final UserRepository userRepository;

    public List<Interest> selectAll() {
        return interestRepository.findAll();
    }

    @Transactional
    public Interest enrollInterest(String userId, Interest interest) {
        User findUser = userRepository.findById(userId);
        List<Interest> interests = findUser.getInterests();

        // 관심사 중복 체크
        for (Interest inter : interests) {
            if (inter.getTitle().equals(interest.getTitle())) {
                throw new ExistValueException();
            }
        }

        interest.setUser(findUser);
        return interestRepository.save(interest);
    }

    @Transactional
    public int deleteInterest(String userId, InterestType title) {
        User findUser = userRepository.findById(userId);
        // 유저가 같고, 관심사 타입이 같은 경우를 찾아 삭제한다.
        // jpql 활용할 예정
        return interestRepository.deleteByUserAndType(findUser, title);
    }
}
