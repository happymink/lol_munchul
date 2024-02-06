package com.service.lol_munchul.domain.member.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class SummonnerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String summonerTier;

    private String summonerRank;

    private String winningPercentage;

    private String summonerTag;

    private String summonerIcon;

}
