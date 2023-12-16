package com.service.lol_munchul.domain.game.entity;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class GameInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "gameInfo")
    private Agenda agenda;

    @OneToMany(mappedBy = "gameInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChampionInfo> championInfoList = new ArrayList<>();

}
