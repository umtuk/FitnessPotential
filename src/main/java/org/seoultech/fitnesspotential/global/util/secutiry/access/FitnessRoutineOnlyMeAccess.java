package org.seoultech.fitnesspotential.global.util.secutiry.access;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessRoutineService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class FitnessRoutineOnlyMeAccess {

    private final UserService userService;
    private final FitnessRoutineService fitnessRoutineService;

    @Autowired
    public FitnessRoutineOnlyMeAccess(UserService userService, FitnessRoutineService fitnessRoutineService) {
        this.userService = userService;
        this.fitnessRoutineService = fitnessRoutineService;
    }

    public boolean isMine(Authentication authentication, Long id) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Long socialId = Long.parseLong(oAuth2User.getName());
        User user = userService.getUserBySocialId(socialId);
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(id);
        return user.getId() == fitnessRoutine.getCreatorId();
    }
}
