package com.ssafy.sowlmate.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserProfileDto {
    private String userId;
    private String profilePictureUrl;
}
