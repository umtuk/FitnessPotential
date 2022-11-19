package org.seoultech.fitnesspotential.domain.storage.repository;

import org.seoultech.fitnesspotential.domain.storage.entity.Storage;
import org.springframework.data.repository.CrudRepository;

public interface StorageRepository extends CrudRepository<Storage, Long> {
}
