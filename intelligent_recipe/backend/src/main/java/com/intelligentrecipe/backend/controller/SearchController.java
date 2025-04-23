package com.intelligentrecipe.backend.controller;

import com.intelligentrecipe.backend.entity.RecipeIndex;
import com.intelligentrecipe.backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    // 按关键词搜索菜谱
    @GetMapping
    public List<RecipeIndex> searchByKeyword(@RequestParam String keyword,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        return searchService.searchByKeyword(keyword, page, size);
    }
}