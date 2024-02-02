package com.service.lol_munchul.domain.game.controller;

import com.service.lol_munchul.global.api.dto.ChampionImageResponse;
import com.service.lol_munchul.global.api.riot.RiotApiService;
import com.service.lol_munchul.global.api.riot.response.ChampionInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/champions")
@RequiredArgsConstructor
@RestController
public class ChampionApiController {

    private final RiotApiService riotApiService;

    @GetMapping("/match-info")
    public List<ChampionInfoResponse> getMatchInfo(@RequestParam String matchId){
        return riotApiService.getGameInfoByMatchId(matchId);
    }

    @GetMapping("/match-image-info")
    public List<ChampionImageResponse> getMatchImageInfo(@RequestParam String matchId){
        return riotApiService.getChampionImageByMatchId(matchId);
    }

}
