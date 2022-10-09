package com.ssafy.sowlmate;

import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.repository.UserRepository;
import com.ssafy.sowlmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class SowlmateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SowlmateApplication.class, args);
    }

}
