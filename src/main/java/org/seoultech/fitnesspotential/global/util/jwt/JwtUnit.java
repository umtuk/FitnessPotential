package org.seoultech.fitnesspotential.global.util.jwt;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class JwtUnit {

    private String accessToken;
    private Long accessTokenExpiresIn;

    private String refreshToken;
    private Long refreshTokenExpiresIn;

    @Builder
    public JwtUnit(String accessToken, Long accessTokenExpiresIn, String refreshToken, Long refreshTokenExpiresIn) {
        this.accessToken = accessToken;
        this.accessTokenExpiresIn = accessTokenExpiresIn;
        this.refreshToken = refreshToken;
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    }
}
