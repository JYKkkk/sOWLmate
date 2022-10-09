package com.ssafy.sowlmate.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "blacklist", uniqueConstraints = {
        @UniqueConstraint(name = "blacklist_uk", columnNames = {"from_user_no", "to_user_no"})
})
public class BlackList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blacklist_no")
    private Long no;

    @JoinColumn(name = "from_user_no")
    @ManyToOne
    private User fromUser;

    @JoinColumn(name = "to_user_no")
    @ManyToOne
    private User toUser;

    @Builder
    public BlackList(User fromUser, User toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}

