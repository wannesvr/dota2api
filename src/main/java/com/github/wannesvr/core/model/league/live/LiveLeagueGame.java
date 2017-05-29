package com.github.wannesvr.core.model.league.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LiveLeagueGame {
    /**
     * Unique ID for the league of the match being played. A list of league IDs can be found via the GetLeagueListing method.
     */
    @JsonProperty("league_id")
    private long leagueId;

    /**
     * The id of the game series.
     */
    @JsonProperty("series_id")
    private long seriesId;

    /**
     * Unique ID for the matches lobby.
     */
    @JsonProperty("lobby_id")
    private long lobbyId;

    /**
     * The match id
     */
    @JsonProperty("match_id")
    private long matchId;

    /**
     * The league series id.
     */
    @JsonProperty("league_series_id")
    private long leagueSeriesId;

    /**
     * The league game id
     */
    @JsonProperty("league_game_id")
    private long leagueGameId;

    /**
     * The number of the current game in a series.
     */
    @JsonProperty("game_number")
    private int gameNumber;

    /**
     * The list of players within a game.
     */
    @JsonProperty("players")
    private List<LiveLeagueGamePlayer> players;

    @JsonProperty("radiant_team")
    private LiveLeagueGameTeam radiantTeam;

    @JsonProperty("dire_team")
    private LiveLeagueGameTeam direTeam;

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

    /**
     * The stream delay in seconds.
     */
    @JsonProperty("stream_delay_s")
    private int streamDelayInSeconds;

    /**
     * The amount of Dire wins in this series.
     */
    @JsonProperty("radiant_series_wins")
    private int radiantSeriesWins;

    /**
     * The amount of Dire wins in this series.
     */
    @JsonProperty("dire_series_wins")
    private int direSeriesWins;

    /**
     * The type of the series.
     * @see SeriesType
     */
    @JsonProperty("series_type")
    private SeriesType seriesType;

    /**
     * The league tier.
     */
    @JsonProperty("league_tier")
    private int leagueTier;

    /**
     * The name of the stage.
     */
    @JsonProperty("stage_name")
    private String stageName;

    @JsonProperty("scoreboard")
    private LiveLeagueGameScoreboard scoreboard;
}
