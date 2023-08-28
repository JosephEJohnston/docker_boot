package com.noob.docker_boot.controller;


import com.noob.docker_boot.model.RankingUserDTO;
import jakarta.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    private String RANK_KEY = "cus_order_set";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/sample")
    public void sampleRankingUser() {
        redisTemplate.executePipelined(new SessionCallback<>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                ZSetOperations<String, Object> zSet =
                        (ZSetOperations<String, Object>) operations.opsForZSet();

                zSet.add(RANK_KEY, "user1", 113.0);
                zSet.add(RANK_KEY, "user2", 100.0);
                zSet.add(RANK_KEY, "user3", 123.0);
                zSet.add(RANK_KEY, "user4", 100.0);
                zSet.add(RANK_KEY, "user5", 33.0);
                zSet.add(RANK_KEY, "user6", 993.0);

                return null;
            }
        });

    }

    @GetMapping("/add")
    public void addRankingUser(RankingUserDTO userDTO) {
        redisTemplate.opsForZSet().add(RANK_KEY,
                userDTO.getName(), userDTO.getSource());
    }

    @GetMapping("/revrange")
    public List<String> revRange() {
        Set<Object> rangeSet = redisTemplate.opsForZSet().reverseRange(RANK_KEY, 0, -1);

        return rangeSet.stream()
                .map(o -> (String) o).toList();
    }
}
