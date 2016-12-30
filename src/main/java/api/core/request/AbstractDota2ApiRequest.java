package api.core.request;

import api.core.config.Dota2Api;
import api.core.exception.Dota2ApiException;
import okhttp3.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractDota2ApiRequest implements Dota2ApiRequest {
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

    @Override
    public Request getRequest() {
        try {
            this.urlParam("key", Objects.requireNonNull(Dota2Api.API_KEY, "API Key is null"));
            this.urlParam("format", Dota2Api.DEFAULT_FORMAT);
        } catch (NullPointerException e){
            throw new Dota2ApiException(e.getMessage());
        }

        final StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(Dota2Api.BASE_URL);
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
