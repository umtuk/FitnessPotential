package org.seoultech.fitnesspotential.domain.community.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityCommentPutRequest;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "community_comment")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommunityComment {

    @ManyToOne
    @JoinColumn(name = "community_id")
    @JsonBackReference
    private Community community;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "creator_id", nullable = false)
    private Long creatorId;
    @Column(name = "parent_comment_id")
    private Long parentCommentId;

    @Column(name = "content", nullable = false, length = 512)
    private String content;

    @Column(name = "likes", nullable = false)
    private Long likes;
    @Column(name = "hates", nullable = false)
    private Long hates;

    @Column(name = "created_at", nullable = false)
    private Long createdAt;
    @Column(name = "updated_at")
    private Long updatedAt;
    @Column(name = "deleted_at")
    private Long deletedAt;

    @Builder
    public CommunityComment(Community community, Long id, Long creatorId, Long parentCommentId, String content, Long likes, Long hates, Long createdAt, Long updatedAt, Long deletedAt) {
        this.community = community;
        this.id = id;
        this.creatorId = creatorId;
        this.parentCommentId = parentCommentId;
        this.content = content;
        this.likes = likes;
        this.hates = hates;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static class CommunityCommentBuilder {

        private Community community;

        private Long id;
        private Long creatorId;
        private Long parentCommunityId;

        private String content;

        private Long likes;
        private Long hates;

        private Long createdAt;
        private Long updatedAt;
        private Long deletedAt;

        public CommunityCommentBuilder communityComment(CommunityComment communityComment) {
            this.community = Community.builder().id(communityComment.getCommunity().getId()).build();
            this.id = communityComment.id;
            this.creatorId = communityComment.creatorId;
            this.parentCommentId = communityComment.parentCommentId;
            this.content = communityComment.content;
            this.likes = communityComment.likes;
            this.hates = communityComment.hates;
            this.createdAt = communityComment.createdAt;
            this.updatedAt = communityComment.updatedAt;
            this.deletedAt = communityComment.deletedAt;
            return this;
        }

        public CommunityCommentBuilder communityCommentPostRequest(CommunityCommentPostRequest communityCommentPostRequest) {
            this.community = Community.builder().id(communityCommentPostRequest.getCommunityId()).build();
            this.parentCommentId = communityCommentPostRequest.getParentCommentId();
            this.content = communityCommentPostRequest.getContent();
            this.likes = 0L;
            this.hates = 0L;
            this.createdAt = System.currentTimeMillis();
            return this;
        }

        public CommunityCommentBuilder communityCommentPutRequest(CommunityCommentPutRequest communityCommentPutRequest) {
            this.content = communityCommentPutRequest.getContent();
            this.updatedAt = System.currentTimeMillis();
            return this;
        }
    }
}
