package com.service.lol_munchul.domain.game.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ChampionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long championLevel;

    private String championName;

    private Long championId;

    private Long item0;

    private Long item1;

    private Long item2;

    private Long item3;

    private Long item4;

    private Long item5;

    private Long item6;

    private Long gold;

    private Long attackDamage;

    private Long takenDamage;

    private Long kill;

    private Long death;

    private Long assist;

    private Double kda;
}
