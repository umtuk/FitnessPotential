package org.seoultech.fitnesspotential.domain.community.controller;

import org.seoultech.fitnesspotential.domain.community.dto.CommunityPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityPutRequest;
import org.seoultech.fitnesspotential.domain.community.entity.Community;
import org.seoultech.fitnesspotential.domain.community.entity.CommunitySummary;
import org.seoultech.fitnesspotential.domain.community.service.CommunityService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.exception.UserErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Community> getCommunity(@PathVariable Long id) {
        return new ResponseEntity<>(communityService.getCommunity(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<CommunitySummary>> getCommunities(@PageableDefault() Pageable pageable) {
        Page<CommunitySummary> CommunitySummaries = communityService.getCommunities(pageable);

        return CommunitySummaries.isEmpty() ?
                new ResponseEntity<>(CommunitySummaries, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(CommunitySummaries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Community> postCommunity(@RequestBody @Validated CommunityPostRequest communityPostRequest, @RequestAttribute(name = "user") User user) {
        return new ResponseEntity<>(communityService.postCommunity(communityPostRequest, user.getId()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Community> putCommunity(@RequestBody @Valid CommunityPutRequest communityPutRequest, @PathVariable Long id, @RequestAttribute(name = "user") User user) {
        Community community = communityService.getCommunity(id);
        if (community.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }
        return new ResponseEntity<>(communityService.putCommunity(communityPutRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id, @RequestAttribute(name = "user") User user) {
        Community community = communityService.getCommunity(id);
        if (community.getCreatorId() != user.getId()) {
            throw new AccessDeniedException("Unauthorized");
        }

        communityService.deleteCommunity(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
