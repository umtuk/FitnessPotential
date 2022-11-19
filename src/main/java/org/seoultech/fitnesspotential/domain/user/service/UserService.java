package org.seoultech.fitnesspotential.domain.user.service;

import org.seoultech.fitnesspotential.domain.user.dto.UserPostRequest;
import org.seoultech.fitnesspotential.domain.user.dto.UserPutRequest;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User getUser(Long id);
    User getUserBySocialId(Long socialId);
    User getUserBySocialIdAndProvider(Long socialId, String provider);
    User postUser(UserPostRequest userPostRequest);
    User putUser(UserPutRequest userPutRequest, Long id);
    boolean existsBySocialIdAndProvider(Long socialId, String provider);
    void deleteUser(Long id);
}
