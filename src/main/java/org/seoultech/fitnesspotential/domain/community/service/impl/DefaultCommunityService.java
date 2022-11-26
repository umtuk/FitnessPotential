package org.seoultech.fitnesspotential.domain.community.service.impl;

import org.seoultech.fitnesspotential.domain.community.dto.CommunityPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityPutRequest;
import org.seoultech.fitnesspotential.domain.community.entity.CommunitySummary;
import org.seoultech.fitnesspotential.domain.community.repository.CommunitySummaryRepository;
import org.seoultech.fitnesspotential.domain.community.service.CommunityCommentService;
import org.seoultech.fitnesspotential.domain.community.service.CommunityService;
import org.seoultech.fitnesspotential.domain.community.entity.Community;
import org.seoultech.fitnesspotential.domain.community.exception.CommunityErrorMessage;
import org.seoultech.fitnesspotential.domain.community.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultCommunityService implements CommunityService {

    private final CommunityRepository communityRepository;
    private final CommunitySummaryRepository communitySummaryRepository;

    private final CommunityCommentService communityCommentService;

    @Autowired
    public DefaultCommunityService(
            CommunityRepository communityRepository,
            CommunitySummaryRepository communitySummaryRepository,
            CommunityCommentService communityCommentService) {
        this.communityRepository = communityRepository;
        this.communitySummaryRepository = communitySummaryRepository;
        this.communityCommentService = communityCommentService;
    }


    @Override
    @Transactional
    public Community getCommunity(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(CommunityErrorMessage.COMMUNITY_NOT_FOUND.toString()));
        Community updated = Community.builder()
                .community(community)
                .communityGetRequest()
                .build();
        return communityRepository.save(updated);
    }

    @Override
    public CommunitySummary getCommunitySummary(Long id) {
        return communitySummaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(CommunityErrorMessage.COMMUNITY_NOT_FOUND.toString()));
    }

    @Override
    public Page<CommunitySummary> getCommunities(Pageable pageable) {
        return  communitySummaryRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Community postCommunity(CommunityPostRequest communityPostRequest, Long creatorId) {
        Community community = Community.builder()
                .communityPostRequest(communityPostRequest)
                .creatorId(creatorId)
                .build();

        return communityRepository.save(community);
    }

    @Override
    @Transactional
    public Community putCommunity(CommunityPutRequest communityPutRequest, Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(CommunityErrorMessage.COMMUNITY_NOT_FOUND.toString()));

        Community updated = Community.builder()
                .community(community)
                .communityPutRequest(communityPutRequest)
                .build();

        return communityRepository.save(updated);
    }

    @Override
    @Transactional
    public void deleteCommunity(Long id) {
        if (communityRepository.existsById(id)) {
            communityCommentService.deleteByCommunityId(id);
            communityRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException(CommunityErrorMessage.COMMUNITY_NOT_FOUND.toString());
        }
    }
}
