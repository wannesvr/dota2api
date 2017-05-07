package com.github.wannesvr.core.model.league;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LeagueDetail {
    @JsonProperty("leagueid")
    private int leagueId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tournament_url")
    private String tournamentUrl;
}
