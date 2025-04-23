package com.intelligentrecipe.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryManagementController {

    @GetMapping
    public String getAllCategories() {
        return "Here is the list of all categories.";
    }
}