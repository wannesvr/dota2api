package com.github.wannesvr.core.model.match;

import com.github.wannesvr.core.model.hero.AbilityUpgrade;
import com.github.wannesvr.core.model.hero.Unit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchDetailPlayer {
    @JsonProperty("account_id")
    private long accountId;

    @JsonProperty("player_slot")
    private int playerSlot;

    @JsonProperty("hero_id")
    private byte heroId;

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

    @JsonProperty("kills")
    private int kills;

    @JsonProperty("deaths")
    private int deaths;

    @JsonProperty("assists")
    private int assists;

    @JsonProperty("leaver_status")
    private LeaverStatus leaverStatus;

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

    @JsonProperty("gold_spent")
    private int goldSpent;

    @JsonProperty("hero_damage")
    private int heroDamage;

    @JsonProperty("tower_damage")
    private int towerDamage;

    @JsonProperty("hero_healing")
    private int heroHealing;

    @JsonProperty("level")
    private int level;

    @JsonProperty("ability_upgrades")
    private List<AbilityUpgrade> abilityUpgrades;

    @JsonProperty("additional_units")
    private List<Unit> additionalUnits;
}
