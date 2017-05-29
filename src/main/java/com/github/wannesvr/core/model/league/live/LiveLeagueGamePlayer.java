package com.github.wannesvr.core.model.league.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LiveLeagueGamePlayer {
    /**
     * 32-bit account ID.
     */
    @JsonProperty("account_id")
    private long accountId;

    /**
     * The player's display name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The hero's unique ID. A list of hero IDs can be found via the GetHeroes method.
     */
    @JsonProperty("hero_id")
    private long heroId;

    /**
     * What team the player is currently playing as.
     * 0 - Radiant
     * 1 - Dire
     * 2 - Broadcaster
     * 4 - Unassigned
     */
    @JsonProperty("team")
    private int team;
}
