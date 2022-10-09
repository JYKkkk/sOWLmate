package com.ssafy.sowlmate.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Letter {
    @Id @GeneratedValue
    @Column(name = "letter_id")
    private Long no;

    @NotNull
    private String fromUserId;
    @NotNull
    private String toUserId;

    @NotNull
    private String fromUserNickname;
    @NotNull
    private String toUserNickname;

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private boolean isRead = false;
    @NotNull
    private boolean isFavorite = false;
    @NotNull
    private String writingPad;
    @NotNull
    private String writingFont;

    private LocalDateTime createDate;

    // Create Letter
    public static Letter createLetter(String fromUserId, String toUserId,
                                      String fromUserNickname, String toUserNickname,
                                      String title, String content, String writingPad, String writingFont) {
        Letter letter = new Letter();
        letter.setFromUserId(fromUserId);
        letter.setToUserId(toUserId);
        letter.setFromUserNickname(fromUserNickname);
        letter.setToUserNickname(toUserNickname);
        letter.setTitle(title);
        letter.setContent(content);
        letter.setWritingPad(writingPad);
        letter.setWritingFont(writingFont);
        letter.setCreateDate(LocalDateTime.now());
        return letter;
    }

    // Business Logic
    public boolean read() {
        setRead(true);
        return this.isRead;
    }

    public boolean favoriteOn() {
        setFavorite(true);
        return this.isFavorite;
    }

    public boolean favoriteOff() {
        setFavorite(false);
        return this.isFavorite;
    }
}
