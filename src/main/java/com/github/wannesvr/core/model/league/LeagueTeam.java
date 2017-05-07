package com.github.wannesvr.core.model.league;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LeagueTeam {
    /**
     * The team's unique ID.
     */
    @JsonProperty("team_id")
    private long teamId;

    /**
     * The team's name.
     */
    @JsonProperty("team_name")
    private String teamName;

    /**
     * The UGC id for the team logo. You can resolve this with the GetUGCFileDetails method.
     */
    @JsonProperty("team_logo")
    private String teamLogoId;

    /**
     * Whether the players for this team are all team members.
     */
    @JsonProperty("complete")
    private boolean complete;
}
