package api.dota2.model.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class MatchHistory {
    @JsonProperty("status")
    private int status;

    @JsonProperty("status_detail")
    private String statusDetail;

    @JsonProperty("total_results")
    private int totalResults;

    @JsonProperty("results_remaining")
    private int resultsRemaining;

    @JsonProperty("num_results")
    private int numberOfResults;

    @JsonProperty("matches")
    private List<MatchHistoryDetail> matchHistory;
}
