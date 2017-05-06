package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.core.request.AbstractDota2ApiRequest;
import com.github.wannesvr.core.request.Dota2ApiRequestBuilder;

import java.util.Objects;

/**
 * Request to /IEconDOTA2_570/GetItemIconPath/v1
 */
public class ItemIconPathRequest extends AbstractDota2ApiRequest {

    private ItemIconPathRequest() {
        super("/IEconDOTA2_570/GetItemIconPath/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link ItemIconPathRequest}.
     */
    public static class Builder implements Dota2ApiRequestBuilder<ItemIconPathRequest> {
        private ItemIconPathRequest request;

        public Builder() {
            this.request = new ItemIconPathRequest();
        }

        /**
         * The language to provide hero names in.
         * @param language the language
         * @return Builder instance
         */
        public Builder language(String language){
            this.request.urlParam("language", Objects.requireNonNull(language));
            return this;
        }

        /**
         * If true, return a list of itemized heroes only.
         * @param itemizedOnly whether you want itemized heroes only
         * @return Builder instance
         */
        public Builder itemizedOnly(boolean itemizedOnly){
            this.request.urlParam("itemizedonly", itemizedOnly);
            return this;
        }

        /**
         * Returns the {@code ItemIconPathRequest} instance created by the builder.
         * @return a {@link ItemIconPathRequest}
         */
        @Override
        public ItemIconPathRequest build() {
            return request;
        }
    }
}
