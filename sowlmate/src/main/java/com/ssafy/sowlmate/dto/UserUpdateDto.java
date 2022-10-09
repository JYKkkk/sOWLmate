package com.ssafy.sowlmate.dto;

import com.ssafy.sowlmate.entity.type.LanguageType;
import com.ssafy.sowlmate.entity.type.RegionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserUpdateDto {
    private String nickname;
    private RegionType region;
    private LanguageType language;
    private LanguageType preferenceLanguage;
    private String name;
}
