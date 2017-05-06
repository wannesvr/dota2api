package com.github.wannesvr.core;

import com.github.wannesvr.core.config.Dota2ApiConfig;
import com.github.wannesvr.core.exception.Dota2ApiException;
import com.github.wannesvr.core.model.match.MatchDetail;
import com.github.wannesvr.core.model.match.MatchHistory;
import com.github.wannesvr.core.parser.Dota2ResponseParser;
import com.github.wannesvr.core.request.AbstractDota2ApiRequest;
import com.github.wannesvr.core.request.match.MatchDetailRequest;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.*;

public class Dota2ApiClientTest {
    private Dota2ApiClient client;

    @Mock
    private AbstractDota2ApiRequest dota2RequestMock;

    @Mock
    private HttpClient httpClientMock;

    @Mock
    private HttpRequest httpRequestMock;

    @Mock
    private HttpResponse httpResponseMock;

    @Mock
    private StatusLine statusLineMock;

    @Mock
    private HttpEntity httpEntityMock;

    @Mock
    private Dota2ResponseParser responseParserMock;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        client = spy(new Dota2ApiClient("api_key"));
        client.setResponseParser(responseParserMock);

        Dota2ApiConfig.API_KEY = "TEST_API_KEY";
    }

    @Test
    public void sendWithNullRequestShouldThrowException() {
        try {
            client.send(null, Object.class);
            fail();
        } catch (Dota2ApiException e){
            assertThat(e.getMessage(), is("Request cannot be null"));
        }
    }

    @Test
    public void sendWithNullResponseClassShouldThrowException() {
        try {
            client.send(new MatchDetailRequest.Builder(-1).build(), null);
            fail();
        } catch (Dota2ApiException e){
            assertThat(e.getMessage(), is("Response class cannot be null"));
        }
    }

    @Test
    public void sendWithNoApiKeySetShouldThrowException() {
        //Manually reset api key
        Dota2ApiConfig.API_KEY = null;

        try {
            client.send(new MatchDetailRequest.Builder(-1).build(), MatchDetail.class);
            fail();
        } catch (Dota2ApiException e){
            assertThat(e.getMessage(), is("API Key is null"));
        }
    }

    @Test
    public void sendRequestWithCorrectParametersShouldSucceed() throws IOException {
        MatchHistory matchHistoryMock = mock(MatchHistory.class);

        when(dota2RequestMock.getRequest()).thenReturn(httpRequestMock);
        when(client.getHttpClient()).thenReturn(httpClientMock);
        when(httpClientMock.execute(any(HttpHost.class), any(HttpRequest.class))).thenReturn(httpResponseMock);
        when(httpResponseMock.getEntity()).thenReturn(httpEntityMock);
        when(httpResponseMock.getStatusLine()).thenReturn(statusLineMock);
        when(statusLineMock.getStatusCode()).thenReturn(200);
        when(responseParserMock.parse(any(String.class), any(Class.class))).thenReturn(matchHistoryMock);

        MatchHistory response = client.send(dota2RequestMock, MatchHistory.class);

        verify(dota2RequestMock).getRequest();
        verify(httpClientMock).execute(any(HttpHost.class), same(httpRequestMock));
        verify(httpResponseMock).getStatusLine();
        verify(statusLineMock).getStatusCode();
        //null so I don't have to mock EntityUtils
        verify(responseParserMock).parse(same(null), same(MatchHistory.class));

        assertThat(response, is(matchHistoryMock));
    }
}
