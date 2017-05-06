package com.github.wannesvr.core.request.econ;

import org.junit.Test;

public class ItemIconPathRequestTest {
    @Test
    public void testGetItemIconPathRequest() {
        ItemIconPathRequest itemIconPathRequest = new ItemIconPathRequest
                .Builder()
                .itemizedOnly(false)
                .language("en")
                .build();


    }
}