package com.service.lol_munchul.domain.reply.entity;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    private String author;

    private String password;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long likeCount;

    private Long hateCount;

    private Long type_id;

    private Long group_id;

}
