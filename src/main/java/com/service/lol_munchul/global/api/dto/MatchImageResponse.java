package com.service.lol_munchul.global.api.dto;

import java.util.List;

public record MatchImageResponse(
        String matchId,
        List<ChampionImageResponse> redTeam,
        List<ChampionImageResponse> blueTeam
) {
}
