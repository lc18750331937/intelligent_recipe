package com.intelligentrecipe.backend.repository;

import com.intelligentrecipe.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 默认提供基础的 CRUD 操作，不需要额外方法
}