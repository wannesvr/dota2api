package com.github.wannesvr.core.model.match;

public enum SkillBracket {
    ANY(0), NORMAL(1), HIGH(2), VERY_HIGH(3);

    private final int skillBracket;

    SkillBracket(int skillBracket) {
        this.skillBracket = skillBracket;
    }
}
