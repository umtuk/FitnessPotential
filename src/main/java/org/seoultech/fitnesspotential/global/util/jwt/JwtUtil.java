package org.seoultech.fitnesspotential.global.util.jwt;

import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {

    public String generateAccessToken(OAuth2User oAuth2User) {
        return null;
    }

    public String resolveToken(HttpServletRequest request) {
        return null;
    }

    public Authentication getAuthentication(String accessToken) {
        return null;
    }
}
