package org.seoultech.fitnesspotential.domain.community.repository;

import org.seoultech.fitnesspotential.domain.community.entity.Community;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends PagingAndSortingRepository<Community, Long> {
}
