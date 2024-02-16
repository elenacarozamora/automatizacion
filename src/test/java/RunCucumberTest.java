
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;


@RunWith(CucumberSerenityRunner.class)
//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resource/features",
        glue = "")
public class RunCucumberTest {
}