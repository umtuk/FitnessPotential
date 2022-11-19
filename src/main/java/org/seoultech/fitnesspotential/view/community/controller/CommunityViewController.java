package org.seoultech.fitnesspotential.view.community.controller;

import lombok.extern.slf4j.Slf4j;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPutRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityPutRequest;
import org.seoultech.fitnesspotential.domain.community.entity.Community;
import org.seoultech.fitnesspotential.domain.community.entity.CommunitySummary;
import org.seoultech.fitnesspotential.domain.community.service.CommunityCommentService;
import org.seoultech.fitnesspotential.domain.community.service.CommunityService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/community")
public class CommunityViewController {

    private final CommunityService communityService;
    private final CommunityCommentService communityCommentService;

    @Autowired
    public CommunityViewController(CommunityService communityService, CommunityCommentService communityCommentService) {
        this.communityService = communityService;
        this.communityCommentService = communityCommentService;
    }

    @GetMapping
    public ModelAndView getDefaultCommunityView(@SessionAttribute User user, ModelMap model) {
        return new ModelAndView("forward:/community/search?page=0&size=10", model);
    }

    @GetMapping("/search")
    public ModelAndView getCommunitiesView(@PageableDefault() Pageable pageable, @SessionAttribute User user, ModelMap model) {
        Page<CommunitySummary> communitySummaries = communityService.getCommunities(pageable);
        model.addAttribute("communitySummaries", communitySummaries);
        return new ModelAndView("community/searchView", model);
    }

    @GetMapping("/{id}")
    public ModelAndView getCommunityView(@PathVariable Long id, @SessionAttribute User user, ModelMap model) {
        Community community = communityService.getCommunity(id);
        model.addAttribute("community", community);
        return new ModelAndView("community/indexView", model);
    }

    @PostMapping
    public ModelAndView postCommunity(@ModelAttribute CommunityPostRequest communityPostRequest, @SessionAttribute User user, ModelMap model) {
        Community community = communityService.postCommunity(communityPostRequest, user.getId());
        return new ModelAndView("redirect:/community/" + community.getId(), model);
    }

    @PutMapping("/{id}")
    public ModelAndView putCommunity(@ModelAttribute CommunityPutRequest communityPutRequest, @PathVariable Long id, @SessionAttribute User user, ModelMap model) {
        Community community = communityService.putCommunity(communityPutRequest, id);
        return new ModelAndView("redirect:/community/" + community.getId(), model);
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteCommunity(@PathVariable Long id, @SessionAttribute User user, ModelMap model) {
        communityService.deleteCommunity(id);
        return new ModelAndView("redirect:/community", model);
    }

    @PostMapping("/comment")
    public ModelAndView postComment(@ModelAttribute CommunityCommentPostRequest communityCommentPostRequest, @SessionAttribute User user, ModelMap model) {
        Community community = communityCommentService.postCommunityComment(communityCommentPostRequest, user.getId());
        return new ModelAndView("redirect:/community/" + community.getId(), model);
    }

    @PutMapping("/comment/{id}")
    public ModelAndView putComment(@ModelAttribute CommunityCommentPutRequest communityCommentPutRequest, @PathVariable Long id, @SessionAttribute User user, ModelMap model) {
        Community community = communityCommentService.putCommunityComment(communityCommentPutRequest, id);
        return new ModelAndView("redirect:/community/" + community.getId(), model);
    }

    @DeleteMapping("/comment/{id}")
    public ModelAndView deleteComment(@PathVariable Long id, @SessionAttribute User user, ModelMap model) {
        Long communityId = communityCommentService.getCommunityId(id);
        communityCommentService.deleteCommunityComment(id);
        return new ModelAndView("redirect:/community/" + communityId, model);
    }

    @GetMapping("/create")
    public ModelAndView getCommunityCreateView(@SessionAttribute User user, ModelMap model) {
        return new ModelAndView("/community/submit/communityCreateView", model);
    }

    @GetMapping("/update/{id}")
    public ModelAndView getCommunityUpdateView(@SessionAttribute User user, @PathVariable Long id, ModelMap model) {
        Community community = communityService.getCommunity(id);
        model.addAttribute("community", community);
        return new ModelAndView("/community/submit/communityUpdateView", model);
    }
}
