package com.service.lol_munchul.domain.member.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerEntryResponse {

    @JsonProperty("queueType")
    private String queueType;

    @JsonProperty("tier")
    private String tier;

    @JsonProperty("rank")
    private String rank;

    @JsonProperty("wins")
    private Integer wins;

    @JsonProperty("losses")
    private Integer losses;

    @JsonProperty("leaguePoints")
    private Integer leaguePoints;
}
