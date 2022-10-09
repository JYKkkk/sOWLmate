package com.ssafy.sowlmate.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class IntimacyShortResponseDto {
    private String toUserId;
    private int eval;
}
