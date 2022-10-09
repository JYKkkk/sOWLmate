package com.ssafy.sowlmate.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserRequestDto {
    private String userId;
    private String userNickname;
}
