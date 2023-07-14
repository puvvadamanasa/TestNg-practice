package testngSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
	}
	
	public boolean doLogin(String username,String password) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String errorMsg = driver.findElement(By.cssSelector("div.alert-dismissible")).getText();
		if(errorMsg.contains("Warning: No match for E-Mail Address and/or Password.")) {
			return true;
		}
		return false;
	}
	@DataProvider
	public Object[][] getLoginNegativeData() {
		return new Object[][] {
			{"mnk@gmail.com","as@"},
			{"ksdjfkl.com","sdj"},
			{"sdfkl.com"," "},
			{" ","dskfj"},
		};
	}
	
	@Test(dataProvider = "getLoginNegativeData")
	public void loginTest(String uname,String pwd) {
		boolean flag = doLogin(uname,pwd);
		Assert.assertTrue(flag);
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
