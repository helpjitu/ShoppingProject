package com;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Page;
import page.actions.SignInPage;
import utilities.Utilities;

public class SignInTest extends Page{
	@BeforeMethod
	public void start()
	{
		initConfiguration();
	}
	@Test(dataProviderClass = Utilities.class,dataProvider = "dp")
	public void signInTest(Hashtable<String, String> data)
	{
		SignInPage signIn=new SignInPage();
		signIn.doLogin(data.get("username"),data.get("password"));
	}
	
	@AfterMethod
	
	public void end()
	{
		tearDown();
	}
}
