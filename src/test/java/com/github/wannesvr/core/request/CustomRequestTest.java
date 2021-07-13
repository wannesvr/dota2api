package com.github.wannesvr.core.request;

import com.github.wannesvr.BaseTest;
import com.github.wannesvr.testhelpers.UrlParamHelper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;

public class CustomRequestTest extends BaseTest {

    @Test
    public void testCustomRequest() {
        CustomRequest customRequest = new CustomRequest.Builder("/MyCustomRequestPath", Class.class)
                .withParameter("trueBoolean", true)
                .withParameter("falseBoolean", false)
                .withParameter("string", "stringValue")
                .withParameter("integer", 1)
                .withParameter("long", 500L)
                .build();

        UrlParamHelper helper = new UrlParamHelper(customRequest.getRequest());

        String url = customRequest.getRequest().getRequestLine().getUri().split("\\?")[0];

        assertThat(url, is("https://api.steampowered.com/MyCustomRequestPath"));
        assertThat(customRequest.getResponseClass(), isA(Class.class));
        assertThat(helper.getParameterValueByKey("trueBoolean"), is("1"));
        assertThat(helper.getParameterValueByKey("falseBoolean"), is("0"));
        assertThat(helper.getParameterValueByKey("string"), is("stringValue"));
        assertThat(helper.getParameterValueByKey("integer"), is("1"));
        assertThat(helper.getParameterValueByKey("long"), is("500"));
    }

    @Test
    public void testCustomRequestWithPathWithoutLeadingSlash() {
        CustomRequest customRequest = new CustomRequest.Builder("MyCustomRequestPath", Class.class).build();

        String url = customRequest.getRequest().getRequestLine().getUri().split("\\?")[0];

        assertThat(url, is("https://api.steampowered.com/MyCustomRequestPath"));
    }
}