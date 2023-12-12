package com.service.lol_munchul.domain.member.request;

public record LoginRequest(
        String email,
        String password
) {
}
