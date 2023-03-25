package com.noob.docker_boot.service;

import com.noob.docker_boot.model.User;
import com.noob.docker_boot.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class UserService {

    private static final String CACHE_KEY_USER = "USER:";

    @Resource
    private UserRepository userRepository;

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    public void addUser(User user) {
        User save = userRepository.save(user);

        if (save.getId() != null) {
            Optional<User> byId = userRepository.findById(save.getId());

            if (byId.isPresent()) {
                User userInDB = byId.get();
                String key = CACHE_KEY_USER + userInDB.getId();

                redisTemplate.opsForValue().set(key, userInDB);
            }
        }
    }

    public User findUserById(Integer id) {
        String key = CACHE_KEY_USER + id;

        User user = (User) redisTemplate.opsForValue().get(key);

        if (user == null) {
            Optional<User> byId = userRepository.findById(id);
            if (byId.isPresent()) {
                redisTemplate.opsForValue().set(key, byId.get());

                user = byId.get();
            } else {
                return null;
            }
        }

        return user;
    }
}
