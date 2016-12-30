package api.core.exception;

/**
 * Exception wrapper
 */
public class Dota2ApiException extends RuntimeException {
    public Dota2ApiException(String message) {
        super(message);
    }
}
