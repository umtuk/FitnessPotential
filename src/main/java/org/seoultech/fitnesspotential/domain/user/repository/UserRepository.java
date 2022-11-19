package org.seoultech.fitnesspotential.domain.user.repository;

import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsBySocialIdAndProvider(Long socialId, String provider);
    Optional<User> findBySocialIdAndProvider(Long socialId, String provider);
    Optional<User> findBySocialId(Long socialId);
}
