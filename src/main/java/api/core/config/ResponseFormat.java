package api.core.config;

public enum ResponseFormat {
    JSON("json"), XML("xml"), VDF("vdf");

    private String value;

    ResponseFormat(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
