package com.service.lol_munchul.domain.agenda.entity;

import com.service.lol_munchul.domain.agenda.dto.AgendaCreateRequest;
import com.service.lol_munchul.domain.agenda.dto.AgendaEditRequest;
import com.service.lol_munchul.domain.agenda.dto.AgendaResponse;
import com.service.lol_munchul.domain.game.entity.ChampionInfo;
import com.service.lol_munchul.domain.member.entity.Member;
import com.service.lol_munchul.domain.reply.entity.Reply;
import com.service.lol_munchul.global.util.BaseTimeEntity;
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
public class Agenda extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "agenda", fetch = FetchType.LAZY)
    private final List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "agenda", fetch = FetchType.LAZY)
    private final List<ChampionInfo> championInfoList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String videoUrl;

    private String content;

    private long viewCount;

    @Builder
    public Agenda(AgendaCreateRequest agendaCreateRequest, Member member) {
        this.title = agendaCreateRequest.title();
        this.videoUrl = agendaCreateRequest.videoUrl();
        this.content = agendaCreateRequest.content();
        this.member = member;
    }

    @Builder
    public Agenda(Member member, String title, String videoUrl, String content) {
        this.member = member;
        this.title = title;
        this.videoUrl = videoUrl;
        this.content = content;
    }

    public void increaseViewCount() {
        this.viewCount++;
    }

    public Long updateAgenda(AgendaEditRequest agendaEditRequest) {
        this.title = agendaEditRequest.title();
        this.content = agendaEditRequest.content();
        this.videoUrl = agendaEditRequest.videoUrl();
        return this.id;
    }

    public AgendaResponse from() {
        return new AgendaResponse(this.title, this.content, this.getVideoUrl(), this.getViewCount(), getCreatedDate());
    }
}
