package com.github.wannesvr.core.request.match;

import com.github.wannesvr.core.model.league.LeagueList;
import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Request to /IDOTA2Match_570/GetLeagueListing/v1/.
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class LeagueListingRequest extends AbstractSteamApiRequest {
    private LeagueListingRequest() {
        super("/IDOTA2Match_570/GetLeagueListing/v1/");
    }

    @Override
    public Class getResponseClass() {
        return LeagueList.class;
    }

    /**
     * Static builder class to be used to create an instance of {@link MatchDetailRequest}.
     */
    public static class Builder implements SteamApiRequestBuilder<LeagueListingRequest> {
        @Override
        public LeagueListingRequest build() {
            return new LeagueListingRequest();
        }
    }
}
