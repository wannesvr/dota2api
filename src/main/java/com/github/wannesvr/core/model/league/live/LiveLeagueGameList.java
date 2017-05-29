package com.github.wannesvr.core.model.league.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LiveLeagueGameList {
    @JsonProperty("games")
    private List<LiveLeagueGame> leagueGames;
}
