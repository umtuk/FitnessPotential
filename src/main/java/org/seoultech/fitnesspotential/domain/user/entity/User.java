package org.seoultech.fitnesspotential.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.user.dto.UserPostRequest;
import org.seoultech.fitnesspotential.domain.user.dto.UserPutRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "user")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nickname", nullable = false, length = 128)
    private String nickname;

    @Column(name = "social_id", nullable = false)
    private Long socialId;

    @Column(name = "provider", nullable = false, length = 64)
    private String provider;

    @Column(name = "profile_image_url", nullable = false, length = 256)
    private String profileImageUrl;

    @Column(name = "refresh_token", length = 512)
    private String refreshToken;

    @Builder
    public User(Long id, String nickname, Long socialId, String provider, String profileImageUrl, String refreshToken) {
        this.id = id;
        this.nickname = nickname;
        this.socialId = socialId;
        this.provider = provider;
        this.profileImageUrl = profileImageUrl;
        this.refreshToken = refreshToken;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return socialId + provider;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static class UserBuilder {

        private Long id;
        private String nickname;
        private Long socialId;
        private String provider;
        private String profileImageUrl;
        private String refreshToken;

        public UserBuilder user(User user) {
            this.id = user.id;
            this.nickname = user.nickname;
            this.socialId = user.socialId;
            this.provider = user.provider;
            this.profileImageUrl = user.profileImageUrl;
            this.refreshToken = user.refreshToken;
            return this;
        }

        public UserBuilder userPostRequest(UserPostRequest userPostRequest) {
            this.nickname = userPostRequest.getNickname();
            this.socialId = userPostRequest.getSocialId();
            this.provider = userPostRequest.getProvider();
            this.profileImageUrl = userPostRequest.getProfileImageUrl();
            return this;
        }

        public UserBuilder userPutRequest(UserPutRequest userPutRequest) {
            this.nickname = userPutRequest.getNickname() == null ? this.nickname : userPutRequest.getNickname();
            this.profileImageUrl = userPutRequest.getProfileImageUrl() == null ? this.profileImageUrl : userPutRequest.getProfileImageUrl();
            return this;
        }
    }
}
