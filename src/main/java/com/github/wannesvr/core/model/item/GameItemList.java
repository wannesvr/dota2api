package com.github.wannesvr.core.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GameItemList {
    @JsonProperty("items")
    private List<GameItem> items;
}
