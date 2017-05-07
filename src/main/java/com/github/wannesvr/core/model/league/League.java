package com.github.wannesvr.core.model.league;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class League {
    private List<LeagueDetail> leagues;
}
