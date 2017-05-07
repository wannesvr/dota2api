package com.github.wannesvr.core.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GameItemList {
    @JsonProperty("item")
    private List<GameItem> items;
}
