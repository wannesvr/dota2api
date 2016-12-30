package api.core;

import api.core.exception.Dota2ApiException;
import api.core.parser.Dota2ResponseParser;
import api.core.request.Dota2ApiRequest;
import lombok.extern.log4j.Log4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * The client send requests to the Steam Web API, and parses them using the {@link Dota2ResponseParser}.
 */
@Log4j
public class Dota2ApiClient {
    private final OkHttpClient client;

    public Dota2ApiClient() {
        client = new OkHttpClient();
    }

    /**
     * Sends the request and returns the response if successful.
     * @param request the request to send
     * @param responseClass the class to which the response should be parsed.
     * @return an object of type T.
     */
    public <T> T send(Dota2ApiRequest request, Class<T> responseClass) throws Dota2ApiException {
        try {
            Objects.requireNonNull(request, "Request cannot be null");
            Objects.requireNonNull(responseClass, "Response class cannot be null");
        } catch (NullPointerException e) {
            throw new Dota2ApiException(e.getMessage());
        }

        Request actualRequest = request.getRequest();
        Call call = this.client.newCall(actualRequest);

        try {
            log.info("Requesting url " + actualRequest.url());
            Response response = call.execute();

            if (response.isSuccessful()) {
                return Dota2ResponseParser.parse(response.body().string(), responseClass);
            } else {
                log.warn(String.format("Request failed: %d:%s", response.code(), response.message()));
                throw new Dota2ApiException(String.format("Couldn't retrieve %s: %s", responseClass.getSimpleName(), response.message()));
            }
        } catch (IOException e) {
            log.error(String.format("IOException for request %s: %s", actualRequest.url(), e.getMessage()));
            throw new Dota2ApiException(e.getMessage());
        }
    }
}
