package org.seoultech.fitnesspotential.global.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface ReadOnlyCrudRepository<T, ID> extends Repository<T, ID> {
    long count();
    boolean existsById(ID id);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<ID> ids);
    Optional<T> findById(ID id);
}
