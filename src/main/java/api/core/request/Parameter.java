package api.core.request;


public class Parameter {
    private final String key;
    private final Object value;

    public Parameter(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s=%s", key, value);
    }
}
