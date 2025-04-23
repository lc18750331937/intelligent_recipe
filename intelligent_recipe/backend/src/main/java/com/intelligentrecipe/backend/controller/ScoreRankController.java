package com.intelligentrecipe.backend.controller;

import com.intelligentrecipe.backend.service.ScoreRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/rank")
public class ScoreRankController {

    @Autowired
    private ScoreRankService scoreRankService;

    // 定期更新评分排行榜
    @PostMapping("/update-score")
    public String updateScoreRank() {
        scoreRankService.updateScoreRank();
        return "Score rank updated successfully!";
    }

    // 获取评分排行榜
    @GetMapping("/score")
    public Set<ZSetOperations.TypedTuple<Object>> getScoreRank(@RequestParam(defaultValue = "10") int topN) {
        return scoreRankService.getScoreRank(topN);
    }
}