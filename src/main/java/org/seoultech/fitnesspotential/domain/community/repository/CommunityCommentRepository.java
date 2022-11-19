package org.seoultech.fitnesspotential.domain.community.repository;

import org.seoultech.fitnesspotential.domain.community.entity.CommunityComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityCommentRepository extends CrudRepository<CommunityComment, Long> {
    void deleteByCommunityId(Long communityId);
}
