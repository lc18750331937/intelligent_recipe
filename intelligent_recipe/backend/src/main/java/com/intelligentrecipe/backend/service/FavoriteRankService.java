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
public class FavoriteRankService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private org.springframework.data.redis.core.RedisTemplate<String, Object> redisTemplate;

    private static final String FAVORITE_RANK_KEY = "recipe:favorite_rank";

    // 定期更新收藏排行榜
    @Scheduled(cron = "0 0 3 * * ?") // 每天凌晨3点执行
    public void updateFavoriteRank() {
        List<Recipe> recipes = recipeRepository.findAll();
        for (Recipe recipe : recipes) {
            int favoriteCount = recipe.getFavoriteCount(); // 假设 Recipe 有收藏字段
            redisTemplate.opsForZSet().add(FAVORITE_RANK_KEY, recipe.getId().toString(), favoriteCount);
        }
        System.out.println("Favorite rank updated successfully at " + System.currentTimeMillis());
    }

    // 获取收藏排行榜
    public Set<ZSetOperations.TypedTuple<Object>> getFavoriteRank(int topN) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(FAVORITE_RANK_KEY, 0, topN - 1);
    }
}