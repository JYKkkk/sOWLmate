package com.ssafy.sowlmate.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PenpalShortResponseDto {
    private String fromUserId;
    private String toUserId;
}
