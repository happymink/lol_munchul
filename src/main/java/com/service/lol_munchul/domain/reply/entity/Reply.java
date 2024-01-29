package com.service.lol_munchul.domain.reply.entity;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import com.service.lol_munchul.global.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    private String author;

    private String password;

    private String content;

    private Long likeCount;

    private Long hateCount;

    private Long type_id;

    private Long group_id;
}