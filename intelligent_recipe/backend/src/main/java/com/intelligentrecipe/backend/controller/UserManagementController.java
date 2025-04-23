package com.intelligentrecipe.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserManagementController {

    @GetMapping
    public String getAllUsers() {
        return "Here is the list of all users.";
    }
}