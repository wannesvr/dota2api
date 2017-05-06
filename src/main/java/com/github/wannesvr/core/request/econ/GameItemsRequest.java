package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.core.request.AbstractDota2ApiRequest;
import com.github.wannesvr.core.request.Dota2ApiRequestBuilder;

/**
 * Request to /IEconDOTA2_570/GetGameItems/v1
 */
public class GameItemsRequest extends AbstractDota2ApiRequest {

    private GameItemsRequest() {
        super("/IEconDOTA2_570/GetGameItems/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link GameItemsRequest}.
     */
    public static class Builder implements Dota2ApiRequestBuilder<GameItemsRequest> {
        public Builder() {}

        /**
         * Returns the {@code GameItemsRequest} instance created by the builder.
         * @return a {@link GameItemsRequest}
         */
        @Override
        public GameItemsRequest build() {
            return new GameItemsRequest();
        }
    }
}
