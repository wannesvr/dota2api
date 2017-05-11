package com.github.wannesvr.core.parser;

import com.github.wannesvr.core.exception.Dota2ApiException;

public interface Dota2ResponseParser {
    <T> T parse(String json, Class clazz) throws Dota2ApiException;
    String parseError(String json) throws Dota2ApiException;
}
