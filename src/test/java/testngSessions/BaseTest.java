package testngSessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	WebDriver driver;
	@Parameters({"url","browserName"})
	@BeforeTest
	public void setUp(String url,String browserName) {
		if(browserName.trim().equalsIgnoreCase("chrome")) {
		   driver = new ChromeDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Please pass right browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
			
	}
	@AfterTest
	public void tearDown() {
		driver.quit();	
	}

}
