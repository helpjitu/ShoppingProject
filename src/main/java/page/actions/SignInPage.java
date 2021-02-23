package page.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Page;
import page.locators.SignInPageLocators;

public class SignInPage extends Page{
	public SignInPageLocators signInPage;
	public SignInPage() {
		this.signInPage=new SignInPageLocators();
		AjaxElementLocatorFactory factory =new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.signInPage);
		
	}
	
	
	public void doLogin(String username, String password)
	{
		type(signInPage.emailMobile, username);
		type(signInPage.password, password);
		clickElement(signInPage.signInButton);
	}

}
