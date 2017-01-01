package api.dota2.model.hero;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hero {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("localized_name")
    private String localizedName;
}
