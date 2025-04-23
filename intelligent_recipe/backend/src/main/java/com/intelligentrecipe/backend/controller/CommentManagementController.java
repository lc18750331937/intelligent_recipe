package com.intelligentrecipe.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentManagementController {

    @GetMapping
    public String getAllComments() {
        return "Here is the list of all comments.";
    }
}