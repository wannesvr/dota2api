package com.github.wannesvr.core.request.match;

import com.github.wannesvr.core.model.match.GameMode;
import com.github.wannesvr.core.model.match.MatchHistory;
import com.github.wannesvr.core.model.match.SkillBracket;
import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import com.github.wannesvr.core.request.SteamApiRequestBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Request to /IDOTA2Match_570/GetMatchHistory/v1
 * Returns a list of matches, filterable by various parameters.
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class MatchHistoryRequest extends AbstractSteamApiRequest {
    private int heroId;
    private long accountId;
    private GameMode gameMode;
    private SkillBracket skillBracket;
    private int minPlayers;
    private long leagueId;
    private long startAtMatchId;
    private int matchesRequested;
    private boolean tournamentGamesOnly;

    private MatchHistoryRequest() {
        super("/IDOTA2Match_570/GetMatchHistory/v1");
    }

    @Override
    public Class getResponseClass() {
        return MatchHistory.class;
    }

    /**
     * Static builder class to be used to create an instance of {@link MatchHistoryRequest}.
     */
    public static class Builder implements SteamApiRequestBuilder<MatchHistoryRequest> {
        private MatchHistoryRequest request;

        public Builder() {
            this.request = new MatchHistoryRequest();
        }

        public Builder heroId(int heroId) {
            this.request.urlParam("hero_id", heroId);
            this.request.setHeroId(heroId);
            return this;
        }

        /**
         * Retrieve games for this account id
         *
         * @param accountId Steam account Id
         * @return Builder instance
         */
        public Builder accountId(long accountId) {
            this.request.urlParam("account_id", accountId);
            this.request.setAccountId(accountId);
            return this;
        }

        /**
         * Retrieve games with this gamemode only
         *
         * @param gameMode The gamemode to search for
         * @return Builder instance
         * @see GameMode
         */
        public Builder gameMode(GameMode gameMode) {
            this.request.urlParam("game_mode", gameMode.getUrlParamValue());
            this.request.setGameMode(gameMode);
            return this;
        }

        /**
         * Skill bracket for the matches (Ignored by Steam Web API if an account ID is specified).
         *
         * @param skillBracket The skillbracket
         * @return Builder instance
         * @see SkillBracket
         */
        public Builder skill(SkillBracket skillBracket) {
            this.request.urlParam("skill", skillBracket.getUrlParamValue());
            this.request.setSkillBracket(skillBracket);
            return this;
        }

        /**
         * Specify the minimum amount of player in a match for the match to be returned.
         *
         * @param amount The amount of players
         * @return Builder instance
         */
        public Builder minPlayers(int amount) {
            this.request.urlParam("min_players", amount);
            this.request.setMinPlayers(amount);
            return this;
        }

        /**
         * Search for matches from this league.
         *
         * @param leagueId The league id
         * @return Builder instance
         */
        public Builder leagueId(long leagueId) {
            this.request.urlParam("league_id", leagueId);
            this.request.setLeagueId(leagueId);
            return this;
        }

        /**
         * Search for matches equal to or older than the match with this id.
         *
         * @param matchId The match id
         * @return Builder instance
         */
        public Builder startAtMatchId(long matchId) {
            this.request.urlParam("start_at_match_id", matchId);
            this.request.setStartAtMatchId(matchId);
            return this;
        }

        /**
         * Specify the amount of matches to include in results (default: 25).
         *
         * @param amount amount of matches in result
         * @return Builder instance
         */
        public Builder matchesRequested(int amount) {
            this.request.urlParam("matches_requested", amount);
            this.request.setMatchesRequested(amount);
            return this;
        }

        /**
         * Whether to limit results to tournament matches. (0 = false, 1 = true)
         *
         * @param tournamentGamesOnly true if you want tournament games only
         * @return Builder instance
         */
        public Builder tournamentGamesOnly(boolean tournamentGamesOnly) {
            this.request.urlParam("tournament_games_only", tournamentGamesOnly);
            this.request.setTournamentGamesOnly(tournamentGamesOnly);
            return this;
        }

        /**
         * Returns the {@code MatchHistoryRequest} instance created by the builder.
         *
         * @return a {@link MatchHistoryRequest}
         */
        @Override
        public MatchHistoryRequest build() {
            return request;
        }
    }
}
