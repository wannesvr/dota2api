package com.github.wannesvr.core.model.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Data
public class MatchHistoryDetail {
    @JsonProperty("match_id")
    private long matchId;

    @JsonProperty("match_seq_num")
    private long matchSequenceNumber;

    @JsonProperty("start_time")
    private Date startTime;

    @JsonProperty("lobby_type")
    private LobbyType lobbyType;

    @JsonProperty("radiant_team_id")
    private int radiantTeamId;

    @JsonProperty("dire_team_id")
    private int direTeamId;

    @JsonProperty("players")
    private List<MatchHistoryPlayer> players;
}
