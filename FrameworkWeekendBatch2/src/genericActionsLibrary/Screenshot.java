package genericActionsLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.sun.jna.platform.FileUtils;

public class Screenshot 
{
	public static void captureScreenshot(WebDriver driver, String screenshotName) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(srcImg, new File("./screenshots/"+screenshotName+".jpeg"));
	}
}
