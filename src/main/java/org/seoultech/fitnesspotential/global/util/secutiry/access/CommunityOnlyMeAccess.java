package org.seoultech.fitnesspotential.global.util.secutiry.access;

import lombok.extern.slf4j.Slf4j;
import org.seoultech.fitnesspotential.domain.community.entity.CommunitySummary;
import org.seoultech.fitnesspotential.domain.community.repository.CommunitySummaryRepository;
import org.seoultech.fitnesspotential.domain.community.service.CommunityService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommunityOnlyMeAccess {

    private final UserService userService;
    private final CommunityService communityService;

    @Autowired
    public CommunityOnlyMeAccess(UserService userService, CommunityService communityService) {
        this.userService = userService;
        this.communityService = communityService;
    }

    public boolean isMine(Authentication authentication, Long id) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Long socialId = Long.parseLong(oAuth2User.getName());
        User user = userService.getUserBySocialId(socialId);
        CommunitySummary communitySummary = communityService.getCommunitySummary(id);
        return user.getId() == communitySummary.getCreatorId();
    }
}
