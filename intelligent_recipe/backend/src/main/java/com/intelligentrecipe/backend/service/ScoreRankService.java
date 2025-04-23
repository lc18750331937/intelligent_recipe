package com.intelligentrecipe.backend.service;

import com.intelligentrecipe.backend.entity.Recipe;
import com.intelligentrecipe.backend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ScoreRankService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private org.springframework.data.redis.core.RedisTemplate<String, Object> redisTemplate;

    private static final String SCORE_RANK_KEY = "recipe:score_rank";

    // 定期更新评分排行榜
    @Scheduled(cron = "0 0 2 * * ?") // 每天凌晨2点执行
    public void updateScoreRank() {
        List<Recipe> recipes = recipeRepository.findAll();
        for (Recipe recipe : recipes) {
            double averageScore = recipe.getAverageRating(); // 假设 Recipe 有评分字段
            redisTemplate.opsForZSet().add(SCORE_RANK_KEY, recipe.getId().toString(), averageScore);
        }
        System.out.println("Score rank updated successfully at " + System.currentTimeMillis());
    }

    // 获取评分排行榜
    public Set<ZSetOperations.TypedTuple<Object>> getScoreRank(int topN) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(SCORE_RANK_KEY, 0, topN - 1);
    }
}