package org.seoultech.fitnesspotential.global.config;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.seoultech.fitnesspotential.domain.user.service.impl.UserOAuth2Service;
import org.seoultech.fitnesspotential.domain.user.util.security.handler.OAuth2AuthenticationSuccessHandler;
import org.seoultech.fitnesspotential.global.util.secutiry.access.*;
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
    private final FitnessDiaryOnlyMeAccess fitnessDiaryOnlyMeAccess;
    private final FitnessInfoOnlyMeAccess fitnessInfoOnlyMeAccess;
    private final FitnessRoutineOnlyMeAccess fitnessRoutineOnlyMeAccess;
    private final FitnessUnitOnlyMeAccess fitnessUnitOnlyMeAccess;
    private final FoodDiaryOnlyMeAccess foodDiaryOnlyMeAccess;

    @Autowired
    public SecurityConfig(UserOAuth2Service oAuth2UserService,
                          OAuth2AuthenticationSuccessHandler successHandler,
                          CommunityOnlyMeAccess communityOnlyMeAccess,
                          CommentOnlyMeAccess commentOnlyMeAccess,
                          FitnessDiaryOnlyMeAccess fitnessDiaryOnlyMeAccess,
                          FitnessInfoOnlyMeAccess fitnessInfoOnlyMeAccess,
                          FitnessRoutineOnlyMeAccess fitnessRoutineOnlyMeAccess,
                          FitnessUnitOnlyMeAccess fitnessUnitOnlyMeAccess,
                          FoodDiaryOnlyMeAccess foodDiaryOnlyMeAccess) {
        this.oAuth2UserService = oAuth2UserService;
        this.successHandler = successHandler;
        this.communityOnlyMeAccess = communityOnlyMeAccess;
        this.commentOnlyMeAccess = commentOnlyMeAccess;
        this.fitnessDiaryOnlyMeAccess = fitnessDiaryOnlyMeAccess;
        this.fitnessInfoOnlyMeAccess = fitnessInfoOnlyMeAccess;
        this.fitnessRoutineOnlyMeAccess = fitnessRoutineOnlyMeAccess;
        this.fitnessUnitOnlyMeAccess = fitnessUnitOnlyMeAccess;
        this.foodDiaryOnlyMeAccess = foodDiaryOnlyMeAccess;
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

                .antMatchers(HttpMethod.GET, "/fitness/diary/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/fitness/diary/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/fitness/diary/**/{id}").access("hasRole(\"USER\") and @fitnessDiaryOnlyMeAccess.isMine(authentication, #id)")
                .antMatchers(HttpMethod.DELETE, "/fitness/diary/**/{id}").access("hasRole(\"USER\") and @fitnessDiaryOnlyMeAccess.isMine(authentication, #id)")

                .antMatchers(HttpMethod.GET, "/fitness/info/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/fitness/info/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/fitness/info/**/{id}").access("hasRole(\"USER\") and @fitnessInfoOnlyMeAccess.isMine(authentication, #id)")
                .antMatchers(HttpMethod.DELETE, "/fitness/info/**/{id}").access("hasRole(\"USER\") and @fitnessInfoOnlyMeAccess.isMine(authentication, #id)")

                .antMatchers(HttpMethod.GET, "/fitness/routine/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/fitness/routine/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/fitness/routine/{id}").access("hasRole(\"USER\") and @fitnessRoutineOnlyMeAccess.isMine(authentication, #id)")
                .antMatchers(HttpMethod.DELETE, "/fitness/routine/{id}").access("hasRole(\"USER\") and @fitnessRoutineOnlyMeAccess.isMine(authentication, #id)")

                .antMatchers(HttpMethod.PUT, "/fitness/routine/unit/{id}").access("hasRole(\"USER\") and @fitnessUnitOnlyMeAccess.isMine(authentication, #id)")
                .antMatchers(HttpMethod.DELETE, "/fitness/routine/unit/{id}").access("hasRole(\"USER\") and @fitnessUnitOnlyMeAccess.isMine(authentication, #id)")

                .antMatchers(HttpMethod.GET, "/food/diary/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/food/diary/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/food/diary/**/{id}").access("hasRole(\"USER\") and @foodDiaryOnlyMeAccess.isMine(authentication, #id)")
                .antMatchers(HttpMethod.DELETE, "/food/diary/**/{id}").access("hasRole(\"USER\") and @foodDiaryOnlyMeAccess.isMine(authentication, #id)")

                .antMatchers(HttpMethod.GET, "/food/info/**").hasRole("USER")

                .antMatchers("/user/**").hasRole("USER")

                .antMatchers("/**").permitAll()

                .and()
                .oauth2Login()
                .successHandler(successHandler)
                .userInfoEndpoint().userService(oAuth2UserService);

        return  http.build();
    }
}
