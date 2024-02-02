package com.service.lol_munchul.domain.agenda.service;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import com.service.lol_munchul.domain.agenda.repository.AgendaRepository;
import com.service.lol_munchul.domain.agenda.dto.AgendaCreateRequest;
import com.service.lol_munchul.domain.agenda.dto.AgendaEditRequest;
import com.service.lol_munchul.domain.agenda.dto.AgendaResponse;
import com.service.lol_munchul.domain.member.entity.Member;
import com.service.lol_munchul.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final MemberRepository memberRepository;

    public Long createAgenda(AgendaCreateRequest agendaCreateRequest) {

        Member member = memberRepository.save(Member.builder().build());
        Agenda agenda = Agenda.builder()
                .agendaCreateRequest(agendaCreateRequest).member(member).build();
        return agendaRepository.save(agenda).getId();
    }

    public Long editAgenda(AgendaEditRequest agendaEditRequest) {
        Agenda agenda = agendaRepository.findById(agendaEditRequest.agendaId()).orElseThrow(IllegalArgumentException::new);
        return agenda.updateAgenda(agendaEditRequest);
    }

    public Long deleteAgenda(Long agendaId) {
        agendaRepository.deleteById(agendaId);
        return agendaId;
    }

    public AgendaResponse getAgenda(Long agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId).orElseThrow(IllegalArgumentException::new);
        agenda.increaseViewCount();
        return agenda.from();
    }

    public List<AgendaResponse> getAllAgendas() {
        return agendaRepository.findAll().stream().map(Agenda::from).toList();
    }
}

