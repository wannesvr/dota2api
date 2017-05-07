package com.github.wannesvr.core.model.match;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LobbyType {
    INVALID(-1),
    PUBLIC_MATCHMAKING(0),
    PRACTISE(1),
    TOURNAMENT(2),
    TUTORIAL(3),
    CO_OP_WITH_BOTS(4),
    TEAM_MATCH(5),
    SOLO_QUEUE(6),
    RANKED_MATCHMAKING(7),
    ONE_VS_ONE_SOLO_MID(8);

    private final int lobbyType;

    LobbyType(int lobbyType) {
        this.lobbyType = lobbyType;
    }

    @JsonCreator
    public static LobbyType forValue(int i) {
        switch (i) {
            case 0:
                return PUBLIC_MATCHMAKING;
            case 1:
                return PRACTISE;
            case 2:
                return TOURNAMENT;
            case 3:
                return TUTORIAL;
            case 4:
                return CO_OP_WITH_BOTS;
            case 5:
                return TEAM_MATCH;
            case 6:
                return SOLO_QUEUE;
            case 7:
                return RANKED_MATCHMAKING;
            case 8:
                return ONE_VS_ONE_SOLO_MID;
        }

        return INVALID;
    }

    @JsonValue
    public int toValue() {
        return this.lobbyType;
    }
}
