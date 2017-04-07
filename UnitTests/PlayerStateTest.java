import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ddmac on 4/7/2017.
 */
public class PlayerStateTest {
    PlayerState p = new PlayerState();

    @Test
    public void doesStringCorrectlyDetermineIllegalTilePlacementState(){
        String test = "FORFEITED: ILLEGAL TILE PLACEMENT";
       PlayerState.gameState state = PlayerState.gameState.FORFEITED_ILLEGAL_TILE_PLACEMENT;
        Assert.assertEquals(state, p.getStateOfTheGameAfterMove(test));

    }

    @Test
    public void doesStringCorrectlyDetermineIllegalBuildState(){
        String test = "FORFEITED: ILLEGAL BUILD";
        PlayerState.gameState state = PlayerState.gameState.FORFEITED_ILLEGAL_BUILD;
        Assert.assertEquals(state, p.getStateOfTheGameAfterMove(test));

    }

    @Test
    public void doesStringCorrectlyDetermineTimeoutState(){
        String test = "FORFEITED: TIMEOUT";
        PlayerState.gameState state = PlayerState.gameState.FORFEITED_TIMEOUT;
        Assert.assertEquals(state, p.getStateOfTheGameAfterMove(test));

    }

    @Test
    public void doesStringCorrectlyDetermineUnableToBuildState(){
        String test = "LOST: UNABLE TO BUILD";
        PlayerState.gameState state = PlayerState.gameState.LOST_UNABLE_TO_BUILD;
        Assert.assertEquals(state, p.getStateOfTheGameAfterMove(test));

    }

}
