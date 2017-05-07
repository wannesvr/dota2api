package com.github.wannesvr.core.request.match;

import com.github.wannesvr.BaseTest;
import com.github.wannesvr.core.model.match.GameMode;
import com.github.wannesvr.core.model.match.SkillBracket;
import com.github.wannesvr.testhelpers.UrlParamHelper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MatchHistoryRequestTest extends BaseTest {
    @Test
    public void testGetMatchHistoryRequestTest() {
        MatchHistoryRequest matchHistoryRequest = new MatchHistoryRequest
                .Builder()
                .accountId(1L)
                .heroId(2)
                .matchesRequested(3)
                .gameMode(GameMode.CAPTAINS_MODE)
                .leagueId(4)
                .minPlayers(5)
                .skill(SkillBracket.ANY)
                .startAtMatchId(6L)
                .tournamentGamesOnly(true)
                .build();

        UrlParamHelper helper = new UrlParamHelper(matchHistoryRequest.getRequest());

        assertThat(helper.getParameterValueByKey("account_id"), is("1"));
        assertThat(helper.getParameterValueByKey("hero_id"), is("2"));
        assertThat(helper.getParameterValueByKey("matches_requested"), is("3"));
        assertThat(helper.getParameterValueByKey("game_mode"), is("2"));
        assertThat(helper.getParameterValueByKey("league_id"), is("4"));
        assertThat(helper.getParameterValueByKey("min_players"), is("5"));
        assertThat(helper.getParameterValueByKey("skill"), is("0"));
        assertThat(helper.getParameterValueByKey("start_at_match_id"), is("6"));
        assertThat(helper.getParameterValueByKey("tournament_games_only"), is("1"));
    }
}