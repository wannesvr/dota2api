package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.BaseTest;
import com.github.wannesvr.testhelpers.UrlParamHelper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HeroesRequestTest extends BaseTest {
    @Test
    public void testHeroesRequestTest() {
        HeroesRequest heroesRequest = new HeroesRequest
                .Builder()
                .language("en")
                .itemizedOnly(true)
                .build();

        UrlParamHelper helper = new UrlParamHelper(heroesRequest.getRequest());

        assertThat(helper.getParameterValueByKey("language"), is("en"));
        assertThat(helper.getParameterValueByKey("itemizedonly"), is("1"));
    }
}