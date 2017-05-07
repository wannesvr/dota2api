package com.github.wannesvr.core.request;

/**
 * Class to create a custom request to the Steam Web API.
 */
public class CustomRequest extends AbstractSteamApiRequest {
    public CustomRequest(String path) {
        super(path);
    }

    public static class Builder implements SteamApiRequestBuilder<CustomRequest> {
        private CustomRequest request;

        public Builder(String path) {
            this.request = new CustomRequest(path.startsWith("/") ? path : "/" + path);
        }

        /**
         * Add an url query parameter with an int value
         * @param name The name of the parameter
         * @param value The value of the parameter
         * @return Builder instance
         */
        public Builder withParameter(String name, int value) {
            this.request.urlParam(name, value);
            return this;
        }

        /**
         * Add an url query parameter with long value
         * @param name The name of the parameter
         * @param value The value of the parameter
         * @return Builder instance
         */
        public Builder withParameter(String name, long value) {
            this.request.urlParam(name, value);
            return this;
        }

        /**
         * Add an url query parameter with a boolean value
         * @param name The name of the parameter
         * @param value The value of the parameter
         * @return Builder instance
         */
        public Builder withParameter(String name, boolean value) {
            this.request.urlParam(name, value);
            return this;
        }

        /**
         * Add an url query parameter with a String value
         * @param name The name of the parameter
         * @param value The value of the parameter
         * @return Builder instance
         */
        public Builder withParameter(String name, String value) {
            this.request.urlParam(name, value);
            return this;
        }

        @Override
        public CustomRequest build() {
            return request;
        }
    }
}
