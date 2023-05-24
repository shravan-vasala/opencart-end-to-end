package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		logger = LogManager.getLogger(this.getClass());
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/index.php");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	public String randomString() {
		String genStr = RandomStringUtils.randomAlphabetic(5);
		return genStr;
	}
	
	public String randomNumber() {
		String genNum = RandomStringUtils.randomNumeric(10);
		return genNum;
	}
	
	public String randomAlphaNumeric() {
		String alp = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return alp + "@" + num;
	}
}

