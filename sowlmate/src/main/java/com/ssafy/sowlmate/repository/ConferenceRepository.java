package com.ssafy.sowlmate.repository;

import com.ssafy.sowlmate.entity.Conference;
import com.ssafy.sowlmate.entity.type.InterestType;
import com.ssafy.sowlmate.entity.type.LanguageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    Conference findByNo(long conferenceNo);

    List<Conference> findAllByInterest(InterestType interest);

    List<Conference> findAllByLanguage(LanguageType language);

    List<Conference> findAllByInterestAndLanguage(InterestType interest, LanguageType language);

    int deleteByNo(long conferenceNo);

}
