package com.ssafy.sowlmate.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "intimacy", uniqueConstraints = {
        @UniqueConstraint(name = "intimacy_uk", columnNames = {"from_user_no", "to_user_no"})
})
public class Intimacy {

    @Id @GeneratedValue
    @Column(name = "intimacy_id")
    private Long no;

    @JoinColumn(name = "from_user_no")
    @ManyToOne
    private User fromUser;

    @JoinColumn(name = "to_user_no")
    @ManyToOne
    private User toUser;

    private int eval;

    private LocalDateTime createDate;

    // create intimacy
    public static Intimacy createIntimacy(User fromUser, User toUser, int eval) {
        Intimacy intimacy = new Intimacy();
        intimacy.setFromUser(fromUser);
        intimacy.setToUser(toUser);
        intimacy.setEval(eval);
        intimacy.setCreateDate(LocalDateTime.now());
        return intimacy;
    }

    // business logic
    /**
     * 긍정 평가
     */
    public void positive(int amount) {
        if (amount <= 0) {
            throw new IllegalStateException("amount를 양수로 입력해주세요.");
        }
        if (getEval() == 100) {
            throw new IllegalStateException("이미 100점입니다.");
        }

        int resultAmount = getEval() + amount;
        if (resultAmount >= 100) {
            setEval(100);
        } else {
            setEval(resultAmount);
        }

    }
    /**
     * 부정 평가
     */
    public void negative(int amount) {
        if (amount <= 0) {
            throw new IllegalStateException("amount를 양수로 입력해주세요.");
        }
        if (getEval() == 0) {
            throw new IllegalStateException("이미 0점입니다.");
        }

        int resultAmount = getEval() - amount;
        if (resultAmount <= 0) {
            setEval(0);
        } else {
            setEval(resultAmount);
        }
    }
}
