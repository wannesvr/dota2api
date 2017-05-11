package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.core.model.item.ItemIconPath;
import com.github.wannesvr.core.model.item.ItemIconType;
import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Request to /IEconDOTA2_570/GetItemIconPath/v1
 *
 * @see com.github.wannesvr.core.model.item.ItemIcon
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class ItemIconPathRequest extends AbstractSteamApiRequest {
    private String iconName;
    private ItemIconType iconType;

    private ItemIconPathRequest() {
        super("/IEconDOTA2_570/GetItemIconPath/v1");
    }

    @Override
    public Class getResponseClass() {
        return ItemIconPath.class;
    }

    /**
     * Static builder class to be used to create an instance of {@link ItemIconPathRequest}.
     */
    public static class Builder implements SteamApiRequestBuilder<ItemIconPathRequest> {
        private ItemIconPathRequest request;

        public Builder(String iconName) {
            this.request = new ItemIconPathRequest();
            this.request.urlParam("iconname", iconName);
            this.request.setIconName(iconName);
        }

        /**
         * The type of image you want.
         *
         * @param type the {@link ItemIconType}
         * @return Builder instance
         */
        public Builder iconType(ItemIconType type) {
            this.request.urlParam("icon_type", type.getUrlParamValue());
            this.request.setIconType(type);
            return this;
        }

        /**
         * Returns the {@code ItemIconPathRequest} instance created by the builder.
         *
         * @return a {@link ItemIconPathRequest}
         */
        @Override
        public ItemIconPathRequest build() {
            return request;
        }
    }
}
