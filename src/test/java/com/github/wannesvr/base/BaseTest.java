package com.github.wannesvr.base;

import com.github.wannesvr.core.config.Dota2ApiConfig;
import org.junit.Before;

/**
 * So you don't have to specify the key in every test :)
 */
public class BaseTest {
    @Before
    public void setUp() {
        Dota2ApiConfig.API_KEY = "real_api_key";
    }
}
