package com.ssafy.sowlmate.entity;

import com.ssafy.sowlmate.entity.type.InterestType;
import com.ssafy.sowlmate.entity.type.LanguageType;
import com.ssafy.sowlmate.entity.type.LockType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Conference {

    @Id @GeneratedValue
    @Column(name = "conference_id")
    private Long no;

    @NotNull
    private String title;

    @NotNull
    private String ownerId;

    private String participantId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private InterestType interest;

    @NotNull
    @Enumerated(EnumType.STRING)
    private LanguageType language;

    @NotNull
    @Enumerated(EnumType.STRING)
    private LockType locks;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String thumbnail;

    private LocalDateTime timeRecordStart;

}
