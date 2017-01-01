package api.dota2.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The icon of an item
 */
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
