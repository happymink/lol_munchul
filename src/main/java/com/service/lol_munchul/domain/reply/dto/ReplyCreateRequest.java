package com.service.lol_munchul.domain.reply.dto;

public record ReplyCreateRequest(
        Long agendaId,
        String author,
        String content,
        String password
) {
}
