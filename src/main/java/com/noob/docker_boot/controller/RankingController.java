package com.noob.docker_boot.controller;


import com.noob.docker_boot.model.RankingUserDTO;
import jakarta.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // 查看所有用户排行榜
    @GetMapping("/revrange")
    public List<String> revRange() {
        return searchByStartEnd(0, -1);
    }

    // 查看前三
    @GetMapping("/topThree")
    public List<String> topThree() {
        return searchByStartEnd(0, 2);
    }

    private List<String> searchByStartEnd(int start, int end) {
        Set<Object> rangeSet = redisTemplate.opsForZSet().reverseRange(RANK_KEY, start, end);

        return rangeSet.stream()
                .map(o -> (String) o).toList();
    }

    // 查询用户具体排名
    @GetMapping("/queryUserRank")
    public Long queryUserRank(String userName) {
        // 注意，第 1 名返回 0
        return redisTemplate.opsForZSet().reverseRank(RANK_KEY, userName);
    }

    // 修改分数，同时修改排名，返回修改后分数值
    @GetMapping("/updateUserRank")
    public Double updateUserRankWithScore(String userName, Double score) {
        return redisTemplate.opsForZSet().incrementScore(RANK_KEY, userName, score);
    }
}
