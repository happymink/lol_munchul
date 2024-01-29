package com.service.lol_munchul.domain.agenda.entity;

import com.service.lol_munchul.domain.agenda.request.AgendaStatus;
import com.service.lol_munchul.domain.board.entity.Board;
import com.service.lol_munchul.domain.game.entity.ChampionInfo;
import com.service.lol_munchul.domain.reply.entity.Reply;
import com.service.lol_munchul.global.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Agenda extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "agenda", fetch = FetchType.LAZY)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "agenda", fetch = FetchType.LAZY)
    private List<ChampionInfo> championInfoList;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String title;

    private String videoUrl;

    private String content;

    private Long viewCount;
}
