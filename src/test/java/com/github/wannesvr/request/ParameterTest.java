package com.github.wannesvr.request;

import com.github.wannesvr.core.request.Parameter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParameterTest {

    @Test
    public void testParameterToString() throws Exception {
        Parameter parameter = new Parameter("key", "value");

        String paramToString = parameter.toString();

        assertThat(paramToString, is("key=value"));
    }
}
