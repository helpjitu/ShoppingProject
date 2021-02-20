package com;

import org.testng.annotations.Test;
import base.Base;

import pageFactory.*;

public class HomepageTest extends Base{

	@Test
	public void home() throws InterruptedException {
		
		initiateDriver(loadProp().getProperty("browser"));
		System.out.println("Opening Flipkart");
	
		
		
		driver.get("https://flipkart.com");
	//	Thread.sleep(3000);
	//	windowChild();
		SigninPage sp = new SigninPage(driver);
		sp.emailMoElement().sendKeys("9966671896");
		sp.passwordElement().sendKeys("Hello");
		sp.signInButton().click();
		driver.quit();
	}

	

}
