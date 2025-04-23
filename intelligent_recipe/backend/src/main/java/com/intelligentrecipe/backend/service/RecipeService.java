package com.intelligentrecipe.backend.service;

import com.intelligentrecipe.backend.entity.Recipe;
import com.intelligentrecipe.backend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    // 获取所有菜谱
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // 根据分类查找菜谱
    public List<Recipe> getRecipesByCategory(String category) {
        return recipeRepository.findByCategory(category);
    }

    // 根据关键词搜索菜谱
    public List<Recipe> searchRecipes(String keyword) {
        return recipeRepository.findByNameContaining(keyword);
    }

    // 新增或更新菜谱
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    // 删除菜谱
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}