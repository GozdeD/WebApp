package guru.springframework.cucumbertest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/features/springBootWeb" })
public class TestRunnerCucumberTest extends AbstractTestNGCucumberTests{

}
