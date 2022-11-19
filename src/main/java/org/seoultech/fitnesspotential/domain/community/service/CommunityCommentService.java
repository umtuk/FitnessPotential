package org.seoultech.fitnesspotential.domain.community.service;

import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPutRequest;
import org.seoultech.fitnesspotential.domain.community.entity.Community;
import org.seoultech.fitnesspotential.domain.community.entity.CommunityComment;

public interface CommunityCommentService {

    CommunityComment getCommunityComment(Long id);
    Long getCommunityId(Long id);
    Community postCommunityComment(CommunityCommentPostRequest communityCommentPostRequest, Long creatorId);
    Community putCommunityComment(CommunityCommentPutRequest communityCommentPutRequest, Long id);
    void deleteCommunityComment(Long id);
    void deleteByCommunityId(Long communityId);
}
