package com.ssafy.sowlmate.dto.response;

import com.ssafy.sowlmate.entity.Penpal;
import com.ssafy.sowlmate.entity.type.InterestType;
import com.ssafy.sowlmate.entity.type.LanguageType;
import com.ssafy.sowlmate.entity.type.RegionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PenpalResponseDto {
    private String toUserId;
    private String toUserNickname;
    private RegionType region;
    private LanguageType language;
    private LanguageType preferenceLanguage;
    private List<InterestType> interests;
    private String profilePictureUrl;
    private int intimacyEval;

    public static PenpalResponseDto toDto(Penpal penpal) {
        PenpalResponseDto dto = new PenpalResponseDto();
        dto.setToUserId(penpal.getToUser().getId());
        dto.setToUserNickname(penpal.getToUser().getNickname());
        dto.setRegion(penpal.getToUser().getRegion());
        dto.setLanguage(penpal.getToUser().getLanguage());
        dto.setPreferenceLanguage(penpal.getToUser().getPreferenceLanguage());
        List<InterestType> tmpInterest = new ArrayList<>();
        penpal.getToUser().getInterests().stream().forEach(i-> tmpInterest.add(i.getTitle()));
        dto.setInterests(tmpInterest);
        dto.setProfilePictureUrl(penpal.getToUser().getProfilePictureUrl());
        return dto;
    }
}
