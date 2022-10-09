package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User save(User user);

    public User findByNo(Long no);

    public User findById(String userId);

//    public Optional<User> findById(String userId);

    public User findByNickname(String nickname);

    public List<User> findAll();

    public int deleteById(String userId);

    public User findByIdAndName(String userId, String UserName);

}
