# Dota2Api
An (unfinished) wrapper for Dota related methods of the Steam Web API.
Note that this is a work in progress, currently you can only request match history and match detail.

###Usage
Using the wrapper is very easy, just set your API key once.
Create a client, create a request using the Builder and send it.
```java

import api.core.config.*;
import api.core.*;
import api.dota2.request.*;
import api.dota2.model.match.*;

class Example {
    public static void main(String[] args){
        Dota2Api.API_KEY = "Your api key";
        
        //Create a client
        Dota2ApiClient client = new Dota2ApiClient();
        
        //Create a request using the Builder
        GetMatchHistoryRequest request = new GetMatchHistoryRequest.Builder()
            .accountId(1)
            .gameMode(GameMode.CAPTAINS_MODE)
            .matchesRequested(5)
            .build();
        
        MatchHistoryResult response = client.send(request, MatchHistoryResult.class);
        List<MatchHistoryDetail> history = response.getMatchHistory();
        
        for (MatchHistoryDetail match : history) {
            System.out.println("Match id: " + match.getMatchId());
        }
    }
}
```
