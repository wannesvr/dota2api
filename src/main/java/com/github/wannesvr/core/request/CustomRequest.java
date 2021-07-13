package com.github.wannesvr.core.request;

/**
 * Class to create a custom request to the Steam Web API.
 */
public class CustomRequest extends AbstractSteamApiRequest {
    private Class responseClass;

    /**
     * Constructor.
     * @param path The request path.
     * @param responseClass The class to transform the response to (the result property is removed before parsing so you don't have to include this in your response class).
     */
    public CustomRequest(String path, Class responseClass) {
        super(path);
        this.responseClass = responseClass;
    }

    @Override
    public Class getResponseClass() {
        return responseClass;
    }

    public static class Builder implements SteamApiRequestBuilder<CustomRequest> {
        private final CustomRequest request;

        public Builder(String path, Class responseClass) {
            this.request = new CustomRequest(path.startsWith("/") ? path : "/" + path, responseClass);
        }

        /**
         * Add an url query parameter with an int value
         *
         * @param name  The name of the parameter
         * @param value The value of the parameter
         * @return Builder instance
         */
        public Builder withParameter(String name, int value) {
            this.request.urlParam(name, value);
            return this;
        }

        /**
         * Add an url query parameter with long value
         *
         * @param name  The name of the parameter
         * @param value The value of the parameter
         * @return Builder instance
         */
        public Builder withParameter(String name, long value) {
            this.request.urlParam(name, value);
            return this;
        }

        /**
         * Add an url query parameter with a boolean value
         *
         * @param name  The name of the parameter
         * @param value The value of the parameter
         * @return Builder instance
         */
        public Builder withParameter(String name, boolean value) {
            this.request.urlParam(name, value);
            return this;
        }

        /**
         * Add an url query parameter with a String value
         *
         * @param name  The name of the parameter
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
