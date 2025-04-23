package com.intelligentrecipe.backend.repository;

import com.intelligentrecipe.backend.entity.RecipeIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeSearchRepository extends ElasticsearchRepository<RecipeIndex, Long> {
    Page<RecipeIndex> findByNameContaining(String keyword, Pageable pageable); // 添加Pageable支持
}