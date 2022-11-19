package org.seoultech.fitnesspotential.domain.fitness.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FitnessInfo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long creatorId;

    @Column(nullable = false, length = 32)
    private String title;
    @Column(length = 64)
    private String summary;
    @Column(length = 512)
    private String content;

    @Column(nullable = false)
    private Long createdAt;
    @Column
    private Long updatedAt;
    @Column
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
}
