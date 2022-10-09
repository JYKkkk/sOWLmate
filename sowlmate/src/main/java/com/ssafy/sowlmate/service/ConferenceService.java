package com.ssafy.sowlmate.service;

import com.ssafy.sowlmate.dto.request.ConferenceRequestDto;
import com.ssafy.sowlmate.entity.*;
import com.ssafy.sowlmate.entity.type.InterestType;
import com.ssafy.sowlmate.entity.type.LanguageType;
import com.ssafy.sowlmate.entity.type.LockType;
import com.ssafy.sowlmate.repository.ConferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final UserService userService;
    private final InterestService interestService;

    public List<Conference> selectAll() {
        return conferenceRepository.findAll();
    }

    public List<Conference> selectByInterest(InterestType interest){
        return conferenceRepository.findAllByInterest(interest);
    }

    public  List<Conference> selectByLanguage(LanguageType language){
        return conferenceRepository.findAllByLanguage(language);
    }

    public List<Conference> selectByInterestAndLanguage(InterestType interest, LanguageType language){
        return conferenceRepository.findAllByInterestAndLanguage(interest, language);
    }

    @Transactional
    public Conference createConference(Conference conference){
        Conference newConference = new Conference();
        newConference.setTitle(conference.getTitle());
        newConference.setOwnerId(conference.getOwnerId());
        newConference.setInterest(conference.getInterest());
        newConference.setLanguage(conference.getLanguage());
        newConference.setLocks(conference.getLocks());
        newConference.setThumbnail(conference.getThumbnail());
        if(newConference.getLocks().equals(LockType.LOCK)){
          newConference.setPassword(conference.getPassword());
        }

        return conferenceRepository.save(newConference);
    }

    @Transactional
    public Conference enterConference (ConferenceRequestDto conferenceRequestDto){
        Conference findConference = conferenceRepository.findByNo(conferenceRequestDto.getConferenceNo());
        findConference.setParticipantId(conferenceRequestDto.getUserId());
        return findConference;
    }

    /**
     * delete or exit
     */
    @Transactional
    public Optional<?> deleteOrExitConference(ConferenceRequestDto conferenceRequestDto) {
        Conference findConference = conferenceRepository.findByNo(conferenceRequestDto.getConferenceNo());
        if (findConference.getOwnerId().equals(conferenceRequestDto.getUserId())) {
            return Optional.of(conferenceRepository.deleteByNo(conferenceRequestDto.getConferenceNo()));
        } else {
            findConference.setParticipantId(null);
            return Optional.of("SUCCESS : participant out");
        }
    }
}
