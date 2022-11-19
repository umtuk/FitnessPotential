package org.seoultech.fitnesspotential.domain.community.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.util.List;

@Entity
@Subselect("SELECT * FROM community")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Immutable
public class CommunitySummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

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
}
