package com.github.wannesvr.testhelpers;

import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class UrlParamHelper {
    private List<NameValuePair> parameters;

    public UrlParamHelper(HttpRequest request) {
        parameters = new ArrayList<>();

        String parameterString = request.getRequestLine().getUri().split("\\?")[1];
        Arrays.stream(parameterString.split("&")).forEach(param -> {
            String[] keyValueArray = param.split("=");
            parameters.add(new BasicNameValuePair(keyValueArray[0], keyValueArray[1]));
        });
    }

    public String getParameterValueByKey(String name) {
        try {
            return parameters.stream()
                    .filter(kv -> kv.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .get()
                    .getValue();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No parameter found with name " + name);
        }
    }
}
