package com.github.wannesvr.core.request;

/**
 * Interface to be implemented by an {@link AbstractSteamApiRequest}'s builder.
 *
 * @param <T> the request type that the builder will return.
 */
public interface SteamApiRequestBuilder<T> {
    T build();
}
