package com.intelligentrecipe.backend.service;

import com.intelligentrecipe.backend.entity.RecipeIndex;
import com.intelligentrecipe.backend.repository.RecipeSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private RecipeSearchRepository recipeSearchRepository;

    // 按关键词搜索菜谱
    public List<RecipeIndex> searchByKeyword(String keyword, int page, int size) {
        return recipeSearchRepository.findByNameContaining(keyword, PageRequest.of(page, size)).getContent();
    }
}