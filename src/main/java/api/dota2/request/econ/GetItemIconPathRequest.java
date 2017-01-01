package api.dota2.request.econ;

import api.core.request.AbstractDota2ApiRequest;
import api.core.request.Dota2ApiRequestBuilder;

import java.util.Objects;

/**
 * Request to /IEconDOTA2_570/GetItemIconPath/v1
 */
public class GetItemIconPathRequest extends AbstractDota2ApiRequest {

    private GetItemIconPathRequest() {
        super("/IEconDOTA2_570/GetItemIconPath/v1");
    }

    /**
     * Static builder class to be used to create an instance of {@link GetItemIconPathRequest}.
     */
    public static class Builder implements Dota2ApiRequestBuilder<GetItemIconPathRequest> {
        private GetItemIconPathRequest request;

        public Builder() {
            this.request = new GetItemIconPathRequest();
        }

        /**
         * The language to provide hero names in.
         * @param language the language
         * @return Builder instance
         */
        public Builder language(String language){
            this.request.urlParam("language", Objects.requireNonNull(language));
            return this;
        }

        /**
         * If true, return a list of itemized heroes only.
         * @param itemizedOnly whether you want itemized heroes only
         * @return Builder instance
         */
        public Builder itemizedOnly(boolean itemizedOnly){
            this.request.urlParam("language", itemizedOnly);
            return this;
        }

        /**
         * Returns the {@code GetItemIconPathRequest} instance created by the builder.
         * @return a {@link GetItemIconPathRequest}
         */
        @Override
        public GetItemIconPathRequest build() {
            return request;
        }
    }
}
