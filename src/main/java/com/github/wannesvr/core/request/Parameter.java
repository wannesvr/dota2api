package com.github.wannesvr.core.request;

/**
 * Represents an url parameter.
 */
public class Parameter {
    private final String key;
    private final Object value;

    public Parameter(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the parameter in the key=value format.
     */
    @Override
    public String toString() {
        return String.format("%s=%s", key, value);
    }
}
