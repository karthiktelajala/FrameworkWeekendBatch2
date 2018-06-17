package pageActionsLibrary;

import org.openqa.selenium.WebDriver;

import pageObjectLibrary.LoginPageObjects;

public class LoginPageActions extends LoginPageObjects
{
	public LoginPageActions(WebDriver driver) 
	{
		super(driver);
	}
	
	public void enterUserName(String username)
	{
		txtUserName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		btnLoginButton.click();
	}
	
	public String getErroLoginMessage()
	{
		return msgErrorLogin.getText();
	}
}
