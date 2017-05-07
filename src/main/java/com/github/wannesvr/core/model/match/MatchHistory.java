package com.github.wannesvr.core.model.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
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
    private List<MatchHistoryDetail> matches;
}
