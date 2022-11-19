package org.seoultech.fitnesspotential.domain.user.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Slf4j
public class UserPostRequest {

    @NotNull
    private Long socialId;

    @NotNull
    @Length(min = 1, max = 64)
    private String provider;

    @NotNull
    @Length(min = 1, max = 128)
    private String nickname;

    @NotNull
    @Length(min = 10, max = 256)
    private String profileImageUrl;

    @Builder
    public UserPostRequest(Long socialId, String provider, String nickname, String profileImageUrl) {
        this.socialId = socialId;
        this.provider = provider;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public static class UserPostRequestBuilder {

        private Long socialId;
        private String provider;
        private String nickname;
        private String profileImageUrl;

        public  UserPostRequestBuilder oAuth2User(OAuth2User oAuth2User) {
            Map<String, Object> attributes = oAuth2User.getAttributes();
            log.info("{}", attributes);
            socialId = (Long) attributes.get("socialId");
            provider = (String) attributes.get("provider");
            nickname = (String) attributes.get("nickname");
            profileImageUrl = (String) attributes.get("profileImageUrl");
            return this;
        }
    }
}
