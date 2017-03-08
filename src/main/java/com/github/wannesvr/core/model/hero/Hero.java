package com.github.wannesvr.core.model.hero;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hero {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("localized_name")
    private String localizedName;
}
