package com.intelligentrecipe.backend.service;

import com.intelligentrecipe.backend.entity.UserBehaviorLog;
import com.intelligentrecipe.backend.repository.UserBehaviorLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBehaviorLogService {

    @Autowired
    private UserBehaviorLogRepository userBehaviorLogRepository;

    // 获取某用户的行为日志
    public List<UserBehaviorLog> getLogsByUserId(Long userId) {
        return userBehaviorLogRepository.findByUserId(userId);
    }

    // 获取某菜谱的行为日志
    public List<UserBehaviorLog> getLogsByRecipeId(Long recipeId) {
        return userBehaviorLogRepository.findByRecipeId(recipeId);
    }

    // 新增行为日志
    public UserBehaviorLog saveLog(UserBehaviorLog log) {
        return userBehaviorLogRepository.save(log);
    }
}