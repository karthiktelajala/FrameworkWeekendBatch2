package testBaseLibrary;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase 
{
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	public void testInitialize(String browser,String url) throws Exception
	{
		String log4jPath ="log4jProperties";
		PropertyConfigurator.configure(log4jPath);
		this.launchBrowser(browser);
		log.info(browser+" is laucnched");
		this.getURL(url);
		log.info("Navigated to the url: "+url);
	}
	public void launchBrowser(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();       
			driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			throw new Exception("No mathcing browser found");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	}
	
	public void getURL(String url)
	{
		driver.get(url);
	}
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}
}
