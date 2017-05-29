package com.github.wannesvr.core.model.league.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LiveLeagueGameScoreboard {
    @JsonProperty("duration")
    private int duration;

    @JsonProperty("roshan_respawn_timer")
    private int roshanRespawnTimer;

    @JsonProperty("radiant")
    private LiveLeagueGameScoreboardTeam radiant;

    @JsonProperty("dire")
    private LiveLeagueGameScoreboardTeam dire;
}
