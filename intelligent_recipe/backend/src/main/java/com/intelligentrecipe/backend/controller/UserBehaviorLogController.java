package com.intelligentrecipe.backend.controller;

import com.intelligentrecipe.backend.entity.UserBehaviorLog;
import com.intelligentrecipe.backend.service.UserBehaviorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class UserBehaviorLogController {

    @Autowired
    private UserBehaviorLogService userBehaviorLogService;

    // 获取用户的行为日志
    @GetMapping("/user/{userId}")
    public List<UserBehaviorLog> getLogsByUserId(@PathVariable Long userId) {
        return userBehaviorLogService.getLogsByUserId(userId);
    }

    // 获取菜谱的行为日志
    @GetMapping("/recipe/{recipeId}")
    public List<UserBehaviorLog> getLogsByRecipeId(@PathVariable Long recipeId) {
        return userBehaviorLogService.getLogsByRecipeId(recipeId);
    }

    // 新增行为日志
    @PostMapping
    public UserBehaviorLog saveLog(@RequestBody UserBehaviorLog log) {
        return userBehaviorLogService.saveLog(log);
    }
}