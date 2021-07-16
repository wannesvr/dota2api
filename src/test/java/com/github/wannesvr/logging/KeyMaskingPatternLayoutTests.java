package com.github.wannesvr.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.pattern.FormattingConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KeyMaskingPatternLayoutTests {

    private final LoggerContext context = new LoggerContext();
    private Logger logger;

    @BeforeEach
    public void setup() {
        logger = context.getLogger(Logger.ROOT_LOGGER_NAME);
    }

    @AfterEach
    public void teardown() {
        if (logger != null) {
            logger.detachAndStopAllAppenders();
        }
    }

    @Test
    public void givenLogMessage_WhenItMatchesKeyRegex_ShouldMaskKey() {
        var message = "https://api?key=abcd132$$!#@.&otherKey=1234!abc";
        var expectedMessage = "https://api?key=[apikey]&otherKey=1234!abc";

        var loggingEvent = new LoggingEvent(FormattingConverter.class.getName(), logger, Level.INFO, message, null, null);

        var sut = new KeyMaskingPatternLayout();
        sut.setContext(context);
        sut.setPattern("%msg");
        sut.setPatternProperty("key=(.*)&");
        sut.start();

        var result = sut.doLayout(loggingEvent);

        assertThat(result, is(expectedMessage));

        logger.detachAndStopAllAppenders();
    }
}
