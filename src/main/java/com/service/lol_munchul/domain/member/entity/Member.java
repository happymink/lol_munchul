package com.service.lol_munchul.domain.member.entity;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import com.service.lol_munchul.domain.agenda.entity.Participation;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String summonnerName;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participation> participationList = new ArrayList<>();

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private SummonnerInfo summonnerInfo;

    @Builder
    public Member(String email, String password, String summonnerName) {
        this.email = email;
        this.password = password;
        this.summonnerName = summonnerName;
    }

}
