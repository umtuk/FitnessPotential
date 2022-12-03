package org.seoultech.fitnesspotential.domain.community.controller;

import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPutRequest;
import org.seoultech.fitnesspotential.domain.community.entity.Community;
import org.seoultech.fitnesspotential.domain.community.entity.CommunityComment;
import org.seoultech.fitnesspotential.domain.community.service.CommunityCommentService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community/comment")
public class CommunityCommentController {

    private final CommunityCommentService communityCommentService;

    @Autowired
    public CommunityCommentController(CommunityCommentService communityCommentService) {
        this.communityCommentService = communityCommentService;
    }

    @PostMapping
    public ResponseEntity<Community> postCommunityComment(@RequestBody @Validated CommunityCommentPostRequest communityCommentPostRequest, @RequestAttribute(name = "user") User user) {
        Community community = communityCommentService.postCommunityComment(communityCommentPostRequest, user.getId()); // When social login issue done, replace creatorId
        return new ResponseEntity<>(community, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Community> putCommunityComment(@RequestBody @Validated CommunityCommentPutRequest communityCommentPutRequest, @PathVariable Long id, @RequestAttribute(name = "user") User user) {
        CommunityComment communityComment = communityCommentService.getCommunityComment(id);
        if (communityComment.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        Community community = communityCommentService.putCommunityComment(communityCommentPutRequest, id);
        return new ResponseEntity<>(community, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunityComment(@PathVariable Long id, @RequestAttribute(name = "user") User user) {
        CommunityComment communityComment = communityCommentService.getCommunityComment(id);
        if (communityComment.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        communityCommentService.deleteCommunityComment(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
