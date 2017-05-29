package com.github.wannesvr.core.model.league.live;

public enum  SeriesType {
    NONE(0), BEST_OF_THREE(1), BEST_OF_FIVE(2);

    private int type;

    SeriesType(int type) {
        this.type = type;
    }
}
