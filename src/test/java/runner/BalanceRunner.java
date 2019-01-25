package runner; 

import org.junit.runner.RunWith; 
import cucumber.api.junit.Cucumber; 
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", 
		glue= {"featureSteps"} ) 

public class BalanceRunner { 
}
