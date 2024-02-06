package com.service.lol_munchul.domain.agenda.controller;

import com.service.lol_munchul.domain.agenda.dto.AgendaCreateRequest;
import com.service.lol_munchul.domain.agenda.dto.AgendaEditRequest;
import com.service.lol_munchul.domain.agenda.dto.AgendaResponse;
import com.service.lol_munchul.domain.agenda.service.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/agendas")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    @PostMapping("/create")
    public Long createAgenda(@RequestBody @Valid AgendaCreateRequest agendaCreateRequest) {
        log.info(agendaCreateRequest.matchId());
        return agendaService.createAgenda(agendaCreateRequest);
    }

    @PatchMapping("/edit")
    public Long editAgenda(@RequestBody @Valid AgendaEditRequest agendaEditRequest) {
        return agendaService.editAgenda(agendaEditRequest);
    }

    @DeleteMapping("/delete/{agendaId}")
    public Long deleteAgenda(@PathVariable Long agendaId) {
        return agendaService.deleteAgenda(agendaId);
    }

    @GetMapping("/{agendaId}")
    public AgendaResponse viewAgenda(@PathVariable Long agendaId) {
        return agendaService.getAgenda(agendaId);
    }

    @GetMapping("/all")
    public List<AgendaResponse> viewAllAgenda() {
        return agendaService.getAllAgendas();
    }
}