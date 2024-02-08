import cucumber.api.SnippetType;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resource/features",
        snippets = SnippetType.CAMELCASE)
public class RunCucumberTest {
}