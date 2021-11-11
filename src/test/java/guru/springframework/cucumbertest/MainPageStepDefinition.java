package guru.springframework.cucumbertest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainPageStepDefinition {
	
	WebDriver driver;
	String text;

	@Given("Launch the web site")
	public void launch_the_web_site() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8089/");
	}

	
	@When("Click on the home button")
	public void click_on_the_home_button() {
	    driver.findElement(By.className("navbar-brand")).click();
	}
	@Then("We should see main page texts and logo")
	public void we_should_see_main_page_texts_and_logo() {
		 text = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/h2")).getText();
		  assertEquals(text, "Spring Framework Guru");
		  
		  text = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/h3")).getText();
		  assertEquals(text, "Spring Boot Web App");
		  
		  assertNotNull(driver.findElement(By.cssSelector("img[src='/images/NewBannerBOOTS_2.png']")));
	}
	
}
