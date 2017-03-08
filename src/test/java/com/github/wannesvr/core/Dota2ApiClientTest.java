package com.github.wannesvr.core;

import com.github.wannesvr.core.config.Dota2Api;
import com.github.wannesvr.core.exception.Dota2ApiException;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.model.match.MatchHistory;
import com.github.wannesvr.core.model.match.MatchHistoryDetail;
import com.github.wannesvr.core.parser.Dota2ResponseParser;
import com.github.wannesvr.core.request.AbstractDota2ApiRequest;
import com.github.wannesvr.core.request.Dota2ApiRequest;
import com.github.wannesvr.core.request.match.GetMatchDetailRequest;
import com.github.wannesvr.core.request.match.GetMatchHistoryRequest;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Dota2ApiClientTest {
    private MockWebServer mockWebServer;
    private Dota2ApiClient client;
    private AbstractDota2ApiRequest request;

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();

        client = new Dota2ApiClient();
        client.setResponseParser(mock(Dota2ResponseParser.class));
        request = mock(AbstractDota2ApiRequest.class);

        Dota2Api.API_KEY = "TEST_API_KEY";
    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    @Test
    public void sendWithNullRequestShouldThrowException() throws Exception {
        try {
            client.send(null, Object.class);
            Assert.fail();
        } catch (Dota2ApiException e){
            assertThat(e.getMessage(), is("Request cannot be null"));
        }
    }

    @Test
    public void sendWithNullResponseClassShouldThrowException() throws Exception {
        try {
            client.send(new GetMatchDetailRequest.Builder(-1).build(), null);
            Assert.fail();
        } catch (Dota2ApiException e){
            assertThat(e.getMessage(), is("Response class cannot be null"));
        }
    }

    @Test
    public void sendWithNoApiKeySetShouldThrowException() throws Exception {
        //Manually reset api key
        Dota2Api.API_KEY = null;

        try {
            client.send(new GetMatchDetailRequest.Builder(-1).build(), MatchDetail.class);
        } catch (Dota2ApiException e){
            assertThat(e.getMessage(), is("API Key is null"));

        }
    }

    @Test
    public void sendRequestWithCorrectParametersShouldSucceed() throws Exception {
        Dota2ResponseParser mockedParser = mock(Dota2ResponseParser.class);
        MatchHistory mockedMatchHistoryResponse = mock(MatchHistory.class);

        when(mockedParser.parse(any(String.class), any(Class.class))).thenReturn(mockedMatchHistoryResponse);

        when(mockedMatchHistoryResponse.getMatches()).thenReturn(new ArrayList<>());
        //Act
        MatchHistory matchHistory = client.send(request, MatchHistory.class);

        //Assert
        assertThat(matchHistory.getMatches().size(), is(0));
    }
}
