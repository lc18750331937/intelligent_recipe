package com.intelligentrecipe.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RankService {

    @Autowired
    private org.springframework.data.redis.core.RedisTemplate<String, Object> redisTemplate;

    private static final String HOT_RANK_KEY = "recipe:hot_rank";

    // 更新热度排行榜
    public void updateHotRank(Long recipeId, double score) {
        redisTemplate.opsForZSet().incrementScore(HOT_RANK_KEY, recipeId.toString(), score);
    }

    // 获取热度排行榜
    public Set<ZSetOperations.TypedTuple<Object>> getHotRank(int topN) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(HOT_RANK_KEY, 0, topN - 1);
    }
}