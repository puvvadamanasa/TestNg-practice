package testngSessions;

import org.testng.annotations.Test;

public class TetsDependency {
	@Test
	public void searchTest() {
		System.out.println("search test");
		//int i=9/0;
	}
	
	@Test(dependsOnMethods = "searchTest")
	public void addToCart() {
		System.out.println("add to cart");//skipped
		int i=9/0;
	}
	
	@Test(dependsOnMethods = "addToCart")
	public void makePayment() {
		System.out.println("make payment");//skipped
	}

}
