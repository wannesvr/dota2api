package com.github.wannesvr.core.model.hero;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response class for the HeroesRequest.
 */
@Data
@NoArgsConstructor
public class HeroList {
    @JsonProperty("heroes")
    private List<Hero> heroes;
}
