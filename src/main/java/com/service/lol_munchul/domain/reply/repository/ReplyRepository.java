package com.service.lol_munchul.domain.reply.repository;


import com.service.lol_munchul.domain.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByAgendaId(Long agendaId);
}
