package com.github.wannesvr.core.request.match;

import com.github.wannesvr.core.model.league.live.LiveLeagueGameList;
import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;

/**
 * Request to IDOTA2Match_570/GetLiveLeagueGames/v1/
 * Returns a list of in-progress league matches, as well as details of that match as it unfolds.
 * @see LiveLeagueGameList
 */
public class LiveLeagueGamesRequest extends AbstractSteamApiRequest {
    public LiveLeagueGamesRequest() {
        super("/IDOTA2Match_570/GetLiveLeagueGames/v1");
    }

    @Override
    public Class getResponseClass() {
        return LiveLeagueGameList.class;
    }

    public static class Builder implements SteamApiRequestBuilder<LiveLeagueGamesRequest> {

        @Override
        public LiveLeagueGamesRequest build() {
            return new LiveLeagueGamesRequest();
        }
    }
}
