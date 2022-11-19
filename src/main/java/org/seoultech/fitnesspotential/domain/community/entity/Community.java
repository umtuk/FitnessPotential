package org.seoultech.fitnesspotential.domain.community.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityPostRequest;
import org.seoultech.fitnesspotential.domain.community.dto.CommunityPutRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "community")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Community {

    @OneToMany(mappedBy = "community")
    @JsonManagedReference
    private List<CommunityComment> comments;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "title", nullable = false, length = 64)
    private String title;
    @Column(name = "content", nullable = false, length = 1024)
    private String content;

    @ElementCollection
    @CollectionTable(name = "community_tags", joinColumns = @JoinColumn(name = "community_id"))
    @Column(length = 32)
    private List<String> tags;

    @Column(name = "views", nullable = false)
    private Long views;
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
    public Community(List<CommunityComment> comments, Long id, Long creatorId, String title, String content, List<String> tags, Long views, Long likes, Long hates, Long createdAt, Long updatedAt, Long deletedAt) {
        this.comments = comments;
        this.id = id;
        this.creatorId = creatorId;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.views = views;
        this.likes = likes;
        this.hates = hates;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static class CommunityBuilder {

        private List<CommunityComment> comments;

        private Long id;
        private Long creatorId;

        private String title;
        private String content;

        private List<String> tags;

        private Long views;
        private Long likes;
        private Long hates;

        private Long createdAt;
        private Long updatedAt;
        private Long deletedAt;

        public CommunityBuilder community(Community community) {
            this.comments = community.comments;
            this.id = community.id;
            this.creatorId = community.creatorId;
            this.title = community.title;
            this.content = community.content;
            this.tags = community.tags;
            this.views = community.views;
            this.likes = community.likes;
            this.hates = community.hates;
            this.createdAt = community.createdAt;
            this.updatedAt = community.updatedAt;
            this.deletedAt = community.deletedAt;
            return this;
        }

        public CommunityBuilder communityPostRequest(CommunityPostRequest communityPostRequest) {
            this.title = communityPostRequest.getTitle();
            this.content = communityPostRequest.getContent();
            this.tags = communityPostRequest.getTags();
            this.views = 0L;
            this.likes = 0L;
            this.hates = 0L;
            this.createdAt = System.currentTimeMillis();
            return this;
        }

        public CommunityBuilder communityPutRequest(CommunityPutRequest communityPutRequest) {
            this.title = communityPutRequest.getTitle() == null ? this.title : communityPutRequest.getTitle();
            this.content = communityPutRequest.getContent() == null ? this.content : communityPutRequest.getContent();
            this.tags = communityPutRequest.getTags() == null ? this.tags : communityPutRequest.getTags();
            this.updatedAt = System.currentTimeMillis();
            return this;
        }

        public CommunityBuilder communityGetRequest() {
            this.views = this.views + 1;
            return this;
        }
    }
}
