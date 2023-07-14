package testngSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
	
	@BeforeSuite
	public void startDBConnection() {
		System.out.println("start DB");
	}
	@BeforeTest
	public void createUser() {
		System.out.println("create user");
	}
	@BeforeClass
	public void launchBrowser() {
		System.out.println("launchBrowser");
	}
	@BeforeMethod
	public void loginInToApp() {
		System.out.println("BM...Login into App.");
	}
	@Test(priority=2)
	public void titleTest() {
		System.out.println("title test");
	}
	@Test(priority=1)
	public void urlTest() {
		System.out.println("url test");
	}
	@Test(priority=3)
	public void searchTest() {
		System.out.println("search test");
	}
	@AfterMethod
	public void logout() {
		System.out.println("am....logout");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("after class closeBrowser");
	}
	@AfterTest
	public void deleteUser() {
		System.out.println("atest--delete user");
	}
	@AfterSuite
	public void closeDB() {
		System.out.println("close db");
	}

}
