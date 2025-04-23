package com.intelligentrecipe.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/browsing-history")
public class BrowsingHistoryController {

    @GetMapping
    public String getBrowsingHistory() {
        return "Here is your browsing history.";
    }
}