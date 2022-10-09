package com.ssafy.sowlmate.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class IntimacyResponseDto {
    private String fromUserId;
    private String toUserId;
    private int eval;
}
