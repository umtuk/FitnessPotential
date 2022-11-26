package org.seoultech.fitnesspotential.domain.user.service.impl;

import org.seoultech.fitnesspotential.domain.user.dto.UserPostRequest;
import org.seoultech.fitnesspotential.domain.user.dto.UserPutRequest;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.seoultech.fitnesspotential.domain.user.exception.UserErrorMessage;
import org.seoultech.fitnesspotential.domain.user.repository.UserRepository;
import org.seoultech.fitnesspotential.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(UserErrorMessage.USER_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public User getUserBySocialId(Long socialId) {
        return userRepository.findBySocialId(socialId)
                .orElseThrow(() -> new IllegalArgumentException(UserErrorMessage.USER_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public User getUserBySocialIdAndProvider(Long socialId, String provider) {
        return userRepository.findBySocialIdAndProvider(socialId, provider)
                .orElseThrow(() -> new IllegalArgumentException(UserErrorMessage.USER_NOT_FOUND.toString()));
    }

    @Override
    @Transactional
    public User postUser(UserPostRequest userPostRequest) {
        User user = User.builder()
                .userPostRequest(userPostRequest)
                .build();

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User putUser(UserPutRequest userPutRequest, Long id) {
        User user = getUser(id);

        User updated = User.builder()
                .user(user)
                .userPutRequest(userPutRequest)
                .build();

        return userRepository.save(updated);
    }

    @Override
    @Transactional
    public boolean existsBySocialIdAndProvider(Long socialId, String provider) {
        return userRepository.existsBySocialIdAndProvider(socialId, provider);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserBySocialId(Long.parseLong(username));
    }
}
