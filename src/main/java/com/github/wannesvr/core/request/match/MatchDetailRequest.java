package com.github.wannesvr.core.request.match;

import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;
import lombok.Getter;

/**
 * Request to /IDOTA2Match_570/GetMatchDetails/v1.
 * Returns information about a particular match.
 */
public class MatchDetailRequest extends AbstractSteamApiRequest {
    @Getter
    private long matchId;

    private MatchDetailRequest(long matchId) {
        super("/IDOTA2Match_570/GetMatchDetails/v1");
        this.matchId = matchId;
    }

    /**
     * Static builder class to be used to create an instance of {@link MatchDetailRequest}.
     */
    public static class Builder implements SteamApiRequestBuilder<MatchDetailRequest> {
        private final MatchDetailRequest request;

        /**
         * Retrieve details for this match id
         * @param matchId Match id
         */
        public Builder(long matchId){
            this.request = new MatchDetailRequest(matchId);
            this.request.urlParam("match_id", matchId);
        }

        /**
         * Returns the {@code MatchDetailRequest} instance created by the builder.
         * @return a {@link MatchDetailRequest}
         */
        @Override
        public MatchDetailRequest build(){
            return request;
        }
    }
}
