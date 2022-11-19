package org.seoultech.fitnesspotential.domain.food.repository;

import org.seoultech.fitnesspotential.domain.food.entity.FoodDiary;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDiaryRepository extends PagingAndSortingRepository<FoodDiary, Long> {
}
