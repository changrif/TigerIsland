import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ddmac on 3/22/2017.
 */
public class TigerTest {
    private Tiger t;

    @Before
    public void createTiger(){
        t = new Tiger(1);
    }

    @Test
    public void pointValueAfterCreatingATigerShouldBeSeventyFive(){
        Assert.assertEquals(75, t.getPointValue());
        Assert.assertFalse(t.getPointValue()!= 75);
    }



    @Test
    public void playerIDShouldMatchWhatYouPassInTheParameter(){
        Assert.assertEquals(1, t.getPlayer());
    }
}