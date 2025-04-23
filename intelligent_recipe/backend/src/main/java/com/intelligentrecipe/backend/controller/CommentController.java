package com.intelligentrecipe.backend.controller;

import com.intelligentrecipe.backend.entity.Comment;
import com.intelligentrecipe.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 获取某菜谱的评论
    @GetMapping("/recipe/{recipeId}")
    public List<Comment> getCommentsByRecipeId(@PathVariable Long recipeId) {
        return commentService.getCommentsByRecipeId(recipeId);
    }

    // 获取某用户的评论
    @GetMapping("/user/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable Long userId) {
        return commentService.getCommentsByUserId(userId);
    }

    // 新增或更新评论
    @PostMapping
    public Comment saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    // 删除评论
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return "Comment deleted successfully!";
    }
}