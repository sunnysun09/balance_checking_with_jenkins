package featureSteps;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObjects.BalanceDetail;    
    
public class BalanceSteps {
       WebDriver driver;
       BalanceDetail bd;
     
       @Given("^I navigate to the page on Chrome$")
       public void createDriver() {
	 
    	   System.out.println("Given I navigate to the page on Chrome");
	           
	       System.setProperty("webdriver.chrome.driver","C:\\Users\\guaizi\\chromedriver.exe");
	       driver = new ChromeDriver();
	       //driver.manage().window().maximize();
	       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
       
       @When("^the page is loaded$")
       public void pageLoad(){
    	   System.out.println("When the page is loaded");
    	   
    	   driver.get("C:\\Users\\guaizi\\eclipse-workspace\\BalanceChecking\\TestForm.html");	       
           bd = new BalanceDetail(driver);
       }
       
       @Then("^verify the text fields and total balance are correct$")
       public void verifyBalance(){
           System.out.println("Then verify the text fields and total balance are correct");
              
           bd.balanceChecking();         
           driver.quit();
       }
}