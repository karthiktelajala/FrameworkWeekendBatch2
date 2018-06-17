package pageTestLibrary;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import genericActionsLibrary.ExcelFile;
import genericActionsLibrary.Screenshot;
import pageActionsLibrary.LoginPageActions;
import testBaseLibrary.TestBase;

public class LoginPageTestSuite extends TestBase
{
	String filePath = "./testdata/credentials.xlsx";
	String url = "http://opensource.demo.orangehrmlive.com/";
	LoginPageActions loginPageActions;
	@BeforeMethod
	public void startTest() throws Exception
	{
		testInitialize("chrome", url);
		Screenshot.captureScreenshot(driver, "LoginPage");
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials() throws Exception
	{
		loginPageActions = new LoginPageActions(driver);
		
		String username = ExcelFile.readExcel(filePath, 0, 1, 0);
		String password = ExcelFile.readExcel(filePath, 0, 1, 1);
		
		loginPageActions.enterUserName(username);
		log.info("Entered Username: "+username);
		loginPageActions.enterPassword(password);
		log.info("Entered Password: "+password);
		loginPageActions.clickLoginButton();
		Screenshot.captureScreenshot(driver, "HomePage");
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		log.info("Test Assertion between expted Title "+expTitle+" and actual Title: "+actTitle);
	}
	
	@Test(priority=2)
	public void loginWithInvalidCredentials() throws Exception
	{
		loginPageActions = new LoginPageActions(driver);
		
		String username = ExcelFile.readExcel(filePath, 0, 2, 0);
		String password = ExcelFile.readExcel(filePath, 0, 2, 1);
		loginPageActions.enterUserName(username);
		loginPageActions.enterPassword(password);
		loginPageActions.clickLoginButton();
		Screenshot.captureScreenshot(driver, "ErrorLogin");
		String expErrorMsg = "Invalid credentials";
		String actErrorMsg = loginPageActions.getErroLoginMessage();
		Assert.assertEquals(actErrorMsg, expErrorMsg);
	}
	
	@AfterMethod
	public void endTest()
	{
		closeBrowser();
	}
	
}
