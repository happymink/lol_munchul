package com.service.lol_munchul.domain.agenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgendaEditRequest(
        @NotNull Long agendaId,
        @NotBlank String title,
        @NotNull String content,
        @NotNull String matchId,
        String videoUrl
) {
}
