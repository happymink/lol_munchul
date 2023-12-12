package com.service.lol_munchul.domain.member.request;

public record LoginResponse(
        Long memberId,
        String nickname
) {
}
