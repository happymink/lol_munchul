package com.service.lol_munchul.global.api.riot;

import com.service.lol_munchul.global.api.riot.response.InfoDto;
import com.service.lol_munchul.global.api.riot.response.MatchDto;
import com.service.lol_munchul.global.api.riot.response.ParticipantDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RiotApiService {

    @Value("${api.riot.key}")
    private String API_KEY;  // Riot API 키를 여기에 입력해주세요.

    private static final String BASE_URL = "https://kr.api.riotgames.com/lol/";  // 한국 서버 기준 URL

    private RestTemplate restTemplate;

    public RiotApiService() {
        this.restTemplate = new RestTemplate();
    }

    // 소환사 이름으로 소환사 정보 검색
    public String searchSummonerByName(String summonerName) {
        System.out.println("API_KEY = " + API_KEY);
        String url = BASE_URL + "summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    // 소환사 이름으로 전적 ID 검색
    public String searchMatchIdByPuuId(String puuid) {
        // TODO: 이 메서드는 Riot API의 어느 엔드포인트를 사용하는지에 따라 구현이 달라집니다.
        // 적절한 엔드포인트를 찾아 url을 설정하고, restTemplate.getForEntity()를 호출하세요.

        String url = "https://asia.api.riotgames.com/lol/" + "match/v5/matches/by-puuid/" + puuid +"/ids"+ "?api_key=" + API_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }

    // 전적 ID로 게임 정보 가져오기
    public List<ParticipantDto> getGameInfoByMatchId(String matchId) {
        String url = "https://asia.api.riotgames.com/lol/" + "match/v5/matches/" + matchId + "?api_key=" + API_KEY;

        System.out.println("url : "+ url);
        ResponseEntity<MatchDto> response = restTemplate.getForEntity(url, MatchDto.class);

        return response.getBody().getInfo().getParticipants();
    }
}