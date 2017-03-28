import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nick Kroeger on 3/21/2017.
 */
public class MeepleTest {
    private Meeple m;

    @Before
    public void createMeeple(){
        m = new Meeple("Kyle");
    }

    @Test
    public void pointValueAfterCreatingAMeepleShouldBeOne(){
        Assert.assertEquals(1, m.getPointValue());
    }

    @Test
    public void playerIDShouldMatchWhatYouPassInTheParameter(){
        Assert.assertEquals(3, m.getPlayer());
    }


}
