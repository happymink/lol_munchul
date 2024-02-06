package com.service.lol_munchul.global.api.riot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.lol_munchul.domain.member.dto.SummonerEntryResponse;
import com.service.lol_munchul.domain.member.dto.SummonerResponse;
import com.service.lol_munchul.global.api.dto.ChampionImageResponse;
import com.service.lol_munchul.global.api.dto.MatchImageResponse;
import com.service.lol_munchul.global.api.riot.response.ChampionInfoResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RiotApiService {

    private static final int MAX_SIZE = 5;
    private final RiotApiUtil riotApiUtil;

    public SummonerResponse searchSummonerInfoByName(String summonerName) {

        String response = riotApiUtil.searchSummonerByName(summonerName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response, SummonerResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 문자열을 객체로 변환하는 데 실패했습니다.", e);
        }
    }

    public SummonerEntryResponse searchSummonerEntryBySummonerId(String summonerId) {
        String response = riotApiUtil.searchSummonerEntry(summonerId);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SummonerEntryResponse[] summonerEntries = objectMapper.readValue(response, SummonerEntryResponse[].class);
            return summonerEntries[0];
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 문자열을 객체로 변환하는 데 실패했습니다.", e);
        }
    }

    public List<String> searchMatchIdByPuuId(String puuid) {

        String response = riotApiUtil.searchMatchIdByPuuId(puuid);
        JSONArray jsonArray = new JSONArray(response);
        List<String> matchIdList = new ArrayList<>();

        int sizeCount = 0;
        for (var matchId : jsonArray.toList()) {
            if (sizeCount++ == MAX_SIZE) {
                return matchIdList;
            }
            matchIdList.add((String) matchId);
        }
        return matchIdList;
    }

    public List<ChampionInfoResponse> getGameInfoByMatchId(String matchId) {
        return riotApiUtil.getGameInfoByMatchId(matchId);
    }

    public List<MatchImageResponse> getSummonerMatchByName(String name) {
        List<MatchImageResponse> responseList = new ArrayList<>();

        String puuid = searchSummonerInfoByName(name).getPuuid();
        List<String> matchList = searchMatchIdByPuuId(puuid);

        for (String matchId : matchList) {
            List<ChampionImageResponse> c = getChampionImageByMatchId(matchId);
            responseList.add(new MatchImageResponse(matchId, madeRedTeam(c), madeBlueTeam(c)));
        }

        return responseList;
    }

    public List<ChampionImageResponse> getChampionImageByMatchId(String matchId) {
        List<ChampionImageResponse> championImageResponses = new ArrayList<>();

        for (ChampionInfoResponse championInfo : riotApiUtil.getGameInfoByMatchId(matchId)) {
            championImageResponses.add(new ChampionImageResponse(
                    madeUrl(championInfo.getChampionName())
            ));
        }
        return championImageResponses;
    }

    private List<ChampionImageResponse> madeRedTeam(List<ChampionImageResponse> responses) {
        List<ChampionImageResponse> returnList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            returnList.add(responses.get(i));
        }
        return returnList;
    }

    private List<ChampionImageResponse> madeBlueTeam(List<ChampionImageResponse> responses) {
        List<ChampionImageResponse> returnList = new ArrayList<>();
        for (int i = 5; i < responses.size(); i++) {
            returnList.add(responses.get(i));
        }
        return returnList;
    }

    private String madeUrl(String championName) {
        return "https://ddragon.leagueoflegends.com/cdn/13.24.1/img/champion/" + championName + ".png";
    }
}