package com.github.wannesvr.core.request.match;

import com.github.wannesvr.core.model.league.LeagueGameList;
import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;

/**
 * Request to IDOTA2Match_570/GetLiveLeagueGames/v1/
 * Returns a list of in-progress league matches, as well as details of that match as it unfolds.
 * @see LeagueGameList
 */
public class LiveLeagueGamesRequest extends AbstractSteamApiRequest {
    public LiveLeagueGamesRequest() {
        super("IDOTA2Match_570/GetLiveLeagueGames/v1/");
    }

    @Override
    public Class getResponseClass() {
        return LeagueGameList.class;
    }

    public static class Builder implements SteamApiRequestBuilder<LiveLeagueGamesRequest> {

        @Override
        public LiveLeagueGamesRequest build() {
            return new LiveLeagueGamesRequest();
        }
    }
}
