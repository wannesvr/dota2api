package api.dota2.request.match;

import api.core.request.AbstractDota2ApiRequest;
import api.core.request.Dota2ApiRequestBuilder;

/**
 * Request to /IDOTA2Match_570/GetMatchDetails/v1.
 */
public class GetMatchDetailRequest extends AbstractDota2ApiRequest {
    private GetMatchDetailRequest() {
        super("/IDOTA2Match_570/GetMatchDetails/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link GetMatchDetailRequest}.
     */
    public static class Builder implements Dota2ApiRequestBuilder<GetMatchDetailRequest> {
        private final GetMatchDetailRequest request;

        /**
         * Retrieve details for this match id
         * @param matchId Match id
         */
        public Builder(long matchId){
            this.request = new GetMatchDetailRequest();
            this.request.urlParam("match_id", matchId);
        }

        /**
         * Returns the {@code GetMatchDetailRequest} instance created by the builder.
         * @return a {@link GetMatchDetailRequest}
         */
        @Override
        public GetMatchDetailRequest build(){
            return request;
        }
    }
}
