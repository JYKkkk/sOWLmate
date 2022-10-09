//package com.ssafy.sowlmate.configuration.auth;
//
//
//import com.ssafy.sowlmate.entity.User;
//import com.ssafy.sowlmate.entity.type.RegionType;
//import com.ssafy.sowlmate.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpSession;
//
//import java.util.Map;
//
//@RequiredArgsConstructor
//@Service
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    private final UserRepository userRepository;
//    private final HttpSession httpSession;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2UserService delegate = new DefaultOAuth2UserService();
//        OAuth2User oAuth2User = delegate.loadUser(userRequest);
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//        String registrationId = userRequest.getClientRegistration().getRegistrationId();
//        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
//                .getUserInfoEndpoint().getUserNameAttributeName();
//
//        User user = new User();
//        user.setId(attributes.get("sub").toString());
//        user.setPassword("");
//        user.setNickname("");
//        user.setRegion(RegionType.ASIA);
////        User user = User.builder().id(attributes.get("sub").toString())
////                .email("")
////                .password("")
////                .nickname("")
////                .region(RegionType.ASIA)
////                .build();
////        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
//
//        OAuth2User saveUser = saveOrUpdate(user);
////        httpSession.setAttribute("user", new SessionUser(user));
//
//        return saveUser;
//    }
//
//
//    private OAuth2User saveOrUpdate(User newUser) {
//        User findUser = userRepository.findById(newUser.getId());
////        User user = findUser
////                .map(update ->update.updateUser (newUser))
////                .orElse(newUser);
//
//        return findUser==null? userRepository.save(newUser) : userRepository.save(findUser);
//    }
//}
//
