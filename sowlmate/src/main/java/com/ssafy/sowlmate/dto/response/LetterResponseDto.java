package com.ssafy.sowlmate.dto.response;

import com.ssafy.sowlmate.entity.Letter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class LetterResponseDto {
    private Long no;
    private String fromUserId;
    private String fromUserNickname;
    private String toUserId;
    private String toUserNickname;
    private String title;
    private String content;
    private String writingPad;
    private String writingFont;
    private LocalDateTime createDate;
    private boolean favorite;
    private boolean read;

    public static LetterResponseDto toDto(Letter letter) {
        LetterResponseDto dto = new LetterResponseDto();
        dto.setNo(letter.getNo());
        dto.setFromUserId(letter.getFromUserId());
        dto.setFromUserNickname(letter.getFromUserNickname());
        dto.setToUserId(letter.getToUserId());
        dto.setToUserNickname(letter.getToUserNickname());
        dto.setTitle(letter.getTitle());
        dto.setContent(letter.getContent());
        dto.setWritingPad(letter.getWritingPad());
        dto.setWritingFont(letter.getWritingFont());
        dto.setCreateDate(letter.getCreateDate());
        dto.setFavorite(letter.isFavorite());
        dto.setRead(letter.isRead());
        return dto;
    }
}
