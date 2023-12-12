package com.service.lol_munchul.domain.agenda.service;

import com.service.lol_munchul.domain.agenda.repository.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository agendaRepository;
}
