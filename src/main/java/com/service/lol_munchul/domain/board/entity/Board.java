package com.service.lol_munchul.domain.board.entity;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "board")
    private List<Agenda> agendaList;
}
