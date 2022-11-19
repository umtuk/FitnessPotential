package org.seoultech.fitnesspotential.domain.user.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class UserPutRequest {

    @NotNull
    @Length(min = 1, max = 128)
    private String nickname;

    @NotNull
    @Length(min = 10, max = 256)
    private String profileImageUrl;

    @Builder
    public UserPutRequest(String nickname, String profileImageUrl) {
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public static class UserPutRequestBuilder {

        private String nickname;
        private String profileImageUrl;

        public UserPutRequestBuilder oAuth2User(OAuth2User oAuth2User) {
            Map<String, Object> attributes = oAuth2User.getAttributes();
            nickname = (String) attributes.get("nickname");
            profileImageUrl = (String) attributes.get("profileImageUrl");
            return this;
        }
    }
}
