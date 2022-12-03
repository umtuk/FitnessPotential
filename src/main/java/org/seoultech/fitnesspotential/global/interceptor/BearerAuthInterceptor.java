package org.seoultech.fitnesspotential.global.interceptor;

import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.global.util.auth.AuthorizationExtractor;
import org.seoultech.fitnesspotential.global.util.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class BearerAuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;
    private final AuthorizationExtractor authExtractor;

    @Autowired
    public BearerAuthInterceptor(JwtProvider jwtProvider,
                                 AuthorizationExtractor authExtractor) {
        this.jwtProvider = jwtProvider;
        this.authExtractor = authExtractor;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(request.getRequestURI());
        String token = authExtractor.extract(request, "Bearer");
        log.info("{}", token);
        if (!StringUtils.hasLength(token)) {
            throw new JwtException("Token is not found.");
        }

        if (!jwtProvider.isValidAccessToken(token)) {
            throw new JwtException("Invalid token");
        }

        User user = jwtProvider.getAccessTokenPayload(token);
        request.setAttribute("user", user);
        log.info("{}", user);
        return true;
    }
}
