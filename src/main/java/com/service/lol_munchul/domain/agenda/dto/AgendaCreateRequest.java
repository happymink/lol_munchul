package com.service.lol_munchul.domain.agenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgendaCreateRequest(
        @NotBlank String title,
        @NotNull String content,
        String videoUrl
) {
}
