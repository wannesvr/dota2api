package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.core.model.item.GameItemList;
import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;

/**
 * Request to /IEconDOTA2_570/GetGameItems/v1
 * Returns a list of Dota 2 In-game items
 *
 * @see com.github.wannesvr.core.model.item.GameItemList
 */
public class GameItemsRequest extends AbstractSteamApiRequest {

    private GameItemsRequest() {
        super("/IEconDOTA2_570/GetGameItems/v1");
    }

    @Override
    public Class getResponseClass() {
        return GameItemList.class;
    }

    /**
     * Static builder class to be used to create an instance of {@link GameItemsRequest}.
     */
    public static class Builder implements SteamApiRequestBuilder<GameItemsRequest> {
        public Builder() {
        }

        /**
         * Returns the {@code GameItemsRequest} instance created by the builder.
         *
         * @return a {@link GameItemsRequest}
         */
        @Override
        public GameItemsRequest build() {
            return new GameItemsRequest();
        }
    }
}
