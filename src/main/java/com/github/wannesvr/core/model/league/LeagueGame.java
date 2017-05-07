package com.github.wannesvr.core.model.league;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class LeagueGame {
    /**
     * Unique ID for the league of the match being played. A list of league IDs can be found via the GetLeagueListing method.
     */
    private long leagueId;
    /**
     * The list of players within a game.
     */
    @JsonProperty("players")
    private List<LeaguePlayer> players;

    /**
     * Information about the team playing as Radiant for this match.
     */
    @JsonProperty("radiant_team")
    private LeagueTeam radiantTeam;

    /**
     * Information about the team playing as Dire for this match.
     */
    @JsonProperty("dire_team")
    private LeagueTeam direTeam;

    /**
     * Unique ID for the matches lobby.
     */
    @JsonProperty("lobby_id")
    private long lobbyId;

    /**
     * Unique ID for the matches lobby.
     */
    @JsonProperty("spectators")
    private long spectators;

    /**
     * The matches tower status is given as a 32-bit unsigned integer, with the rightmost 22 bits dictating tower state.
     * The higher bits (leftmost) dictate the Dire team's tower status, and the lower bits (rightmost) dictate the Radiant team's tower status;
     * within each 11bit segment, each bit represents an individual tower.
     */
    @JsonProperty("tower_state")
    private int towerState;
}
