package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static AppiumDriver<MobileElement> driver; {
		
	}	
	
		

	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);

	}
	public static  void quit() {
		 driver.quit();
	}

	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}
	public static void click(WebElement e) {
		 e.click();
		
	}
	public static void clear(WebElement e) {
		 e.clear();
		
	}
	public static String gettext(WebElement e) {
		 
		 String text = e.getText();
		return text;
	}


	public void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(source, new File("./screenshots/" + screenshotName + ".png"));
	}

		public static void takesScreenshot(WebDriver driver, String screenshotName) {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File file = tk.getScreenshotAs(OutputType.FILE);
			File f = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + screenshotName + ".png");
			try {
				FileUtils.copyFile(file, f);
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
		
		public void captureOfflinesearchScreenshot(WebDriver driver, String screenshotName) throws IOException {
		    TakesScreenshot ts = (TakesScreenshot) driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(source, new File("./OfflineSearchScreenshots/" + screenshotName + ".png"));
		}

		
		}
	



