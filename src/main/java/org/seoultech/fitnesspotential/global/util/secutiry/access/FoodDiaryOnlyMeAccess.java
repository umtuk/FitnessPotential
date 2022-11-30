package org.seoultech.fitnesspotential.global.util.secutiry.access;

import org.seoultech.fitnesspotential.domain.food.entity.FoodDiary;
import org.seoultech.fitnesspotential.domain.food.service.FoodDiaryService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class FoodDiaryOnlyMeAccess {

    private final UserService userService;
    private final FoodDiaryService foodDiaryService;

    @Autowired
    public FoodDiaryOnlyMeAccess(UserService userService, FoodDiaryService foodDiaryService) {
        this.userService = userService;
        this.foodDiaryService = foodDiaryService;
    }

    public boolean isMine(Authentication authentication, Long id) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Long socialId = Long.parseLong(oAuth2User.getName());
        User user = userService.getUserBySocialId(socialId);
        FoodDiary foodDiary = foodDiaryService.getFoodDiary(id);
        return user.getId() == foodDiary.getCreatorId();
    }
}
