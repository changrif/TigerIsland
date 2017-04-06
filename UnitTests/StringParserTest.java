import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class StringParserTest{
    private StringParser parser;
    String messageSentToBothPlayersAfterATurn = "GAME <gid> MOVE <#> PLAYER <pid> " +
            "PLACE <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";

    @Before
    public void setUp(){
        parser = new StringParser();
    }
    @Test
    public void getOpponentMoveFromServerTest(){
        String expected = "PLACE <tile> AT <x> <y> <z> <orientation> FOUND SETTLEMENT AT <x> <y> <z>";
        Assert.assertEquals(expected, parser.getOpponentMoveFromServer(messageSentToBothPlayersAfterATurn));
    }

    @Test
    public void mergeStringArrayIntoStringTest(){
        String[] splitUpArray = {"PLACE", "<tile>", "AT", "<x>", "<y>", "<z>"};
        String combinedString = parser.mergeStringArrayIntoString(splitUpArray);
        Assert.assertEquals("PLACE <tile> AT <x> <y> <z>", combinedString);
    }


}
