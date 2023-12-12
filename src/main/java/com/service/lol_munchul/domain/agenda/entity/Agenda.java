package com.service.lol_munchul.domain.agenda.entity;

import com.service.lol_munchul.domain.agenda.request.AgendaStatus;
import com.service.lol_munchul.domain.member.entity.Member;
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
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String player1Claim;

    private String player2Claim;

    @Enumerated(value = EnumType.STRING)
    private AgendaStatus agendaStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    private Long viewCount;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

//    private List<Reply> replies = new ArrayList<>();
//
//    private GameInfo gameInfo;
//
//    private Board board;


}
