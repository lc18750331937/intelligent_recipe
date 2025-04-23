package com.intelligentrecipe.backend.repository;

import com.intelligentrecipe.backend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRecipeId(Long recipeId); // 根据菜谱ID查找评论
    List<Comment> findByUserId(Long userId); // 根据用户ID查找评论
}