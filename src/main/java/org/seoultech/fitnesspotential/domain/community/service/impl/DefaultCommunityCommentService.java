package org.seoultech.fitnesspotential.domain.community.service.impl;

import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPutRequest;
import org.seoultech.fitnesspotential.domain.community.service.CommunityCommentService;
import org.seoultech.fitnesspotential.domain.community.entity.Community;
import org.seoultech.fitnesspotential.domain.community.entity.CommunityComment;
import org.seoultech.fitnesspotential.domain.community.exception.CommunityCommentErrorMessage;
import org.seoultech.fitnesspotential.domain.community.repository.CommunityCommentRepository;
import org.seoultech.fitnesspotential.domain.community.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultCommunityCommentService implements CommunityCommentService {

    private final CommunityCommentRepository communityCommentRepository;
    private final CommunityRepository communityRepository;

    @Autowired
    public DefaultCommunityCommentService(CommunityCommentRepository communityCommentRepository, CommunityRepository communityRepository) {
        this.communityCommentRepository = communityCommentRepository;
        this.communityRepository = communityRepository;
    }

    @Override
    public CommunityComment getCommunityComment(Long id) {
        return communityCommentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(CommunityCommentErrorMessage.COMMUNITY_COMMENT_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public Long getCommunityId(Long id) {
        CommunityComment communityComment = communityCommentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(CommunityCommentErrorMessage.COMMUNITY_COMMENT_NOT_FOUND.toString()));
        return communityComment.getCommunity().getId();
    }

    @Override
    @Transactional
    public Community postCommunityComment(CommunityCommentPostRequest communityCommentPostRequest, Long creatorId) {
        CommunityComment communityComment = CommunityComment.builder()
                .communityCommentPostRequest(communityCommentPostRequest)
                .creatorId(creatorId)
                .build();

        Long parentCommunityId = communityCommentPostRequest.getParentCommentId();
        if (parentCommunityId != null && !communityCommentRepository.existsById(parentCommunityId)) {
            throw new IllegalArgumentException(CommunityCommentErrorMessage.COMMUNITY_PARENT_COMMENT_NOT_FOUND.toString());
        }

        CommunityComment posted = communityCommentRepository.save(communityComment);

        Long communityId = posted.getCommunity().getId();
        return communityRepository.findById(communityId)
                .orElseThrow(() -> new IllegalArgumentException(CommunityCommentErrorMessage.COMMUNITY_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public Community putCommunityComment(CommunityCommentPutRequest communityCommentPutRequest, Long id) {
        CommunityComment communityComment = communityCommentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(CommunityCommentErrorMessage.COMMUNITY_COMMENT_NOT_FOUND.toString()));

        communityComment = CommunityComment.builder()
                .communityComment(communityComment)
                .communityCommentPutRequest(communityCommentPutRequest)
                .build();

        CommunityComment updated = communityCommentRepository.save(communityComment);

        Long communityId = updated.getCommunity().getId();
        return communityRepository.findById(communityId)
                .orElseThrow(() -> new IllegalArgumentException(CommunityCommentErrorMessage.COMMUNITY_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public void deleteCommunityComment(Long id) {
        if (communityCommentRepository.existsById(id)) {
            communityCommentRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException(CommunityCommentErrorMessage.COMMUNITY_COMMENT_NOT_FOUND.toString());
        }
    }

    @Override
    public void deleteByCommunityId(Long communityId) {
        communityCommentRepository.deleteByCommunityId(communityId);
    }
}
