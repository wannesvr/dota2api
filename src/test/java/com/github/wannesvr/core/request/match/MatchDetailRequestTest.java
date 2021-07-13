package com.github.wannesvr.core.request.match;

import com.github.wannesvr.BaseTest;
import com.github.wannesvr.testhelpers.UrlParamHelper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatchDetailRequestTest extends BaseTest {
    @Test
    public void testBuildGetMatchDetailRequest() {
        MatchDetailRequest request = new MatchDetailRequest.Builder(1L).build();

        UrlParamHelper helper = new UrlParamHelper(request.getRequest());

        assertThat(request.getMatchId(), is(1L));
        assertThat(helper.getParameterValueByKey("match_id"), is("1"));
    }
}
