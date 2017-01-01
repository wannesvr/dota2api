package api.dota2.request.econ;

import api.core.request.AbstractDota2ApiRequest;
import api.core.request.Dota2ApiRequestBuilder;

/**
 * Request to /IEconDOTA2_570/GetGameItems/v1
 */
public class GetGameItemsRequest extends AbstractDota2ApiRequest {

    private GetGameItemsRequest() {
        super("/IEconDOTA2_570/GetGameItems/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link GetGameItemsRequest}.
     */
    public static class Builder implements Dota2ApiRequestBuilder<GetGameItemsRequest> {
        public Builder() {
        }

        /**
         * Returns the {@code GetGameItemsRequest} instance created by the builder.
         * @return a {@link GetGameItemsRequest}
         */
        @Override
        public GetGameItemsRequest build() {
            return new GetGameItemsRequest();
        }
    }
}
