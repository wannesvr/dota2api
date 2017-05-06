# Dota2Api
A wrapper for all Dota related methods of the Steam Web API.
Note that this is a work in progress and not all API methods are available yet.

### Usage
Using the wrapper is very easy as seen in the example below.
Create a client, create a request using the Builder and send it!
```java

import com.github.wannesvr.com.github.wannesvr.core.config.*;
import com.github.wannesvr.com.github.wannesvr.core.*;
import com.github.wannesvr.com.github.wannesvr.core.request.*;
import com.github.wannesvr.com.github.wannesvr.core.model.match.*;

class Example {
    public static void main(String[] args){
        Dota2ApiClient client = new Dota2ApiClient("API_KEY");
        
        MatchHistoryRequest request = new MatchHistoryRequest.Builder()
           .gameMode(GameMode.ALL_PICK)
           .matchesRequested(5)
           .build();
        
        MatchHistory matchHistory = client.send(request, MatchHistory.class);
    }
}
```
