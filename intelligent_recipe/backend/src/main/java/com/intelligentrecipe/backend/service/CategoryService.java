package com.intelligentrecipe.backend.service;

import com.intelligentrecipe.backend.entity.Category;
import com.intelligentrecipe.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // 获取所有分类
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // 新增或更新分类
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // 删除分类
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}