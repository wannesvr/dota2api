package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.core.request.AbstractDota2ApiRequest;
import com.github.wannesvr.core.request.Dota2ApiRequestBuilder;

/**
 * Request to /IEconDOTA2_570/GetHeroes/v1
 */
public class HeroesRequest extends AbstractDota2ApiRequest {
    private HeroesRequest() {
        super("/IEconDOTA2_570/GetHeroes/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link HeroesRequest}.
     */
    public static class Builder implements Dota2ApiRequestBuilder<HeroesRequest> {

        /**
         * Returns the {@code HeroesRequest} instance created by the builder.
         * @return a {@link HeroesRequest}
         */
        @Override
        public HeroesRequest build() {
            return new HeroesRequest();
        }
    }
}
