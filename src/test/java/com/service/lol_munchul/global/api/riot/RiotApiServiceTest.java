package com.service.lol_munchul.global.api.riot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RiotApiServiceTest {

    @Autowired
    private RiotApiService riotApiService;

    @Autowired
    private RiotApiUtil riotApiUtil;

    @Test
    public void testSearchSummonerByName() {
        String summonerName = "똥 같은 플레이";  // 테스트할 소환사 이름
        String result = riotApiService.searchSummonerByName(summonerName);
        System.out.println(result);

        var a = riotApiUtil.searchSummonerByName("똥 같은 플레이");

        System.out.println(a.getName());
        System.out.println(a.getPuuid());
        System.out.println(a.getProfileIconId());
        System.out.println(a.getSummonerLevel());
        Assertions.assertNotNull(result, "소환사 정보가 null입니다.");
    }

}