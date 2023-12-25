package com.service.lol_munchul.domain.agenda.entity;

import com.service.lol_munchul.domain.agenda.request.AgendaStatus;
import com.service.lol_munchul.domain.board.entity.Board;
import com.service.lol_munchul.domain.game.entity.GameInfo;
import com.service.lol_munchul.domain.member.entity.Member;
import com.service.lol_munchul.domain.reply.entity.Reply;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Participation> participation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_info_id")
    private GameInfo gameInfo;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String title;

    private String content;

    private String player1Claim;

    private String player2Claim;

    @Enumerated(value = EnumType.STRING)
    private AgendaStatus agendaStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    private Long viewCount;


}
