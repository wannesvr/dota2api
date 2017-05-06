package com.github.wannesvr.core.request.match;

import com.github.wannesvr.base.BaseTest;
import com.github.wannesvr.testhelpers.UrlParamHelper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MatchDetailRequestTest extends BaseTest {
    @Test
    public void testBuildGetMatchDetailRequest() {
        MatchDetailRequest request = new MatchDetailRequest.Builder(1L).build();

        UrlParamHelper helper = new UrlParamHelper(request.getRequest());

        assertThat(request.getMatchId(), is(1L));
        assertThat(helper.getParameterValueByKey("match_id"), is("1"));
    }
}
