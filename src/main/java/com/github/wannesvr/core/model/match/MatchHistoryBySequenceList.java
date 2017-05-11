package com.github.wannesvr.core.model.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MatchHistoryBySequenceList {
    @JsonProperty("matches")
    private List<MatchDetail> matches;
}
