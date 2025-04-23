package com.intelligentrecipe.backend.service;

import com.intelligentrecipe.backend.entity.Recipe;
import com.intelligentrecipe.backend.entity.User;
import com.intelligentrecipe.backend.entity.UserBehaviorLog;
import com.intelligentrecipe.backend.repository.RecipeRepository;
import com.intelligentrecipe.backend.repository.UserBehaviorLogRepository;
import com.intelligentrecipe.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserBehaviorLogRepository userBehaviorLogRepository;

    // 推荐菜谱（用户-用户协同过滤）
    public List<Recipe> recommendRecipesForUser(Long userId) {
        // 获取所有用户行为日志
        List<UserBehaviorLog> allLogs = userBehaviorLogRepository.findAll();

        // 构建用户行为矩阵
        Map<Long, Set<Long>> userRecipeMap = new HashMap<>();
        for (UserBehaviorLog log : allLogs) {
            userRecipeMap
                    .computeIfAbsent(log.getUser().getId(), k -> new HashSet<>())
                    .add(log.getRecipe().getId());
        }

        // 计算用户相似度（Jaccard 相似度）
        Long targetUserId = userId;
        Set<Long> targetRecipes = userRecipeMap.getOrDefault(targetUserId, new HashSet<>());
        Map<Long, Double> similarityMap = new HashMap<>();

        for (Map.Entry<Long, Set<Long>> entry : userRecipeMap.entrySet()) {
            if (!entry.getKey().equals(targetUserId)) {
                Set<Long> otherRecipes = entry.getValue();
                double similarity = calculateJaccardSimilarity(targetRecipes, otherRecipes);
                similarityMap.put(entry.getKey(), similarity);
            }
        }

        // 找到最相似的用户
        Long mostSimilarUserId = similarityMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        if (mostSimilarUserId == null) {
            return Collections.emptyList();
        }

        // 推荐最相似用户喜欢但当前用户未浏览的菜谱
        Set<Long> mostSimilarUserRecipes = userRecipeMap.getOrDefault(mostSimilarUserId, new HashSet<>());
        Set<Long> recommendedRecipeIds = mostSimilarUserRecipes.stream()
                .filter(recipeId -> !targetRecipes.contains(recipeId))
                .collect(Collectors.toSet());

        return recipeRepository.findAllById(recommendedRecipeIds);
    }

    // 计算 Jaccard 相似度
    private double calculateJaccardSimilarity(Set<Long> setA, Set<Long> setB) {
        Set<Long> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        Set<Long> union = new HashSet<>(setA);
        union.addAll(setB);

        return union.isEmpty() ? 0 : (double) intersection.size() / union.size();
    }
}