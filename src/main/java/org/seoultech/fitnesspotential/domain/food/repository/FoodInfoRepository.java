package org.seoultech.fitnesspotential.domain.food.repository;

import org.seoultech.fitnesspotential.domain.food.entity.FoodInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodInfoRepository extends PagingAndSortingRepository<FoodInfo, Long> {
}
