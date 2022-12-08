package org.seoultech.fitnesspotential.domain.user.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.seoultech.fitnesspotential.domain.user.dto.UserPostRequest;
import org.seoultech.fitnesspotential.domain.user.dto.UserPutRequest;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.seoultech.fitnesspotential.global.util.jwt.JwtProvider;
import org.seoultech.fitnesspotential.global.util.jwt.JwtUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Value("${spring.security.oauth2.client.provider.kakao.user-info-uri}")
    private String userInfoUri;

    @Autowired
    public UserController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @GetMapping("/my")
    public ResponseEntity<User> getUser(@RequestAttribute(name = "user") User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<JwtUnit> login(String accessToken) throws IOException {

        URL url = new URL(userInfoUri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        int responseCode = conn.getResponseCode();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        String result = "";
        while ((line = br.readLine()) != null) {
            result += line;
        }

        log.info("{}", result);

        JsonElement element = JsonParser.parseString(result);

        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
        String profile_image = properties.getAsJsonObject().get("profile_image").getAsString();
        String provider = "kakaoRest";
        Long socialId = Long.parseLong(element.getAsJsonObject().get("id").toString());

        User user;
        if (!userService.existsBySocialIdAndProvider(socialId, provider)) {
            UserPostRequest userPostRequest = UserPostRequest.builder()
                    .nickname(nickname)
                    .profileImageUrl(profile_image)
                    .provider(provider)
                    .build();
            user = userService.postUser(userPostRequest);
        }
        else {
            Long id = userService.getUserBySocialIdAndProvider(socialId, provider).getId();
            UserPutRequest userPutRequest = UserPutRequest.builder()
                    .nickname(nickname)
                    .profileImageUrl(profile_image)
                    .build();
            user = userService.putUser(userPutRequest, id);
        }

        return new ResponseEntity<>(jwtProvider.createJwtUnit(user), HttpStatus.OK);
    }
}
