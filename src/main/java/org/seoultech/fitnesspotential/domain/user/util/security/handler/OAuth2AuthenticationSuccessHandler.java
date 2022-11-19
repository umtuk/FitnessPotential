package org.seoultech.fitnesspotential.domain.user.util.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.seoultech.fitnesspotential.domain.user.dto.UserPostRequest;
import org.seoultech.fitnesspotential.domain.user.dto.UserPutRequest;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final UserService userService;
    private final HttpSession session;

    public OAuth2AuthenticationSuccessHandler(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Long socialId = (Long) oAuth2User.getAttribute("socialId");
        String provider = (String) oAuth2User.getAttribute("provider");
        User user;
        if (!userService.existsBySocialIdAndProvider(socialId, provider)) {
            UserPostRequest userPostRequest = UserPostRequest.builder()
                    .oAuth2User(oAuth2User)
                    .build();
            user = userService.postUser(userPostRequest);
        }
        else {
            Long id = userService.getUserBySocialIdAndProvider(socialId, provider).getId();
            UserPutRequest userPutRequest = UserPutRequest.builder()
                    .oAuth2User(oAuth2User)
                    .build();
            user = userService.putUser(userPutRequest, id);
        }
        session.setAttribute("user", user);
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", "/");
    }
}
