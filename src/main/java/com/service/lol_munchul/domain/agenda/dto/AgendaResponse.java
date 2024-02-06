package com.service.lol_munchul.domain.agenda.dto;

public record AgendaResponse(
        Long id,
        String name,
        String title,
        String content,
        String videoUrl,
        Long viewCount,
        String matchId,
        String tier,
        String createdDate
) {
}
