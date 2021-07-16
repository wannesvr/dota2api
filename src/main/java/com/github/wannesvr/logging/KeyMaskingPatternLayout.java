package com.github.wannesvr.logging;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.util.regex.Pattern;

public class KeyMaskingPatternLayout extends PatternLayout {

    private String patternProperty;
    private Pattern regex;

    public void setPatternProperty(String patternProperty) {
        if (patternProperty.isBlank()) {
            patternProperty = ".*";
        }

        this.patternProperty = patternProperty;
        this.regex = Pattern.compile(this.patternProperty);
    }

    public void setPattern(String pattern) {
        super.setPattern(pattern);
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        var message = super.doLayout(event);
        final var matcher = regex.matcher(message);

        if (matcher.find()) {
            message = message.replaceFirst(patternProperty, "key=[apikey]&");
        }

        return message;
    }
}
