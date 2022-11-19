package org.seoultech.fitnesspotential.domain.community.service;

import org.seoultech.fitnesspotential.domain.community.dto.CommunityPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityPutRequest;
import org.seoultech.fitnesspotential.domain.community.entity.Community;
import org.seoultech.fitnesspotential.domain.community.entity.CommunitySummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommunityService {

    Community getCommunity(Long id);
    CommunitySummary getCommunitySummary(Long id);
    Page<CommunitySummary> getCommunities(Pageable pageable);
    Community postCommunity(CommunityPostRequest communityPostRequest, Long creatorId);
    Community putCommunity(CommunityPutRequest communityPutRequest, Long id);
    void deleteCommunity(Long id);
}
