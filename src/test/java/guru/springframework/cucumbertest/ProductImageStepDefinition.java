package guru.springframework.cucumbertest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductImageStepDefinition {
	WebDriver driver;
	String imageUrl;
	
	@Given("Launch web site")
	public void launch_web_site() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8089/");
	}
	
	@And("Click on the {string} button")
	public void click_on_the_button(String string) {
	   driver.findElement(By.linkText(string)).click();
	   assertEquals(driver.getCurrentUrl(), "http://localhost:8089/products");
	}
	
	@When("Click on the {string} link for first product")
	public void click_on_the_link_for_first_product(String string) {
	   driver.findElement(By.cssSelector("a[href='/product/1']")).click();
	}
	@When("Copy Image Url and go to the url")
	public void copy_image_url_and_go_to_image_url() {
	    imageUrl = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/div/p")).getText();
	    driver.navigate().to(imageUrl);
	}
	
	@Then("The product image should be visible")
	public void the_product_image_should_be_visible() {
	    assertNotNull(driver.findElement(By.xpath("/html/body/img")));
	}
	
	@When("Click on the {string} link for second product")
	public void click_on_the_link_for_second_product(String string) {
	   driver.findElement(By.cssSelector("a[href='/product/2']")).click();
	}
	@When("Copy Image Url and go to url")
	public void copy_image_url_and_go_to_url() {
	    imageUrl = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/div/p")).getText();
	    driver.navigate().to(imageUrl);
	}
	
	@Then("The product image is visible")
	public void the_product_image_is_visible() {
	    assertNotNull(driver.findElement(By.xpath("/html/body/img")));
	}
}
