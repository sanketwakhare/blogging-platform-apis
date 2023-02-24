package com.sanket.bloggingplatform.services;

import com.sanket.bloggingplatform.models.User;
import com.sanket.bloggingplatform.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.Date;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String bio) {
        User user = new User();
        user.setUsername(username);
        user.setBio(bio);
        user.setTotalBlogs(0);

        // update epoch timestamp
        Long now = Instant.now().toEpochMilli();
        user.setCreatedAt(now);
        user.setLastModifiedAt(now);

        return userRepository.saveAndFlush(user);
    }
}
