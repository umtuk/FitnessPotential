package org.seoultech.fitnesspotential.domain.food.repository;

import org.seoultech.fitnesspotential.domain.food.entity.FoodDiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDiaryRepository extends CrudRepository<FoodDiary, Long> {
    Iterable<FoodDiary> findByYearAndMonthAndDayAndCreatorId(Integer year, Integer month, Integer day, Long creatorId);
}
