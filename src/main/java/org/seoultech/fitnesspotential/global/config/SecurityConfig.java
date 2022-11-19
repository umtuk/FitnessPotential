package org.seoultech.fitnesspotential.global.config;

import org.seoultech.fitnesspotential.domain.user.service.impl.UserOAuth2Service;
import org.seoultech.fitnesspotential.domain.user.util.security.handler.OAuth2AuthenticationSuccessHandler;
import org.seoultech.fitnesspotential.global.util.secutiry.access.CommentOnlyMeAccess;
import org.seoultech.fitnesspotential.global.util.secutiry.access.CommunityOnlyMeAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserOAuth2Service oAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler successHandler;

    private final CommunityOnlyMeAccess communityOnlyMeAccess;
    private final CommentOnlyMeAccess commentOnlyMeAccess;

    @Autowired
    public SecurityConfig(UserOAuth2Service oAuth2UserService,
                          OAuth2AuthenticationSuccessHandler successHandler,
                          CommunityOnlyMeAccess communityOnlyMeAccess,
                          CommentOnlyMeAccess commentOnlyMeAccess) {
        this.oAuth2UserService = oAuth2UserService;
        this.successHandler = successHandler;
        this.communityOnlyMeAccess = communityOnlyMeAccess;
        this.commentOnlyMeAccess = commentOnlyMeAccess;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .authorizeRequests()

                .antMatchers("/", "/login/**").permitAll()

                .antMatchers(HttpMethod.GET, "/community/comment/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/community/comment/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/community/comment/**/{id}").access("hasRole(\"USER\") and @commentOnlyMeAccess.isMine(authentication, #id)")
                .antMatchers(HttpMethod.DELETE, "/community/comment/**/{id}").access("hasRole(\"USER\") and @commentOnlyMeAccess.isMine(authentication, #id)")

                .antMatchers(HttpMethod.GET, "/community/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/community/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/community/**/{id}").access("hasRole(\"USER\") and @communityOnlyMeAccess.isMine(authentication, #id)")
                .antMatchers(HttpMethod.DELETE, "/community/**/{id}").access("hasRole(\"USER\") and @communityOnlyMeAccess.isMine(authentication, #id)")

                .antMatchers("/user/**").hasRole("USER")

                .antMatchers("/**").denyAll()

                .and()
                .oauth2Login()
                .successHandler(successHandler)
                .userInfoEndpoint().userService(oAuth2UserService);

        return  http.build();
    }
}
