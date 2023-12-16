package com.service.lol_munchul.domain.agenda.request;

public record AgendaRequest(
        String title,
        String player1Name,
        String player2Name,
        String player1Claim,
        String player2Claim
) {
}
