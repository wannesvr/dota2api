package com.github.wannesvr.core.model.hero;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Object detailing a player's ability upgrade.
 */
public class AbilityUpgrade {
    /**
     * ID of the ability upgraded.
     */
    @JsonProperty("ability")
    private int abilityId;

    /**
     * Time since match start that the ability was upgraded.
     */
    @JsonProperty("time")
    private Date time;

    /**
     * The level of the player at time of upgrading.
     */
    @JsonProperty("level")
    private int level;
}
