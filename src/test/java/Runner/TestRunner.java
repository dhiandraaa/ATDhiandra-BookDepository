package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/result/report.json", "html:target/result/HtmlReports"},
        features = "src/test/resources/Features",
        glue = "Steps",
        tags = "@All"
)

public class TestRunner {
}
