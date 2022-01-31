package giacom.cukes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/giacom_cucumber.json"},
        features = {
                "src/test/java/giacom/features/Login.feature",
                "src/test/java/giacom/features/AutomationTask.feature"
        },
        glue = "giacom.general"
)
public class GiacomCuke {
}
