package com.service.lol_munchul.domain.member.dto;

public record LoginRequest(
        String email,
        String password
) {
}
