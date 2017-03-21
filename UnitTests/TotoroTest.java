import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nick Kroeger on 3/21/2017.
 */
public class TotoroTest {

    private Totoro t;

    @Before
    public void createTotoro(){
        t = new Totoro(2);
    }

    @Test
    public void pointValueAfterCreatingATotoroShouldBeTwoHundred(){
        Assert.assertEquals(200, t.getPointValue());
        Assert.assertFalse(t.getPointValue()!= 200);
    }



    @Test
    public void playerIDShouldMatchWhatYouPassInTheParameter(){
        Assert.assertEquals(2, t.getPlayer());
    }
}
