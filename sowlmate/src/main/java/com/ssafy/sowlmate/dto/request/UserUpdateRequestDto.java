package com.ssafy.sowlmate.dto.request;

import com.ssafy.sowlmate.dto.UserUpdateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String userId;
    private UserUpdateDto user;
}
