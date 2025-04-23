package com.intelligentrecipe.backend.repository;

import com.intelligentrecipe.backend.entity.UserBehaviorLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBehaviorLogRepository extends JpaRepository<UserBehaviorLog, Long> {
    List<UserBehaviorLog> findByUserId(Long userId); // 根据用户ID查找行为日志
    List<UserBehaviorLog> findByRecipeId(Long recipeId); // 根据菜谱ID查找行为日志
}