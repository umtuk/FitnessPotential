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
public class FitnessInfoSummary {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(nullable = false, name="creator_id")
    private Long creatorId;
    @Column(nullable = false, length = 32, name="title")
    private String title;
    @Column(length = 64, name="summary")
    private String summary;
    @Column(nullable = false, name="created_at")
    private Long createdAt;
    @Column(name="updated_at")
    private Long updatedAt;
    @Column(name="deleted_at")
    private Long deletedAt;

    @Builder
    public FitnessInfoSummary(Long id, Long creatorId, String title, String summary, Long createdAt, Long updatedAt, Long deletedAt) {
        this.id = id;
        this.creatorId = creatorId;
        this.title = title;
        this.summary = summary;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
