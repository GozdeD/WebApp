package guru.springframework.newtest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	WebDriver driver;
	String text;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();

		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCerts");
		options.addArguments("--ignore-certificate-errors"); */

		/*options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars"); */ 

		//driver = new ChromeDriver(options);
		
		driver = new ChromeDriver();

		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://localhost:8089/");
		
	}
	
  @Test
  public void mainPage() {
	  text = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/h2")).getText();
	  assertEquals(text, "Spring Framework Guru");
	  
	  text = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/h3")).getText();
	  assertEquals(text, "Spring Boot Web App");
	  
	  assertNotNull(driver.findElement(By.cssSelector("img[src='/images/NewBannerBOOTS_2.png']")));
  }


  @AfterClass
  public void afterClass() throws InterruptedException {
	  TimeUnit.SECONDS.sleep(5);
	  driver.close();
  }

}
