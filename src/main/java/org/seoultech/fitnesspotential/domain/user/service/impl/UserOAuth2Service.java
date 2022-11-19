package org.seoultech.fitnesspotential.domain.user.service.impl;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.seoultech.fitnesspotential.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserOAuth2Service extends DefaultOAuth2UserService {

    private final HttpSession httpSession;
    private final UserRepository userRepository;

    @Autowired
    public UserOAuth2Service(HttpSession httpSession, UserRepository userRepository) {
        this.httpSession = httpSession;
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);

        Long socialId = (Long) oAuth2User.getAttributes().get("id");
        String provider = userRequest.getClientRegistration().getRegistrationId();

        Map<String, Object> kakaoProfile = (Map<String, Object>) oAuth2User.getAttributes().get("properties");
        String nickname = (String) kakaoProfile.get("nickname");
        String profileImageUrl = (String) kakaoProfile.get("profile_image");

        Map<String, Object> userAttributes = new HashMap<>();
        userAttributes.put("socialId", socialId);
        userAttributes.put("provider", provider);
        userAttributes.put("nickname", nickname);
        userAttributes.put("profileImageUrl", profileImageUrl);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                userAttributes, "socialId");
    }
}