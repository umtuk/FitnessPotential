package org.seoultech.fitnesspotential.domain.food.repository;

import org.seoultech.fitnesspotential.domain.food.entity.FoodInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodInfoRepository extends PagingAndSortingRepository<FoodInfo, Long> {

    Page<FoodInfo> findByMajorCategory(String majorCategory, Pageable pageable);
    Page<FoodInfo> findByMajorCategoryAndDetailedCategory(String majorCategory, String detailedCategory, Pageable pageable);
}
