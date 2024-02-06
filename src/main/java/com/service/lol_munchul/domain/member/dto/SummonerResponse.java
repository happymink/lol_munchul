package com.service.lol_munchul.domain.member.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerResponse {

    @JsonProperty("puuid")
    private String puuid;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("profileIconId")
    private Integer profileIconId;

    @JsonProperty("summonerLevel")
    private Long summonerLevel;

}
