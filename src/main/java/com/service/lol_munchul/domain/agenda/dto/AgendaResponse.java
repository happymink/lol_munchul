package com.service.lol_munchul.domain.agenda.dto;

import java.time.LocalDateTime;

public record AgendaResponse(
        String title,
        String content,
        String videoUrl,
        Long viewCount,
        LocalDateTime createdDate
) {
}
