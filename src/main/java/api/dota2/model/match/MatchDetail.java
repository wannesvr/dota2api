package api.dota2.model.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
public class MatchDetail {
    @JsonProperty("match_id")
    private long matchId;

    @JsonProperty("players")
    private List<MatchDetailPlayer> players;

    @JsonProperty("season")
    private String season;

    @JsonProperty("radiant_win")
    private boolean radiantWin;

    @JsonProperty("duration")
    private Time duration;

    @JsonProperty("start_time")
    private Date startTime;

    @JsonProperty("match_seq_num")
    private long matchSequenceNumber;

    @JsonProperty("tower_status_radiant")
    private int towerStatusRadiant;

    @JsonProperty("tower_status_dire")
    private int towerStatusDire;

    @JsonProperty("barracks_status_radiant")
    private int barracksStatusRadiant;

    @JsonProperty("barracks_status_dire")
    private int barracksStatusDire;

    @JsonProperty("cluster")
    private String cluster;

    @JsonProperty("first_blood_time")
    private int firstBloodTime;

    @JsonProperty("lobby_type")
    private LobbyType lobbyType;

    @JsonProperty("human_players")
    private int humanPlayers;

    @JsonProperty("leagueid")
    private long leagueId;

    @JsonProperty("positive_votes")
    private int positiveVotes;

    @JsonProperty("negative_votes")
    private int negativeVotes;

    @JsonProperty("picks_bans")
    private List<Pick> picksBans;

    @JsonProperty("pre_game_duration")
    private int preGameDuration;

    @JsonProperty("game_mode")
    private GameMode gameMode;

    @JsonProperty("flags")
    private int flags;

    @JsonProperty("radiant_score")
    private int radiantScore;

    @JsonProperty("dire_score")
    private int direScore;

    @JsonProperty("engine")
    private int engine;
}
