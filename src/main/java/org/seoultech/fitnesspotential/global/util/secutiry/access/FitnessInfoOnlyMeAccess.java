package org.seoultech.fitnesspotential.global.util.secutiry.access;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class FitnessInfoOnlyMeAccess {

    private final UserService userService;
    private final FitnessInfoService fitnessInfoService;

    @Autowired
    public FitnessInfoOnlyMeAccess(UserService userService, FitnessInfoService fitnessInfoService) {
        this.userService = userService;
        this.fitnessInfoService = fitnessInfoService;
    }

    public boolean isMine(Authentication authentication, Long id) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Long socialId = Long.parseLong(oAuth2User.getName());
        User user = userService.getUserBySocialId(socialId);
        FitnessInfo fitnessInfo = fitnessInfoService.getFitnessInfo(id);
        return user.getId() == fitnessInfo.getCreatorId();
    }
}
