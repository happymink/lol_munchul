package com.service.lol_munchul.web;

import com.service.lol_munchul.domain.agenda.dto.AgendaResponse;
import com.service.lol_munchul.domain.agenda.service.AgendaService;
import com.service.lol_munchul.global.api.dto.ChampionImageResponse;
import com.service.lol_munchul.global.api.riot.RiotApiService;
import com.service.lol_munchul.global.api.riot.response.ChampionInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final AgendaService agendaService;
    private final RiotApiService riotApiService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("agendas", agendaService.getAllAgendas());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model) {
        var g = riotApiService.getSummonerMatchByName("똥 같은 플레이");
        var c = riotApiService.searchSummonerInfoByName("똥 같은 플레이");
        var d = riotApiService.getSummonerMatchByName("똥 같은 플레이");
        var s = riotApiService.searchSummonerEntryBySummonerId(c.getId());

        model.addAttribute("matchInfo", d);

        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable(value = "id") Long id, Model model) {
        AgendaResponse responseDto = agendaService.getAgenda(id);
        model.addAttribute("agendas", responseDto);

        return "posts-update";
    }

    @GetMapping("/posts/detail/{id}")
    public String postsDetail(@PathVariable(value = "id") Long id, Model model) {
        log.info("id : {}", id);
        AgendaResponse agenda = agendaService.getAgenda(id);
        log.info("matchId : {}", agenda.matchId());
        List<ChampionInfoResponse> championInfoResponseList = riotApiService.getGameInfoByMatchId(agenda.matchId());
        model.addAttribute("agendas", agenda);
        model.addAttribute("gameInfo", championInfoResponseList);
        return "posts-detail";
    }


    private List<String> madeTeam1(List<ChampionImageResponse> responses){
        List<String> returnList = new ArrayList<>();
        for(int i = 0; i<5; i++){
            returnList.add((responses.get(i).championName()));
        }
        return returnList;
    }
    private List<String> madeTeam2(List<ChampionImageResponse> responses){
        List<String> returnList = new ArrayList<>();
        for(int i = 5; i<responses.size(); i++){
            returnList.add((responses.get(i).championName()));
        }
        return returnList;
    }
}
