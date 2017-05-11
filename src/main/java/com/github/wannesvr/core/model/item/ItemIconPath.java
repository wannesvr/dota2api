package com.github.wannesvr.core.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemIconPath {
    @JsonProperty("path")
    private String itemIconPath;
}
