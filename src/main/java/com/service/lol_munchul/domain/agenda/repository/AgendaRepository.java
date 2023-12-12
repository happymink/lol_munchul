package com.service.lol_munchul.domain.agenda.repository;

import com.service.lol_munchul.domain.agenda.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
