package com.github.wannesvr;

import com.github.wannesvr.core.config.Dota2ApiConfig;
import org.junit.jupiter.api.BeforeEach;

/**
 * So you don't have to specify the key in every test :)
 */
public class BaseTest {
    @BeforeEach
    public void setUp() {
        Dota2ApiConfig.API_KEY = "real_api_key";
    }
}
