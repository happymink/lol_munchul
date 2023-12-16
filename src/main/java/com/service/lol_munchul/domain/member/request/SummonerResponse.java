package com.service.lol_munchul.domain.member.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerResponse {

    @JsonProperty("puuid")
    private String puuid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("profileIconId")
    private Integer profileIconId;

    @JsonProperty("summonerLevel")
    private Long summonerLevel;

}
