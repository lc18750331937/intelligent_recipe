package com.intelligentrecipe.backend.controller;

import com.intelligentrecipe.backend.entity.User;
import com.intelligentrecipe.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // 用户注册
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    // 用户登录
    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return userService.authenticate(user.getUsername(), user.getPassword());
    }
}