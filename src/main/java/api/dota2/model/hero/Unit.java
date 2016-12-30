package api.dota2.model.hero;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Unit {
    @JsonProperty("unitname")
    private String unitName;

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

}
