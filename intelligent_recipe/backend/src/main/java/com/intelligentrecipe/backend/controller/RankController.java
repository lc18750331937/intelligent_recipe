package com.intelligentrecipe.backend.controller;

import com.intelligentrecipe.backend.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/rank")
public class RankController {

    @Autowired
    private RankService rankService;

    // 更新热度
    @PostMapping("/update")
    public String updateHotRank(@RequestParam Long recipeId, @RequestParam double score) {
        rankService.updateHotRank(recipeId, score);
        return "Hot rank updated successfully!";
    }

    // 获取热度排行榜
    @GetMapping("/hot")
    public Set<ZSetOperations.TypedTuple<Object>> getHotRank(@RequestParam(defaultValue = "10") int topN) {
        return rankService.getHotRank(topN);
    }
}