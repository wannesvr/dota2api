package api.dota2.request.econ;

import api.core.request.AbstractDota2ApiRequest;
import api.core.request.Dota2ApiRequestBuilder;

/**
 * Request to /IEconDOTA2_570/GetHeroes/v1
 */
public class GetHeroesRequest extends AbstractDota2ApiRequest {
    private GetHeroesRequest() {
        super("/IEconDOTA2_570/GetHeroes/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link GetHeroesRequest}.
     */
    public static class Builder implements Dota2ApiRequestBuilder<GetHeroesRequest> {

        /**
         * Returns the {@code GetHeroesRequest} instance created by the builder.
         * @return a {@link GetHeroesRequest}
         */
        @Override
        public GetHeroesRequest build() {
            return new GetHeroesRequest();
        }
    }
}
