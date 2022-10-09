package com.ssafy.sowlmate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.sowlmate.entity.type.InterestType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Interest {

    @Id @GeneratedValue
    @Column(name = "interest_id")
    private Long no;

    @Enumerated(EnumType.STRING)
    private InterestType title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
