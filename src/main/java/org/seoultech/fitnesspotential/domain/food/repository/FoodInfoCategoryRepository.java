package org.seoultech.fitnesspotential.domain.food.repository;

import org.seoultech.fitnesspotential.domain.food.entity.FoodInfo;
import org.seoultech.fitnesspotential.domain.food.entity.FoodInfoCategory;
import org.seoultech.fitnesspotential.global.repository.ReadOnlyCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodInfoCategoryRepository extends ReadOnlyCrudRepository<FoodInfo, Long> {
    Iterable<FoodInfoCategory> findDistinctBy();
}
