package com.github.wannesvr.core.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameItem {
    /**
     * ID of the hero
     */
    @JsonProperty("id")
    private int id;

    /**
     * The tokenized string for the name of the hero.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The in-game gold cost of the item.
     */
    @JsonProperty("cost")
    private int cost;

    /**
     * Boolean - true if the item is only available in the secret shop.
     */
    @JsonProperty("secret_shop")
    private boolean secretShop;

    /**
     * Boolean - true if the item is available in the side shop.
     */
    @JsonProperty("side_shop")
    private boolean sideShop;

    /**
     * Boolean - true if the item is a recipe type item.
     */
    @JsonProperty("recipe")
    private boolean recipe;

    @JsonProperty("localized_name")
    private String localizedName;
}
