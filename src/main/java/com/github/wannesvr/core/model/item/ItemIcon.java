package com.github.wannesvr.core.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The icon of an item
 */
@Data
public class ItemIcon {
    /**
     * The item icon name to get the CDN path of
     */
    @JsonProperty("iconname")
    private String iconName;

    /**
     * The type of image you want.
     */
    @JsonProperty("icontype")
    private int iconType;
}
