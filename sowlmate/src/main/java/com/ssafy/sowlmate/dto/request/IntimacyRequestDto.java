package com.ssafy.sowlmate.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class IntimacyRequestDto {
    private String fromUserId;
    private String toUserId;
    private int eval;
    private int meetingTime;
}
