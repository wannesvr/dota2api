package api.core.client;

import api.core.Dota2ApiClient;
import api.core.config.Dota2Api;
import api.core.exception.Dota2ApiException;
import api.dota2.model.match.MatchDetail;
import api.dota2.model.match.MatchHistory;
import api.dota2.request.GetMatchDetailRequest;
import api.dota2.request.GetMatchHistoryRequest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Dota2ApiClientTest {
    private Dota2ApiClient client;

    private void startServer(MockWebServer server, String path){
        //Set the api base url to the mocked web server's url
        String serverUrl = server.url(path).toString();
        serverUrl = serverUrl.replace(path, "");
        Dota2Api.BASE_URL = serverUrl.substring(0, serverUrl.length()); // strip last /
    }

    @Before
    public void setUp() throws Exception {
        client = new Dota2ApiClient();
        Dota2Api.API_KEY = "TEST_API_KEY";
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
        //Arrange
        MockWebServer server = new MockWebServer();

        //Response containing 1 match
        MockResponse matchHistoryResponse = new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody("{ \"result\": { \"status\": 1, \"num_results\": 1, \"total_results\": 1, \"results_remaining\": 0, \"matches\": [ { \"match_id\": 0, \"match_seq_num\": 0, \"start_time\": 0, \"lobby_type\": 0, \"radiant_team_id\": 0, \"dire_team_id\": 0, \"players\": [ { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 } ] } ] } }");

        GetMatchHistoryRequest request = new GetMatchHistoryRequest.Builder().build();

        server.enqueue(matchHistoryResponse);
        startServer(server, request.getPath());

        //Act
        MatchHistory matchHistory = client.send(request, MatchHistory.class);

        //Assert
        assertThat(matchHistory.getMatchHistory().size(), is(1));

        //Cleanup
        server.shutdown();
    }

    @Test(expected = Dota2ApiException.class)
    public void sendRequestWithWrongResultClassShouldThrowException() throws Exception {
        //Arrange
        MockWebServer server = new MockWebServer();

        //Response containing 1 match
        MockResponse matchHistoryResponse = new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody("{ \"result\": { \"status\": 1, \"num_results\": 1, \"total_results\": 1, \"results_remaining\": 0, \"matches\": [ { \"match_id\": 0, \"match_seq_num\": 0, \"start_time\": 0, \"lobby_type\": 0, \"radiant_team_id\": 0, \"dire_team_id\": 0, \"players\": [ { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 }, { \"account_id\": 0, \"player_slot\": 0, \"hero_id\": 0 } ] } ] } }");

        GetMatchHistoryRequest request = new GetMatchHistoryRequest.Builder().build();

        server.enqueue(matchHistoryResponse);
        startServer(server, request.getPath());

        //Act
        client.send(request, MatchDetail.class);

        //Cleanup
        server.shutdown();
    }
}
