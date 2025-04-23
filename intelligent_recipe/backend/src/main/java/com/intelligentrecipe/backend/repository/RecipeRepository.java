package com.intelligentrecipe.backend.repository;

import com.intelligentrecipe.backend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByCategory(String category); // 根据分类查找菜谱
    List<Recipe> findByNameContaining(String keyword); // 模糊搜索菜谱名称
}