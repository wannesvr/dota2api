package com.github.wannesvr.core.model.match;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LeaverStatus {
    NONE(0),
    DISCONNECTED(1),
    DISCONNECTED_TOO_LONG(2),
    ABANDONED(3),
    AFK(4),
    NEVER_CONNECTED(5),
    NEVER_CONNECTED_TOO_LONG(6);

    private int leaverStatus;

    LeaverStatus(int leaverStatus) {
        this.leaverStatus = leaverStatus;
    }

    @JsonCreator
    public static LeaverStatus forValue(int i) {
        switch (i) {
            case 1:
                return DISCONNECTED;
            case 2:
                return DISCONNECTED_TOO_LONG;
            case 3:
                return ABANDONED;
            case 4:
                return AFK;
            case 5:
                return NEVER_CONNECTED;
            case 6:
                return NEVER_CONNECTED_TOO_LONG;
        }

        return NONE;
    }

    @JsonValue
    public int toValue() {
        return this.leaverStatus;
    }
}
