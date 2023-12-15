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

    private String summonnerTier;

    private String summonnerRank;

    private String winningPercentage;

    private String summonnerTag;

    private String summonnerIcon;

}
