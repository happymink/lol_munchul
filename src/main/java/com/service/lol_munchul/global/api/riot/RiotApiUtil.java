package com.service.lol_munchul.global.api.riot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.lol_munchul.domain.member.request.SummonerResponse;
import com.service.lol_munchul.global.api.riot.response.ParticipantDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiotApiUtil {

    private final RiotApiService riotApiService;

    public SummonerResponse searchSummonerByName(String summonerName) {

        String response = riotApiService.searchSummonerByName(summonerName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response, SummonerResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 문자열을 객체로 변환하는 데 실패했습니다.", e);
        }
    }

    public String searchMatchIdByPuuId(String puuid){

        String response = riotApiService.searchMatchIdByPuuId(puuid);
        JSONArray jsonArray = new JSONArray(response);

        return jsonArray.getString(0);
    }

    public List<ParticipantDto> getGameInfoByMatchId(String matchId){
        return riotApiService.getGameInfoByMatchId(matchId);
    }
}