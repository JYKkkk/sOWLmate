package com.ssafy.sowlmate.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BlackListResponseDto {
    private Long no;
    private String fromUserId;
    private String toUserId;
}
