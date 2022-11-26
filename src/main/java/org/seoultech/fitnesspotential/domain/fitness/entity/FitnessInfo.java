package org.seoultech.fitnesspotential.domain.fitness.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPutRequest;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="fitness_info")
public class FitnessInfo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(nullable = false, name="creator_id")
    private Long creatorId;
    @Column(nullable = false, length = 32, name="title")
    private String title;
    @Column(length = 64, name="summary")
    private String summary;
    @Column(length = 512, name="content")
    private String content;
    @Column(name = "thumbnail", nullable = false)
    private Long thumbnail;

    @ElementCollection
    @CollectionTable(name = "fitness_info_major_category", joinColumns = @JoinColumn(name = "fitness_info_id"))
    @Column(length = 32)
    private Set<String> majorCategory;

    @ElementCollection
    @CollectionTable(name = "fitness_info_detailed_category", joinColumns = @JoinColumn(name = "fitness_info_id"))
    @Column(length = 32)
    private Set<String> detailedCategory;

    @Column(nullable = false, name="created_at")
    private Long createdAt;
    @Column(name="updated_at")
    private Long updatedAt;
    @Column(name="deleted_at")
    private Long deletedAt;

    @Builder
    public FitnessInfo(Long id, Long creatorId, String title, String summary, String content, Long thumbnail, Set<String> majorCategory, Set<String> detailedCategory, Long createdAt, Long updatedAt, Long deletedAt) {
        this.id = id;
        this.creatorId = creatorId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.thumbnail = thumbnail;
        this.majorCategory = majorCategory;
        this.detailedCategory = detailedCategory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static class FitnessInfoBuilder {

        private Long id;
        private Long creatorId;
        private Set<String> majorCategory;
        private Set<String> detailedCategory;
        private String title;
        private String summary;
        private String content;
        private Long thumbnail;
        private Long createdAt;
        private Long updatedAt;
        private Long deletedAt;

        public FitnessInfoBuilder fitnessInfo(FitnessInfo fitnessInfo) {
            this.id = fitnessInfo.id;
            this.creatorId = fitnessInfo.creatorId;
            this.title = fitnessInfo.title;
            this.summary = fitnessInfo.summary;
            this.content = fitnessInfo.content;
            this.thumbnail = fitnessInfo.thumbnail;
            this.majorCategory = fitnessInfo.majorCategory;
            this.detailedCategory = fitnessInfo.detailedCategory;
            this.createdAt = fitnessInfo.createdAt;
            this.updatedAt = fitnessInfo.updatedAt;
            this.deletedAt = fitnessInfo.deletedAt;
            return this;
        }

        public FitnessInfoBuilder fitnessInfoPostRequest(FitnessInfoPostRequest fitnessInfoPostRequest){
            this.title = fitnessInfoPostRequest.getTitle();
            this.summary = fitnessInfoPostRequest.getSummary();
            this.content = fitnessInfoPostRequest.getContent();
            this.thumbnail = fitnessInfoPostRequest.getThumbnail();
            this.majorCategory = fitnessInfoPostRequest.getMajorCategory();
            this.detailedCategory = fitnessInfoPostRequest.getDetailedCategory();
            this.createdAt = System.currentTimeMillis();
            return this;
        }

        public FitnessInfoBuilder fitnessInfoPutRequest(FitnessInfoPutRequest fitnessInfoPutRequest){
            this.title = fitnessInfoPutRequest.getTitle() == null ? this.title : fitnessInfoPutRequest.getTitle();
            this.summary = fitnessInfoPutRequest.getSummary() == null ? this.summary : fitnessInfoPutRequest.getSummary();
            this.content = fitnessInfoPutRequest.getContent() == null ? this.content : fitnessInfoPutRequest.getContent();
            this.thumbnail = fitnessInfoPutRequest.getThumbnail() == null ? this.thumbnail : fitnessInfoPutRequest.getThumbnail();
            this.majorCategory = fitnessInfoPutRequest.getMajorCategory() == null ? this.majorCategory : fitnessInfoPutRequest.getMajorCategory();
            this.detailedCategory = fitnessInfoPutRequest.getDetailedCategory() == null ? this.detailedCategory : fitnessInfoPutRequest.getDetailedCategory();
            this.updatedAt = System.currentTimeMillis();
            return this;
        }
    }
}
