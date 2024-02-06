package com.service.lol_munchul.domain.member.dto;

public record LoginResponse(
        Long memberId,
        String nickname
) {
}
