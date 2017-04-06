/**
 * Created by Nick Kroeger on 4/5/2017.
 */
public class PlayerState {

    public PlayerState.gameState getStateOfTheGameAfterMove(String a) {
        if(a.equalsIgnoreCase("FORFEITED: ILLEGAL TILE"))
            return PlayerState.gameState.FORFEITED_ILLEGAL_TILE_PLACEMENT;
        if(a.equalsIgnoreCase("FORFEITED: ILLEGAL BUILD"))
            return PlayerState.gameState.FORFEITED_ILLEGAL_BUILD;
        if(a.equalsIgnoreCase("FORFEITED: TIMEOUT"))
            return gameState.FORFEITED_TIMEOUT;
        if(a.equalsIgnoreCase("LOST: UNABLE TO BUILD"))
            return gameState.LOST_UNABLE_TO_BUILD;
        return null;
    }
    public enum gameState {
        FORFEITED_ILLEGAL_TILE_PLACEMENT,
        FORFEITED_ILLEGAL_BUILD,
        FORFEITED_TIMEOUT,
        LOST_UNABLE_TO_BUILD,
        WINNER
    }
}
