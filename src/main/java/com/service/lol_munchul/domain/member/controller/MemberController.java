package com.service.lol_munchul.domain.member.controller;

import com.service.lol_munchul.domain.member.dto.SummonerResponse;
import com.service.lol_munchul.domain.member.service.MemberService;
import com.service.lol_munchul.global.api.riot.RiotApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final RiotApiService riotApiService;
    @Value("${api.riot.key}")
    String a;

    @GetMapping("/my-info")
    public SummonerResponse getSummonerInfo(){
        String name = "똥 같은 플레이";
        return riotApiService.searchSummonerInfoByName(name);
    }

    @GetMapping("/game-history")
    public List<String> getSummonerMatchHistory(){
        String puuid = "IbxOxxeQnEpJPnZ-XYsOOLpHrfdx5Otv23pa8amoUba0oT_w0EG3hC8F9_Q1JqxluBzTe3c54Itg_Q";
        return riotApiService.searchMatchIdByPuuId(puuid);
    }
}
