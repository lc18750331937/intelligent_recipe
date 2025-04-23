package com.intelligentrecipe.backend.controller;

import com.intelligentrecipe.backend.service.FavoriteRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/rank")
public class FavoriteRankController {

    @Autowired
    private FavoriteRankService favoriteRankService;

    // 定期更新收藏排行榜
    @PostMapping("/update-favorite")
    public String updateFavoriteRank() {
        favoriteRankService.updateFavoriteRank();
        return "Favorite rank updated successfully!";
    }

    // 获取收藏排行榜
    @GetMapping("/favorite")
    public Set<ZSetOperations.TypedTuple<Object>> getFavoriteRank(@RequestParam(defaultValue = "10") int topN) {
        return favoriteRankService.getFavoriteRank(topN);
    }
}