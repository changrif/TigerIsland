import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by ddmac on 3/23/2017.
 */
public class PlayerTest {

    private Player p;

    @Before
    public void setUpPlayer(){
        p = new Player("Nick");
    }

    @Test
    public void playerNameShouldBeNick(){
        Assert.assertEquals("Nick", p.getPlayerName());
    }

    @Test
    public void numberOfTigersShouldBeTwoWhenGameStarts(){
        Assert.assertEquals(2, p.getNumberOfTigersIHave());
    }

    @Test
    public void numberOfTotorosShouldBeThreeWhenGameStarts(){
        Assert.assertEquals(3, p.getNumberOfTotorosIHave());
    }

    @Test
    public void numberOfMeeplesShouldBeTwentyWhenGameStarts(){
        Assert.assertEquals(20, p.getNumberOfMeeplesIHave());
    }

    @Test
    public void numberOfMeeplesShouldBeTwoWhenEighteenMeeplesAreDeducted(){
        p.decreaseNumberOfMeeplesByAmount(15);
        p.decreaseNumberOfMeeplesByAmount(3);
        Assert.assertEquals(2, p.getNumberOfMeeplesIHave());
    }

    @Test
    public void numberOfTotorosShouldBeOneWhenTwoTotorosAreDeducted() throws NotEnoughTotoro{
        p.decreaseNumberOfTotorosByAmount(2);
        Assert.assertEquals(1, p.getNumberOfTotorosIHave());
    }

    @Test
    public void numberOfTigersShouldBeOneWhenOneTigerIsDeducted() throws NotEnoughTigers{
        p.decreaseNumberOfTigersByAmount(1);
        Assert.assertEquals(1, p.getNumberOfTigersIHave());
    }

    @Test (expected = NotEnoughTigers.class)
    public void exceptionShouldBeThrownWhenThereIsAnAttemptToPlaceMoreTigersThanPlayerCurrentlyHas() throws NotEnoughTigers{
        p.decreaseNumberOfTigersByAmount(3);
    }

    @Test (expected = NotEnoughTotoro.class)
    public void exceptionShouldBeThrownWhenThereIsAnAttemptToPlaceMoreTotorsThanPlayerCurrentlyHas() throws NotEnoughTotoro{
        p.decreaseNumberOfTotorosByAmount(4);
    }

    @Test (expected = RuntimeException.class)
    public void exceptionShouldBeThrownWhenThereIsAnAttemptToPlaceMoreMeeplesThanPlayerCurrentlyHas(){
        p.decreaseNumberOfMeeplesByAmount(21);
    }

    @Test
    public void whenItIsTheCurrentPlayersTurnThenTheCurrentPlayersTurnValueShouldBeTrue(){
        p.setCurrentPlayersTurn(true);
        Assert.assertEquals(true, p.isCurrentPlayersTurn());
    }

    @Test
    public void whenAPlayerIsCreatedThenTheSizeOfTheSettlementsTheyHaveShouldBeZero(){
        Assert.assertEquals(0, p.getOwnedSettlementsSize());
    }
//    @Test
//    public void xCoordinateShouldEqualTheNumberInputtedByUser(){
//        int x = p.getXCoordinateInputFromPlayer();
//        Assert.assertEquals(3, x);
//    }
}
