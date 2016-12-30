package api.dota2.model.match;

import lombok.Getter;

/**
 * A list of the picks and bans in the match, if the game mode is Captains Mode.
 */
@Getter
public class Pick {
    /**
     * Whether this entry is a pick (true) or a ban (false).
     */
    private boolean isPick;

    /**
     * The hero's unique ID. A list of hero IDs can be found via the GetHeroes method.
     */
    private int heroId;

    /**
     * The team who chose the pick or ban; 0 for Radiant, 1 for Dire.
     */
    private int team;

    /**
     * The order of which the picks and bans were selected; 0-19.
     */
    private int order;
}
