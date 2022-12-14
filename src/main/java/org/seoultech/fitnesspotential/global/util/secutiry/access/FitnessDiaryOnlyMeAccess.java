package org.seoultech.fitnesspotential.global.util.secutiry.access;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessDiaryService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class FitnessDiaryOnlyMeAccess {

    private final UserService userService;
    private final FitnessDiaryService fitnessDiaryService;

    @Autowired
    public FitnessDiaryOnlyMeAccess(UserService userService, FitnessDiaryService fitnessDiaryService) {
        this.userService = userService;
        this.fitnessDiaryService = fitnessDiaryService;
    }

    public boolean isMine(Authentication authentication, Long id) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Long socialId = Long.parseLong(oAuth2User.getName());
        User user = userService.getUserBySocialId(socialId);
        FitnessDiary fitnessDiary = fitnessDiaryService.getFitnessDiary(id);
        return user.getId() == fitnessDiary.getCreatorId();
    }
}
