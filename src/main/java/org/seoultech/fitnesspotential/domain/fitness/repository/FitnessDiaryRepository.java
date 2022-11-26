package org.seoultech.fitnesspotential.domain.fitness.repository;

import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessDiaryRepository extends CrudRepository<FitnessDiary, Long> {
    Iterable<FitnessDiary> findByYearAndMonthAndDayAndCreatorId(Integer yaer, Integer month, Integer day, Long creatorId);
}
