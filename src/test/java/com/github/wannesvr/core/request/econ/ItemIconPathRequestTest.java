package com.github.wannesvr.core.request.econ;

import com.github.wannesvr.base.BaseTest;
import com.github.wannesvr.testhelpers.UrlParamHelper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemIconPathRequestTest extends BaseTest {
    @Test
    public void testGetItemIconPathRequest() {
        ItemIconPathRequest itemIconPathRequest = new ItemIconPathRequest
                .Builder()
                .itemizedOnly(false)
                .language("en")
                .build();

        UrlParamHelper helper = new UrlParamHelper(itemIconPathRequest.getRequest());

        assertThat(helper.getParameterValueByKey("itemizedonly"), is("0"));
        assertThat(helper.getParameterValueByKey("language"), is("en"));
    }
}