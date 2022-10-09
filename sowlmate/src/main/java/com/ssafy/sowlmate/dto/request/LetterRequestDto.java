package com.ssafy.sowlmate.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LetterRequestDto {
    private String fromUserId;
    private String toUserId;
    private String title;
    private String content;
    private Long letterNo;
    private String writingPad;
    private String writingFont;
}
