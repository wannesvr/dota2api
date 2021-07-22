package com.github.wannesvr.core.exception;

/**
 * Exception wrapper
 */
public class Dota2ApiException extends RuntimeException {
    public Dota2ApiException(String message) {
        super(message);
    }

    public Dota2ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
