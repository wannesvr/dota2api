package api.dota2.request;

import api.core.request.AbstractDota2ApiRequest;

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
    public static class Builder {
        private final GetMatchDetailRequest request;

        private long matchId;

        /**
         * Retrieve details for this match id
         * @param matchId Match id
         */
        public Builder(long matchId){
            this.request = new GetMatchDetailRequest();
            this.matchId = matchId;
        }

        public GetMatchDetailRequest build(){
            this.request.urlParam("match_id", matchId);
            return request;
        }
    }
}
