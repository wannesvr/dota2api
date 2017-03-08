package com.github.wannesvr.core.request;

/**
 * Interface to be implemented by a {@link Dota2ApiRequest}'s builder.
 * @param <T> the request type that the builder will return.
 */
public interface Dota2ApiRequestBuilder<T> {
    T build();
}
