package com.intelligentrecipe.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@Document(indexName = "recipes")
public class RecipeIndex {
    @Id
    private Long id;

    private String name; // 菜谱名称
    private String difficulty; // 难度
    private int cookingTime; // 烹饪时间（分钟）
    private String category; // 类别（如川菜/烘焙）
    private List<String> ingredients; // 食材列表
}