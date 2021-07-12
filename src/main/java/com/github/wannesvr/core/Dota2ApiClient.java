package com.github.wannesvr.core;

import com.github.wannesvr.core.config.Dota2ApiConfig;
import com.github.wannesvr.core.exception.Dota2ApiException;
import com.github.wannesvr.core.parser.Dota2JsonResponseParser;
import com.github.wannesvr.core.parser.Dota2ResponseParser;
import com.github.wannesvr.core.request.AbstractSteamApiRequest;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * The client send requests to the Steam Web API, and parses them using the {@link Dota2JsonResponseParser}.
 */
@Slf4j
public class Dota2ApiClient {

    @Setter
    private Dota2ResponseParser responseParser = new Dota2JsonResponseParser();

    public Dota2ApiClient(String apiKey) {
        Dota2ApiConfig.API_KEY = apiKey;
    }

    /**
     * Sends the request and returns the response if successful, if not it throws a {@link Dota2ApiException}.
     *
     * @param request       the request to send
     * @return an object of type T.
     */
    public <T> T send(AbstractSteamApiRequest request) throws Dota2ApiException {
        try {
            Objects.requireNonNull(request, "Request cannot be null");
        } catch (NullPointerException e) {
            throw new Dota2ApiException(e.getMessage());
        }

        try {
            HttpClient client = getHttpClient();
            HttpResponse response = client.execute(new HttpHost("api.steampowered.com"), request.getRequest());
            int statusCode = response.getStatusLine().getStatusCode();

            log.info("Request to " + request.getRequest().getRequestLine().getUri());

            if (statusCode == 200) {
                return responseParser.parse(EntityUtils.toString(response.getEntity()), request.getResponseClass());
            } else {
                String error = responseParser.parseError(EntityUtils.toString(response.getEntity()));
                throw new Dota2ApiException(String.format("Request failed with status code [%s]: %s", response.getStatusLine().getStatusCode(), error));
            }
        } catch (IOException e) {
            log.warn("Couldn't connect to the Steam API: " + e.getMessage());
            throw new Dota2ApiException(e.getMessage());
        }
    }

    HttpClient getHttpClient() {
        return HttpClients.createDefault();
    }
}
