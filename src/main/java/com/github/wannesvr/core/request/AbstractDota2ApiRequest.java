package com.github.wannesvr.core.request;

import com.github.wannesvr.core.config.Dota2Api;
import com.github.wannesvr.core.exception.Dota2ApiException;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Abstract class containing the request path and url parameters.
 * Extended by any request to the Dota2 related methods for the Steam Web API.
 */
public abstract class AbstractDota2ApiRequest implements Dota2ApiRequest {

    @Setter
    private static String BASE_URL = "http://api.steampowered.com";
    private final String path;
    private Request.Builder requestBuilder;
    private List<Parameter> urlParameters;

    public AbstractDota2ApiRequest(String path){
        this.requestBuilder = new Request.Builder();
        this.path = path;
        this.urlParameters = new ArrayList<>();
    }

    public void urlParam(String key, Object value){
        this.urlParameters.add(new Parameter(
                Objects.requireNonNull(key, "url param key is null"),
                Objects.requireNonNull(value, String.format("url param value for key %s is null", key)))
        );
    }

    /**
     * Adds every {@see Parameter} and url to the {@link Request}.
     * @return A {@link Request} object
     */
    @Override
    public Request getRequest() {
        try {
            this.urlParam("key", Objects.requireNonNull(Dota2Api.API_KEY, "API Key is null"));
            this.urlParam("format", Dota2Api.FORMAT);
            this.urlParam("language", Dota2Api.LANGUAGE);
        } catch (NullPointerException e){
            throw new Dota2ApiException(e.getMessage());
        }

        final StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(BASE_URL);
        urlBuilder.append(this.path);

        boolean first = true;

        for (Parameter urlParameter : urlParameters) {
            if (first) {
                urlBuilder.append("?");
                first = false;
            } else {
                urlBuilder.append("&");
            }

            urlBuilder.append(urlParameter);
        }

        requestBuilder.url(urlBuilder.toString());
        return requestBuilder.build();
    }

    public String getPath() {
        return path;
    }
}
