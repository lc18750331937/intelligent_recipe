package com.intelligentrecipe.backend.service;

import com.intelligentrecipe.backend.entity.Comment;
import com.intelligentrecipe.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // 根据菜谱获取评论
    public List<Comment> getCommentsByRecipeId(Long recipeId) {
        return commentRepository.findByRecipeId(recipeId);
    }

    // 根据用户获取评论
    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    // 新增或更新评论
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // 删除评论
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}