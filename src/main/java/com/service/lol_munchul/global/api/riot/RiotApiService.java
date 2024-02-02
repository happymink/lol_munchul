package com.service.lol_munchul.global.api.riot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.lol_munchul.domain.member.request.SummonerResponse;
import com.service.lol_munchul.global.api.dto.ChampionImageResponse;
import com.service.lol_munchul.global.api.riot.response.ChampionInfoResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RiotApiService {

    private final RiotApiUtil riotApiUtil;
    private static final int MAX_SIZE = 5;

    public SummonerResponse searchSummonerByName(String summonerName) {

        String response = riotApiUtil.searchSummonerByName(summonerName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response, SummonerResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 문자열을 객체로 변환하는 데 실패했습니다.", e);
        }
    }

    public List<String> searchMatchIdByPuuId(String puuid){

        String response = riotApiUtil.searchMatchIdByPuuId(puuid);
        JSONArray jsonArray = new JSONArray(response);
        List<String> matchIdList = new ArrayList<>();

        int sizeCount = 0;
        for(var matchId : jsonArray.toList()){
            if(sizeCount++==MAX_SIZE){
                return matchIdList;
            }
            matchIdList.add((String)matchId);
        }

        return matchIdList;
    }

    public List<ChampionInfoResponse> getGameInfoByMatchId(String matchId){
        return riotApiUtil.getGameInfoByMatchId(matchId);
    }

    public List<ChampionImageResponse> getChampionImageByMatchId(String matchId){
        List<ChampionImageResponse> championImageResponses = new ArrayList<>();

        for(var championInfo : riotApiUtil.getGameInfoByMatchId(matchId)){
            championImageResponses.add(new ChampionImageResponse(
                    championInfo.getChampionId(), championInfo.getChampionName()
            ));
        }
        return championImageResponses;
    }
}