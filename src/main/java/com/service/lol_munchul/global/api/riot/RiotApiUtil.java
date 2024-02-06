package com.service.lol_munchul.global.api.riot;

import com.service.lol_munchul.global.api.riot.response.AccountDto;
import com.service.lol_munchul.global.api.riot.response.MatchDto;
import com.service.lol_munchul.global.api.riot.response.ChampionInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
@Slf4j
@Service
public class RiotApiUtil {

    private static final String BASE_URL = "https://kr.api.riotgames.com/lol/";  // 한국 서버 기준 URL
    @Value("${api.riot.key}")
    private String API_KEY;
    private final String defaultTag = "kr1"; //기본 태그
    private final RestTemplate restTemplate;

    public RiotApiUtil() {
        this.restTemplate = new RestTemplate();
    }

    public String searchPuuidByRiotId(String name, String tag) {

        String url = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + name + "/" + tag + "?api_key=" + API_KEY;
        ResponseEntity<AccountDto> response;
        try {
            response = restTemplate.getForEntity(url, AccountDto.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("소환사 이름을 찾을 수 없습니다.");
        }

        return Objects.requireNonNull(response.getBody()).getPuuid();
    }

    public String searchPuuidByRiotId(String name) {

        String url = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + name + "/" + defaultTag + "?api_key=" + API_KEY;

        ResponseEntity<String> response;
        try {
            response = restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("소환사 이름을 찾을 수 없습니다.");
        }
        return response.getBody();
    }


    // 소환사 이름으로 소환사 정보 검색
    public String searchSummonerByName(String summonerName) {
        String url = BASE_URL + "summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + API_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }

    // 소환사 이름으로 전적 ID 검색
    public String searchMatchIdByPuuId(String puuid) {
        String url = "https://asia.api.riotgames.com/lol/" + "match/v5/matches/by-puuid/" + puuid + "/ids" + "?api_key=" + API_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }

    // 전적 ID로 게임 정보 가져오기
    public List<ChampionInfoResponse> getGameInfoByMatchId(String matchId) {
        String url = "https://asia.api.riotgames.com/lol/" + "match/v5/matches/" + matchId + "?api_key=" + API_KEY;
        ResponseEntity<MatchDto> response = restTemplate.getForEntity(url, MatchDto.class);

        return response.getBody().getInfo().getParticipants();
    }

    public String searchSummonerEntry(String encryptedSummonerId){
        String url = BASE_URL + "league/v4/entries/by-summoner/"+ encryptedSummonerId + "?api_key=" + API_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }
}