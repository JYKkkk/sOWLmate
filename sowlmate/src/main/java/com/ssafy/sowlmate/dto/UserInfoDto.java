package com.ssafy.sowlmate.dto;

import com.ssafy.sowlmate.entity.Interest;
import com.ssafy.sowlmate.entity.type.RegionType;
import com.ssafy.sowlmate.entity.User;
import com.ssafy.sowlmate.entity.type.LanguageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class UserInfoDto {

    private String id;
    private String nickname;
    private RegionType region;
    private LanguageType language;
    private LanguageType preferenceLanguage;
    private String profilePictureUrl;
    private List<Interest> interests;

    public static UserInfoDto toDto(User user) {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(user.getId());
        userInfoDto.setNickname(user.getNickname());
        userInfoDto.setRegion(user.getRegion());
        userInfoDto.setLanguage(user.getLanguage());
        userInfoDto.setPreferenceLanguage(user.getPreferenceLanguage());
        userInfoDto.setProfilePictureUrl(user.getProfilePictureUrl());
        userInfoDto.setInterests(user.getInterests());
        return userInfoDto;
    }

}
