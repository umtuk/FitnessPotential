package org.seoultech.fitnesspotential.domain.fitness.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPutRequest;

import javax.persistence.*;

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

    @Column(nullable = false, name="created_at")
    private Long createdAt;
    @Column(name="updated_at")
    private Long updatedAt;
    @Column(name="deleted_at")
    private Long deletedAt;

    @Builder
    public FitnessInfo(Long id, Long creatorId, String title, String summary, String content, Long createdAt, Long updatedAt, Long deletedAt) {
        this.id = id;
        this.creatorId = creatorId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static class FitnessInfoBuilder{

        private Long id;

        private Long creatorId;

        private String title;

        private String summary;

        private String content;

        private Long createdAt;

        private Long updatedAt;

        private Long deletedAt;

        public FitnessInfoBuilder fitnessInfo(FitnessInfo fitnessInfo) {
            this.id = fitnessInfo.id;
            this.creatorId = fitnessInfo.creatorId;
            this.title = fitnessInfo.title;
            this.summary = fitnessInfo.summary;
            this.content = fitnessInfo.content;
            this.createdAt = fitnessInfo.createdAt;
            this.updatedAt = fitnessInfo.updatedAt;
            this.deletedAt = fitnessInfo.deletedAt;
            return this;
        }

        public FitnessInfoBuilder fitnessInfoPostRequest(FitnessInfoPostRequest fitnessInfoPostRequest){
            this.title = fitnessInfoPostRequest.getTitle();
            this.summary = fitnessInfoPostRequest.getSummary();
            this.content = fitnessInfoPostRequest.getContent();
            this.createdAt = System.currentTimeMillis();
            return this;
        }

        public FitnessInfoBuilder fitnessInfoPutRequest(FitnessInfoPutRequest fitnessInfoPutRequest){
            this.title = fitnessInfoPutRequest.getTitle() == null ? this.title : fitnessInfoPutRequest.getTitle();
            this.summary = fitnessInfoPutRequest.getSummary() == null ? this.summary : fitnessInfoPutRequest.getSummary();
            this.content = fitnessInfoPutRequest.getContent() == null ? this.content : fitnessInfoPutRequest.getContent();
            this.updatedAt = System.currentTimeMillis();
            return this;
        }
    }
}
