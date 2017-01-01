package api.dota2.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class GameItemList {
    @JsonProperty("item")
    private List<GameItem> items;
}
