package guru.springframework.cucumbertest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductStepDefinition {
	WebDriver driver;
	String text;
	
	@Given("Launch the website")
	public void launch_the_website() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8089/");
	}
	
	@And("Click on {string} button")
	public void click_on_button(String string) {
		driver.findElement(By.linkText(string)).click();
		   assertEquals(driver.getCurrentUrl(), "http://localhost:8089/product/new");
	}
	
	
	
	@When("Enter the following data in the boxes")
	public void enter_the_following_data_in_the_boxes(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

		
		for (Map<String, String> columns : rows) {
			driver.findElement(By.id(columns.get("boxes"))).sendKeys(columns.get("data"));
		}
	}
	
	@When("Hit submit button")
	public void hit_submit_button() {
	    driver.findElement(By.cssSelector("button.btn-default")).click();
	}
	@Then("Product details table should be visible")
	public void product_details_table_should_be_visible() {
	    assertNotNull(driver.findElement(By.cssSelector("form.form-horizontal")));
	}
}
