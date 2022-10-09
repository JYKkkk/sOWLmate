//package com.ssafy.sowlmate.dto.response;
//
//import com.ssafy.sowlmate.entity.Interest;
//import com.ssafy.sowlmate.entity.User;
//import com.ssafy.sowlmate.entity.type.LanguageType;
//import com.ssafy.sowlmate.entity.type.RegionType;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter @Setter
//@NoArgsConstructor
//public class UserResponseDto {
//    private String id;
//    private String nickname;
//    private RegionType region;
//    private LanguageType language;
//    private LanguageType preferenceLanguage;
//    private List<Interest> interests;
//
//    public static UserResponseDto toDto(User user) {
//        UserResponseDto userResponseDto = new UserResponseDto();
//        userResponseDto.setId(user.getId());
//        userResponseDto.setNickname(user.getNickname());
//        userResponseDto.setRegion(user.getRegion());
//        userResponseDto.setLanguage(user.getLanguage());
//        userResponseDto.setPreferenceLanguage(user.getPreferenceLanguage());
//        userResponseDto.setInterests(user.getInterests());
//        return userResponseDto;
//    }
//}
