import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by AizeyPineda on 3/23/17.
 */

@RunWith(Cucumber.class)

@CucumberOptions(  monochrome = true,
        features = "src/test/resources/",
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" }
)

public class Runner {
}
