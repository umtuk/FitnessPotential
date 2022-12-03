package org.seoultech.fitnesspotential.global.util.jwt;

import com.google.gson.Gson;
import io.jsonwebtoken.*;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    @Value("${jwt.access-token.expires-in}")
    private Long accessTokenExpiresIn;
    @Value("${jwt.refresh-token.expires-in}")
    private Long refreshTokenExpiresIn;
    @Value("${jwt.access-token.secret-key}")
    private String accessTokenSecretKey;
    @Value("${jwt.refresh-token.secret-key}")
    private String refreshTokenSecretKey;

    public String createAccessToken(User payload) {
        return createToken(payload, accessTokenExpiresIn, accessTokenSecretKey);
    }

    public String createRefreshToken(User payload) {
        return createToken(payload, refreshTokenExpiresIn, refreshTokenSecretKey);
    }

    public JwtUnit createJwtUnit(User payload) {
        return JwtUnit.builder()
                .accessToken(createAccessToken(payload))
                .accessTokenExpiresIn(accessTokenExpiresIn)
                .refreshToken(createRefreshToken(payload))
                .refreshTokenExpiresIn(refreshTokenExpiresIn)
                .build();
    }

    private String createToken(User payload, Long expiresIn, String secretKey) {
        Claims claims = Jwts.claims().setSubject(new Gson().toJson(payload));
        Date now = new Date();
        Date expiresDate = new Date(now.getTime() + expiresIn);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiresDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public User getAccessTokenPayload(String token) {
        return getPayload(token, accessTokenSecretKey);
    }

    public User getRefreshTokenPayload(String token) {
        return getPayload(token, refreshTokenSecretKey);
    }

    private User getPayload(String token, String secretKey) {
        try {
            String payload = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return new Gson().fromJson(payload, User.class);
        } catch (ExpiredJwtException e) {
            return null;
        } catch (JwtException e) {
            throw e;
        }
    }

    public Boolean isValidAccessToken(String token) {
        return isValidToken(token, accessTokenSecretKey);
    }

    public Boolean isValidRefreshToken(String token) {
        return isValidToken(token, refreshTokenSecretKey);
    }

    private Boolean isValidToken(String token, String secretKey) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
