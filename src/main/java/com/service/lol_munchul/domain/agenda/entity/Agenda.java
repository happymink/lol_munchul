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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Column(length = 5000)
    private String content;

    private String matchId;

    private String tier;

    private long viewCount;

    @Builder
    public Agenda(AgendaCreateRequest agendaCreateRequest, Member member) {
        this.title = agendaCreateRequest.title();
        this.videoUrl = convertVideoUrl(agendaCreateRequest.videoUrl());
        this.content = agendaCreateRequest.content();
        this.matchId = agendaCreateRequest.matchId();
        //this.tier = member.getSummonnerInfo().getSummonerTier();
        this.tier = "EMERALD";
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
        this.matchId = agendaEditRequest.matchId();
        return this.id;
    }

    public AgendaResponse from() {
        //todo this.member.getSummonerName
        return new AgendaResponse(this.id, "똥 같은 플레이", this.title, this.content, this.videoUrl,
                this.viewCount, this.matchId, this.tier, convertDateTime(this.getCreatedDate()));
    }

    private String convertVideoUrl(String videoUrl){
        //링크에 추가 파라미터가 붙는 경우, 생각해야할까?
        return videoUrl.replace("watch?v=", "embed/");
    }

    private String convertDateTime(LocalDateTime dateTime){
        //Entity에 유틸 의존성을 추가해도 괜찮을까?
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter);
    }
}
