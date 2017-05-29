package com.github.wannesvr.core.model.league.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Information about the team playing in this league game.
 */
@Data
@NoArgsConstructor
public class LiveLeagueGameTeam {
    /**
     * The team name
     */
    @JsonProperty("team_name")
    private String name;

    /**
     * The team id
     */
    @JsonProperty("team_id")
    private long teamId;

    /**
     * The team logo id
     */
    @JsonProperty("team_logo")
    private long teamLogo;

    /**
     * A boolean indicating the team is complete
     */
    @JsonProperty("complete")
    private boolean complete;


}
