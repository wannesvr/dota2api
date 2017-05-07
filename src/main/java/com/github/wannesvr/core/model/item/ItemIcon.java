package com.github.wannesvr.core.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The icon of an item
 */
@Data
@NoArgsConstructor
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
