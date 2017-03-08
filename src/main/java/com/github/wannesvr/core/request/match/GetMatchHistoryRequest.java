package com.github.wannesvr.core.request.match;

import com.github.wannesvr.core.request.AbstractDota2ApiRequest;
import com.github.wannesvr.core.request.Dota2ApiRequestBuilder;
import com.github.wannesvr.core.model.match.GameMode;
import com.github.wannesvr.core.model.match.SkillBracket;

/**
 * Request to /IDOTA2Match_570/GetMatchHistory/v1
 */
public class GetMatchHistoryRequest extends AbstractDota2ApiRequest {
    private GetMatchHistoryRequest() {
        super("/IDOTA2Match_570/GetMatchHistory/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link GetMatchHistoryRequest}.
     */
    public static class Builder implements Dota2ApiRequestBuilder<GetMatchHistoryRequest> {
        private GetMatchHistoryRequest request;

        public Builder(){
            this.request = new GetMatchHistoryRequest();
        }

        public Builder heroId(int heroId){
            this.request.urlParam("hero_id", heroId);
            return this;
        }

        /**
         * Retrieve games for this account id
         * @param accountId Steam account Id
         * @return Builder instance
         */
        public Builder accountId(long accountId){
            this.request.urlParam("account_id", accountId);
            return this;
        }

        /**
         * Retrieve games with this gamemode only
         * @param gameMode The gamemode to search for
         * @return Builder instance
         *
         * @see GameMode
         */
        public Builder gameMode(GameMode gameMode){
            this.request.urlParam("game_mode", gameMode);
            return this;
        }

        /**
         * Skill bracket for the matches (Ignored by Steam Web API if an account ID is specified).
         * @param skillBracket The skillbracket
         * @return Builder instance
         *
         * @see SkillBracket
         */
        public Builder skill(SkillBracket skillBracket){
            this.request.urlParam("skill", skillBracket);
            return this;
        }

        /**
         * Specify the minimum amount of player in a match for the match to be returned.
         * @param amount The amount of players
         * @return Builder instance
         */
        public Builder minPlayers(int amount){
            this.request.urlParam("min_players", amount);
            return this;
        }

        /**
         * Search for matches from this league.
         * @param leagueId The league id
         * @return Builder instance
         */
        public Builder leagueId(long leagueId){
            this.request.urlParam("league_id", leagueId);
            return this;
        }

        /**
         * Search for matches equal to or older than the match with this id.
         * @param matchId The match id
         * @return Builder instance
         */
        public Builder startAtMatchId(long matchId){
            this.request.urlParam("start_at_match_id", matchId);
            return this;
        }

        /**
         * Specify the amount of matches to include in results (default: 25).
         * @param amount amount of matches in result
         * @return Builder instance
         */
        public Builder matchesRequested(int amount){
            this.request.urlParam("matches_requested", amount);
            return this;
        }

        /**
         * Whether to limit results to tournament matches. (0 = false, 1 = true)
         * @param tournamentGamesOnly true if you want tournament games only
         * @return Builder instance
         */
        public Builder tournamentGamesOnly(boolean tournamentGamesOnly){
            this.request.urlParam("tournament_games_only", tournamentGamesOnly ? "1" : "0");
            return this;
        }

        /**
         * Returns the {@code GetMatchHistoryRequest} instance created by the builder.
         * @return a {@link GetMatchHistoryRequest}
         */
        @Override
        public GetMatchHistoryRequest build(){
            return request;
        }
    }
}
