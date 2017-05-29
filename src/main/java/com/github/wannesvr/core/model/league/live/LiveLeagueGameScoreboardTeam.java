package com.github.wannesvr.core.model.league.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LiveLeagueGameScoreboardTeam {
    @JsonProperty("score")
    private int score;

    @JsonProperty("tower_state")
    private int towerStatus;

    @JsonProperty("barracks_state")
    private int barracksStatus;

    @JsonProperty("picks")
    private List<Pick> picks;

    @JsonProperty("bans")
    private List<Ban> bans;

    @JsonProperty("players")
    private List<LiveLeagueGameTeamPlayer> players;

    public static class Pick {
        @JsonProperty("hero_id")
        private int heroId;
    }

    public static class Ban {
        @JsonProperty("hero_id")
        private int heroId;
    }
}
