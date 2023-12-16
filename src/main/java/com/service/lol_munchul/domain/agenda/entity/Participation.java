package com.service.lol_munchul.domain.agenda.entity;

import com.service.lol_munchul.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime participationAt;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "participation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Agenda> agendaList = new ArrayList<>();


}
