package com.service.lol_munchul.global.api.riot.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ParticipantDto {

    private Integer kills;
    private Integer assists;
    private Integer deaths;
    private Integer champLevel;
    private Integer championId;
    private String championName;
    private Integer item0;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private Integer item5;
    private Integer item6;
    private Integer goldEarned;
    private Integer totalDamageDealtToChampions;
    private Integer totalDamageTaken;

}
