package com.github.wannesvr.core.model.match;

import lombok.Getter;

public enum SkillBracket {
    ANY(0), NORMAL(1), HIGH(2), VERY_HIGH(3);

    @Getter
    private final int urlParamValue;

    SkillBracket(int urlParamValue) {
        this.urlParamValue = urlParamValue;
    }
}
