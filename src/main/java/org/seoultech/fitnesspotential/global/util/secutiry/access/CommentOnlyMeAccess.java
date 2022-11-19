package org.seoultech.fitnesspotential.global.util.secutiry.access;

import org.seoultech.fitnesspotential.domain.community.entity.CommunityComment;
import org.seoultech.fitnesspotential.domain.community.service.CommunityCommentService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class CommentOnlyMeAccess {

    private final UserService userService;
    private final CommunityCommentService commentService;

    @Autowired
    public CommentOnlyMeAccess(UserService userService, CommunityCommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    public boolean isMine(Authentication authentication, Long id) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Long socialId = Long.parseLong(oAuth2User.getName());
        User user = userService.getUserBySocialId(socialId);
        CommunityComment communityComment = commentService.getCommunityComment(id);
        return user.getId() == communityComment.getCreatorId();
    }
}
