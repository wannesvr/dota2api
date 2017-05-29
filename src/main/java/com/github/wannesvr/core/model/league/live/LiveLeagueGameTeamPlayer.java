package com.github.wannesvr.core.model.league.live;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LiveLeagueGameTeamPlayer {
    @JsonProperty("account_id")
    private long accountId;

    @JsonProperty("player_slot")
    private int playerSlot;

    @JsonProperty("hero_id")
    private byte heroId;

    @JsonProperty("gold")
    private int gold;

    @JsonProperty("last_hits")
    private int lastHits;

    @JsonProperty("denies")
    private int denies;

    @JsonProperty("gold_per_min")
    private int goldPerMin;

    @JsonProperty("xp_per_min")
    private int xpPerMin;

    @JsonProperty("kills")
    private int kills;

    @JsonProperty("deaths")
    private int deaths;

    @JsonProperty("assists")
    private int assists;

    @JsonProperty("ultimate_state")
    private int ultimateState;

    @JsonProperty("ultimate_cooldown")
    private int ultimateCooldown;

    @JsonProperty("item_0")
    private int topLeftItem;

    @JsonProperty("item_1")
    private int topCenterItem;

    @JsonProperty("item_2")
    private int topRightItem;

    @JsonProperty("item_3")
    private int bottomLeftItem;

    @JsonProperty("item_4")
    private int bottomCenterItem;

    @JsonProperty("item_5")
    private int bottomRightItem;

    @JsonProperty("respawn_timer")
    private int respawnTimer;

    @JsonProperty("position_x")
    private double positionX;

    @JsonProperty("position_y")
    private double positionY;

    @JsonProperty("net_worth")
    private int netWorth;
}
