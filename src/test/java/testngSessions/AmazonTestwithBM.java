package testngSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTestwithBM {

		public WebDriver driver;
		@BeforeMethod
		public void setUp() {
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://amazon.in");
		}
		@Test(priority=1)
		public void titleTest() {
			String title = driver.getTitle();
			Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");	
		}
		@Test(priority=2)
		public void searchExistTest() {
			boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed(); 
			Assert.assertTrue(flag);
		}
		@Test(priority=3)
		public void isHelpExistTest() {
			boolean flag = driver.findElement(By.linkText("Help")).isDisplayed(); 
			Assert.assertTrue(flag);
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
