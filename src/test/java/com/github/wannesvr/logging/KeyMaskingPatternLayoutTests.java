package com.github.wannesvr.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KeyMaskingPatternLayoutTests {

    @Test
    public void givenLogMessage_WhenItMatchesKeyRegex_ShouldMaskKey() {
        var message = "https://api?key=abcd132$$!#@.&otherKey=1234!abc";
        var expectedMessage = "https://api?key=[apiKey]&otherKey=1234!abc";

        var logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        var loggingEvent = new LoggingEvent(null, logger, Level.INFO, message, null, null);

        var sut = new KeyMaskingPatternLayout();
        sut.setPatternProperty("key=(.*?)&amp;");

        var result = sut.doLayout(loggingEvent);

        assertThat(result, is(expectedMessage));
    }
}
