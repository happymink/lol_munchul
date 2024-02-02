package com.service.lol_munchul.domain.reply.entity;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import com.service.lol_munchul.domain.reply.dto.ReplyCreateRequest;
import com.service.lol_munchul.domain.reply.dto.ReplyEditRequest;
import com.service.lol_munchul.domain.reply.dto.ReplyResponse;
import com.service.lol_munchul.global.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
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

    private long likeCount;

    private long hateCount;

    private Long type_id;

    private Long group_id;

    @Builder
    public Reply(ReplyCreateRequest replyCreateRequest, Agenda agenda) {
        this.agenda = agenda;
        this.author = replyCreateRequest.author();
        this.password = replyCreateRequest.password();
        this.content = replyCreateRequest.content();
    }

    public void updateReply(ReplyEditRequest replyEditRequest) {
        this.author = replyEditRequest.author();
        this.content = replyEditRequest.content();
    }

    public ReplyResponse from(Reply reply) {
        return new ReplyResponse(reply.getId(), reply.getAuthor(), reply.getContent(),
                reply.getLikeCount(), reply.getHateCount(), getCreatedDate());
    }

    public void increaseLikeCount(){
        this.likeCount++;
    }

    public void increaseHateCount(){
        this.hateCount++;
    }
}