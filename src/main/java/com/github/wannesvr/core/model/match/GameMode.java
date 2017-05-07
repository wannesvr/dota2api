package com.github.wannesvr.core.model.match;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum GameMode {
    NONE(0),
    ALL_PICK(1),
    CAPTAINS_MODE(2),
    RANDOM_DRAFT(3),
    SINGLE_DRAFT(4),
    ALL_RANDOM(5),
    INTRO(6),
    DIRETIDE(7),
    REVERSE_CAPTAINS_MODE(8),
    THE_GREEVILING(9),
    TUTORIAL(10),
    MID_ONLY(11),
    LEAST_PLAYED(12),
    NEW_PLAYER_POOL(13),
    COMPENDIUM_MATCHMAKING(14),
    CO_OP_VS_BOTS(15),
    CAPTAINS_DRAFT(16),
    ABILITY_DRAFT(18),
    ALL_RANDOM_DEATHMATCH(20),
    ONE_VS_ONE_MID_ONLY(21),
    RANKED_MATCHMAKING(22);

    @Getter
    private int urlParamValue;

    GameMode(int urlParamValue) {
        this.urlParamValue = urlParamValue;
    }

    @JsonCreator
    public static GameMode forValue(int i) {
        switch (i) {
            case 1:
                return ALL_PICK;
            case 2:
                return CAPTAINS_MODE;
            case 3:
                return RANDOM_DRAFT;
            case 4:
                return SINGLE_DRAFT;
            case 5:
                return ALL_RANDOM;
            case 6:
                return INTRO;
            case 7:
                return DIRETIDE;
            case 8:
                return REVERSE_CAPTAINS_MODE;
            case 9:
                return THE_GREEVILING;
            case 10:
                return TUTORIAL;
            case 11:
                return MID_ONLY;
            case 12:
                return LEAST_PLAYED;
            case 13:
                return NEW_PLAYER_POOL;
            case 14:
                return COMPENDIUM_MATCHMAKING;
            case 15:
                return CO_OP_VS_BOTS;
            case 16:
                return CAPTAINS_DRAFT;
            case 18:
                return ABILITY_DRAFT;
            case 20:
                return ALL_RANDOM_DEATHMATCH;
            case 21:
                return ONE_VS_ONE_MID_ONLY;
            case 22:
                return RANKED_MATCHMAKING;
        }

        return NONE;
    }

    @JsonValue
    public int toValue() {
        return this.urlParamValue;
    }
}
