package com.github.wannesvr.core.model.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum ItemIconType {
    NORMAL(0), LARGE(1), INGAME(2);

    @Getter
    private int urlParamValue;

    ItemIconType(int urlParamValue) {
        this.urlParamValue = urlParamValue;
    }

    @JsonCreator
    public static ItemIconType forValue(int i){
        switch (i){
            case 0: return NORMAL;
            case 1: return LARGE;
            case 2: return INGAME;
        }

        return INGAME;
    }

    @JsonValue
    public int toValue(){
        return this.urlParamValue;
    }
}
