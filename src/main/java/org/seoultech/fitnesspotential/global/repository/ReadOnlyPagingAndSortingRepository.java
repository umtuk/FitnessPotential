package org.seoultech.fitnesspotential.global.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReadOnlyPagingAndSortingRepository<T, ID> extends ReadOnlyCrudRepository<T, ID> {
    Page<T> findAll(Pageable pageable);
    Iterable<T> findAll(Sort sort);
}
