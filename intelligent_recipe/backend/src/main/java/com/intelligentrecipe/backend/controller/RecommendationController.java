package com.intelligentrecipe.backend.controller;

import com.intelligentrecipe.backend.entity.Recipe;
import com.intelligentrecipe.backend.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    // 获取推荐菜谱
    @GetMapping("/user/{userId}")
    public List<Recipe> recommendRecipesForUser(@PathVariable Long userId) {
        return recommendationService.recommendRecipesForUser(userId);
    }
}