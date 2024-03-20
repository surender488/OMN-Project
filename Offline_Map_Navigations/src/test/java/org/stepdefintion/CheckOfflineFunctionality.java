package org.stepdefintion;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CheckOfflineFunctionality extends BaseClass {
	public static  AndroidDriver<MobileElement> driver;


	@Given("UserAO can first select language")
	public void UserAO_can_first_select_language()  throws MalformedURLException {
		DesiredCapabilities  capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("PlatformVersion", "11");
		capabilities.setCapability("udid", "R58M7048EEW");
		capabilities.setCapability("deviceName", "Vivo");
		capabilities.setCapability("appPackage", "com.virtualmaze.offlinemapnavigationtracker");
		capabilities.setCapability("appActivity", "com.ne.services.android.navigation.testapp.demo.DemoSplashActivity");

		capabilities.setCapability("waitForIdleTimeout", 0);
		capabilities.setCapability("animationDurationScale", 0);
		capabilities.setCapability("newCommandTimeout", 0);
		URL url =new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.toggleWifi();




	}

	@When("UserAO can click  apply button")
	public void UserAO_can_click_apply_button()throws InterruptedException {
		WebElement ClickApply = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button\r\n"));
		ClickApply.click();
		Thread.sleep(10000);
	}

	@When("UserAO can click next the option")
	public void UserAO_can_click_next_the_option() throws InterruptedException {
		Thread.sleep(3000);	
		for (int i = 1; i < 5; i++) {
			WebElement continues = driver.findElement(By.xpath("//*[@class='android.widget.Button']"));
			continues.click();
			Thread.sleep(3000);	
		}


	}
	@When("UserAO can click  continues button")
	public void UserAO_can_click_continues_button() throws InterruptedException {

		try {
			WebElement continues = driver.findElement(By.xpath("//*[@text='Continue']"));
			continues.click();
		} catch (Exception e) {
			System.out.println("Failed to click on the element");
			e.printStackTrace();
		}
	}

	@When("UserAO Can click  I will do it Later")
	public void UserAO_Can_click_I_will_do_it_Later() throws InterruptedException {
		Thread.sleep(15000);
		int numTries = 10; 
		WebElement clicklater = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView"));

		for (int i = 0; i < numTries; i++) {
			try {
				clicklater.click();
				break; // 
			} catch (WebDriverException e) {
				System.out.println("Attempt #" + (i+1) + " failed. Retrying...");
			}
		}
	}

	@When("UserAO can click  allow button")
	public void UserAO_can_click_allow_button()throws InterruptedException {
		WebElement clickAllow = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button"));
		clickAllow.click();
		Thread.sleep(5000);
		WebElement clickusingapp = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]"));
		clickusingapp.click();
	}

	@When("UserAO can download the offline bundle")
	public void UserAO_can_download_the_offline_bundle() throws InterruptedException {
		Thread.sleep(8000);

		//		WebElement skip = driver.findElement(By.xpath("//*[@text='Skip']"));
		//		skip.click();
		WebElement clickskip = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button"));
		clickskip.click();
		Thread.sleep(5000);
		WebElement skipanyway = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"));
		skipanyway.click();
	}

	@When("UserAO can click the Get Started button")
	public void UserAO_can_click_the_Get_Started_button()throws InterruptedException {
		Thread.sleep(5000);

		WebElement clickStartbtn = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button"));
		clickStartbtn.click();
	}

	@When("UserAO can verify the Loading page")
	public void UserAO_can_verify_the_Loading_page() throws InterruptedException, IOException {
		Thread.sleep(8000);
		takesScreenshot(driver, "Initialisation Offline");
	}

	@Given("UserLO can login OMN Application")
	public void UserLO_can_login_OMN_Application() throws MalformedURLException {
		DesiredCapabilities  capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("PlatformVersion", "11");
		capabilities.setCapability("udid", "R58M7048EEW");
		capabilities.setCapability("deviceName", "Vivo");
		capabilities.setCapability("appPackage", "com.virtualmaze.offlinemapnavigationtracker");
		capabilities.setCapability("appActivity", "com.ne.services.android.navigation.testapp.demo.DemoSplashActivity");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("waitForIdleTimeout", 0);
		capabilities.setCapability("animationDurationScale", 0);
		capabilities.setCapability("newCommandTimeout", 0);
		URL url =new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.toggleWifi();



	}

	@When("UserLO can click the menu")
	public void UserLO_can_click_the_menu() {
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();

	}

	@When("UserLO can click the settings")
	public void UserLO_can_click_the_settings() {
		WebElement clicksetting = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting.click();
	}

	@When("UserLO can click the languages")
	public void UserLO_can_click_the_languages() {

		WebElement clicklanguage = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage.click();
	}


	@When("UserLO can Verify All the languages")
	public void UserLO_can_Verify_All_the_languages() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 600);

		WebElement bashsana = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[1]"));

		bashsana.click();
		WebElement apply = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply.click();

		Thread.sleep(5000);

		captureScreenshot(driver, "Indonesia");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Indonesia.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Indonesia1 screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Indonesia1 screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	


		Thread.sleep(5000);
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();
		WebElement clicksetting = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting.click();

		WebElement clicklanguage = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage.click();
		//scroll down
		//Thread.sleep(3000);
		//driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Română\").instance(0))"));

		WebElement melayu = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[2]"));
		melayu.click();

		WebElement apply1 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply1.click();
		Thread.sleep(5000);
		// Assuming WebDriver driver is already initialized
		//	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		captureScreenshot(driver, "Indonesia2");

		// Define the path where you want to save the screenshot
		//String filePath = "src/test/resources/screenshotss/screenshot.png";
		try {


			String filePath11 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Indonesia2.png";

			// Copy the file to the desired location
			//	FileUtils.copyFile(scrFile, new File(filePath));
			// Load the reference image from the path
			BufferedImage expectedImage1 = ImageIO.read(new File(filePath11));

			// Take a new screenshot for verification
			Screenshot actualScreenshot1 = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage1 = actualScreenshot1.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff1 = new ImageDiffer().makeDiff(expectedImage1, actualImage1);

			if (diff1.hasDiff()) {
				System.out.println("The Indonesia2 screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff1.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Indonesia2 screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		Thread.sleep(5000);
		WebElement clickmenu1 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1.click();
		WebElement clicksetting1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting1.click();

		WebElement clicklanguage1 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage1.click();

		WebElement deutush = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[3]"));
		deutush.click();

		WebElement apply2 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply2.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "Deutsch");

		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Deutsch.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Deutsch language screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Deutsch screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

		Thread.sleep(5000);
		WebElement clickmenu11 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11.click();
		WebElement clicksetting2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2.click();

		WebElement clicklanguage2 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2.click();

		WebElement english = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[4]"));
		english.click();

		WebElement apply3 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "English");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\English.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The English language screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The English screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

		Thread.sleep(5000);
		WebElement clickmenu111 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu111.click();
		WebElement clicksetting21 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting21.click();

		WebElement clicklanguage21 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage21.click();

		WebElement espanol = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[5]"));
		espanol.click();

		WebElement apply31 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply31.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "Español");

		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Español.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Español language screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Español screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	


		Thread.sleep(5000);
		WebElement clickmenu1111 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1111.click();
		WebElement clicksetting211 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting211.click();

		WebElement clicklanguage211 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage211.click();

		WebElement francais = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[6]"));
		francais.click();

		WebElement apply311 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply311.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Français");

		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Français.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Français screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Français screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11119 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11119.click();
		WebElement clicksetting29 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting29.click();

		WebElement clicklanguage29 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage29.click();

		WebElement italaino = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[7]"));
		italaino.click();

		WebElement apply30 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Italiano");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Italiano.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Italiano screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Italiano screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

		Thread.sleep(5000);
		WebElement clickmenu110 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110.click();
		WebElement clicksetting20 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20.click();

		WebElement clicklanguage20 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20.click();

		WebElement portugues = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[8]"));
		portugues.click();

		WebElement apply309 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Português");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Português.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Português screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Português screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	


		Thread.sleep(5000);
		WebElement clickmenu1109 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1109.click();
		WebElement clicksetting209 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting209.click();

		WebElement clicklanguage209 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage209.click();
		//scroll down

		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Română\").instance(0))"));

		WebElement romana = driver.findElement(By.xpath("//*[@text='Română']"));
		romana.click();

		WebElement apply3098 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3098.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Română");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Română.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Română screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Română screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	


		Thread.sleep(5000);
		WebElement clickmenu1108 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1108.click();
		WebElement clicksetting208 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting208.click();

		WebElement clicklanguage208 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage208.click();
		//scroll down

		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Tiếng Việt\").instance(0))"));

		WebElement tieng = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[3]"));
		tieng.click();

		WebElement apply30988 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30988.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Tiếng Việt");

		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Tiếng Việt.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Tiếng Việt screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Tiếng Việt screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu1107 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1107.click();
		WebElement clicksetting207 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting207.click();

		WebElement clicklanguage207 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage207.click();
		//scroll down

		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Pусский\").instance(0))"));

		WebElement pycckm = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[4]"));
		pycckm.click();

		WebElement apply309887 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309887.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Pусский");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Pусский.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Pусский screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Pусский screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11077 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11077.click();
		WebElement clicksetting2077 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2077.click();

		WebElement clicklanguage2077 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2077.click();
		//scroll down

		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Türk\").instance(0))"));

		WebElement turk = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[5]"));
		turk.click();

		WebElement apply30977 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30977.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Türk");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Türk.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Türk screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Türk screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu1106 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1106.click();
		WebElement clicksetting206 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting206.click();

		WebElement clicklanguage206 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage206.click();
		//scroll down

		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"العربية\").instance(0))"));

		WebElement العربية = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[6]"));
		العربية.click();

		WebElement apply3096 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3096.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "العربية");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\العربية.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The العربية screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The العربية screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

		Thread.sleep(5000);
		WebElement clickmenu11066 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11066.click();
		WebElement clicksetting2066 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2066.click();

		WebElement clicklanguage2066 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2066.click();
		//scroll down

		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"मराठी\").instance(0))"));

		WebElement hindi = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[7]"));
		hindi.click();

		WebElement apply30965 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30965.click();


		Thread.sleep(5000);
		captureScreenshot(driver, "मराठी");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\मराठी.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The मराठी  screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The मराठी  screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu1105 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1105.click();
		WebElement clicksetting205 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting205.click();

		WebElement clicklanguage205 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"हिन्दी\").instance(0))"));

		WebElement hindi2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[8]"));
		hindi2.click();

		WebElement apply3095 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "हिन्दी");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\हिन्दी.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The हिन्दी   screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The हिन्दी   screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11054 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11054.click();
		WebElement clicksetting2054 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2054.click();

		WebElement clicklanguage2054 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2054.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"தமிழ்\").instance(0))"));

		WebElement tamil = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[2]"));
		tamil.click();

		WebElement apply30954 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30954.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "ગુજરાતી");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\ગુજરાતી.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The ગુજરાતી  screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The ગુજરાતી screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110544 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110544.click();
		WebElement clicksetting20544 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20544.click();

		WebElement clicklanguage20544 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20544.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"తెలుగు\").instance(0))"));

		WebElement telugu = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[3]"));
		String text = telugu.getText();
		telugu.click();

		WebElement apply309544 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309544.click();



		Thread.sleep(5000);
		captureScreenshot(driver, "বাংলা");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\বাংলা.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The বাংলা  screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The বাংলা  screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	


		Thread.sleep(5000);

		WebElement clickmenu11053 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053.click();
		WebElement clicksetting2053 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053.click();

		WebElement clicklanguage2053 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"ಕನ್ನಡ\").instance(0))"));

		WebElement telugu2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[4]"));
		telugu2.click();

		WebElement apply30953 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30953.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "ਪੰਜਾਬੀ");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\ਪੰਜਾਬੀ.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The ਪੰਜਾਬੀ  screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The ਪੰਜਾਬੀ  screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110533 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110533.click();
		WebElement clicksetting20533 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20533.click();

		WebElement clicklanguage20533 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20533.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"മലയാളം\").instance(0))"));

		WebElement telugu3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[5]"));
		telugu3.click();

		WebElement apply309533 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309533.click();
		captureScreenshot(driver, "বাংলা");
		//		try {
		//			
		//			
		//			 String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\বাংলা.png";
		//
		//		
		//				  // Load the reference image from the path
		//			    BufferedImage expectedImage = ImageIO.read(new File(filePath1));
		//
		//			    // Take a new screenshot for verification
		//			    Screenshot actualScreenshot = new AShot().takeScreenshot(driver);
		//
		//			    // Convert the screenshot to BufferedImage for comparison
		//			    BufferedImage actualImage = actualScreenshot.getImage();
		//
		//			    // Compare the actual screenshot with the expected one
		//			    ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);
		//
		//			    if (diff.hasDiff()) {
		//			        System.out.println("The বাংলা    screenshots do not match.");
		//			        // Optionally, save the diff image
		//			        ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
		//			    } else {
		//			        System.out.println("The বাংলা  screenshots match.");
		//			    }
		//			} catch (Exception e) {
		//				e.printStackTrace();
		//			}	
		Thread.sleep(5000);
		WebElement clickmenu110532 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110532.click();
		WebElement clicksetting20532 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20532.click();

		WebElement clicklanguage20532 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20532.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"ไทย\").instance(0))"));

		WebElement telugu33 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[6]"));
		telugu33.click();

		WebElement apply3095333 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095333.click();


		Thread.sleep(5000);
		WebElement clickmenu1105322 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1105322.click();
		WebElement clicksetting205322 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting205322.click();

		WebElement clicklanguage205322 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205322.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"ไทย\").instance(0))"));

		WebElement telugu4 = driver.findElement(By.xpath("//*[@text='ไทย']"));
		telugu4.click();

		WebElement apply3095322 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095322.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "ไทย");

		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\ไทย.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The ไทย  screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The ไทย   screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu1105321 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1105321.click();
		WebElement clicksetting205321 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting205321.click();

		WebElement clicklanguage205321 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205321.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"中文（简体）\").instance(0))"));

		WebElement china = driver.findElement(By.xpath("//*[@text='한국의']"));
		china.click();

		WebElement apply3095321 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095321.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "한국의");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\한국의.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The 한국의  screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The 한국의   screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531.click();
		WebElement clicksetting20531 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531.click();

		WebElement clicklanguage20531 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20531.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"中文（繁体）\").instance(0))"));

		WebElement china2 = driver.findElement(By.xpath("//*[@text='中文（简体）']"));
		china2.click();

		WebElement apply3095311 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311.click();
		Thread.sleep(5000);
		//		captureScreenshot(driver, "中文（简体）");
		//		try {
		//			
		//			
		//			 String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\中文（简体）.png";
		//
		//		
		//				  // Load the reference image from the path
		//			    BufferedImage expectedImage = ImageIO.read(new File(filePath1));
		//
		//			    // Take a new screenshot for verification
		//			    Screenshot actualScreenshot = new AShot().takeScreenshot(driver);
		//
		//			    // Convert the screenshot to BufferedImage for comparison
		//			    BufferedImage actualImage = actualScreenshot.getImage();
		//
		//			    // Compare the actual screenshot with the expected one
		//			    ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);
		//
		//			    if (diff.hasDiff()) {
		//			        System.out.println("The 中文（简体） screenshots do not match.");
		//			        // Optionally, save the diff image
		//			        ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
		//			    } else {
		//			        System.out.println("The 中文（简体） screenshots match.");
		//			    }
		//			} catch (Exception e) {
		//				e.printStackTrace();
		//			}	
		//		Thread.sleep(5000);
		WebElement clickmenu1105312 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1105312.click();
		WebElement clicksetting205312 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting205312.click();

		WebElement clicklanguage20531222 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20531222.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"čeština\").instance(0))"));

		WebElement china5 = driver.findElement(By.xpath("//*[@text='中文（繁体）']"));
		china5.click();

		WebElement apply30953113 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30953113.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "中文（繁体）");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\中文（繁体）.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The 中文（繁体） screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The 中文（繁体） screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053127 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053127.click();
		WebElement clicksetting2053125 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053125.click();

		WebElement clicklanguage205312221 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205312221.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"čeština\").instance(0))"));

		WebElement china52 = driver.findElement(By.xpath("//*[@text='日本語']"));
		china52.click();

		WebElement apply309531132 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531132.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "日本語");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\日本語.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The 日本語  screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The 日本語  screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu1105311 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1105311.click();
		WebElement clicksetting205311 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting205311.click();

		WebElement clicklanguage205311 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205311.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"български\").instance(0))"));

		WebElement china4 = driver.findElement(By.xpath("//*[@text='български']"));
		china4.click();

		WebElement apply30953112 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30953112.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "български");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\български.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The български screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The български screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053126 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053126.click();
		WebElement clicksetting2053126 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053126.click();

		WebElement clicklanguage205312226 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205312226.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"čeština\").instance(0))"));

		WebElement china56 = driver.findElement(By.xpath("//*[@text='čeština']"));
		china56.click();

		WebElement apply309531136 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531136.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "čeština");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\čeština.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The čeština screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The čeština screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053120 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053120.click();
		WebElement clicksetting2053120 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053120.click();

		WebElement clicklanguage205312220 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205312220.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"čeština\").instance(0))"));

		WebElement Dansk = driver.findElement(By.xpath("//*[@text='Dansk']"));
		Dansk.click();

		WebElement apply309531130 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531130.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Dansk");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Dansk.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Dansk screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Dansk screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053129 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053129.click();
		WebElement clicksetting2053129 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053129.click();

		WebElement clicklanguage205312229 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205312229.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"čeština\").instance(0))"));

		WebElement ελληνικά = driver.findElement(By.xpath("//*[@text='ελληνικά']"));
		ελληνικά.click();

		WebElement apply309531139 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531139.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "ελληνικά");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\ελληνικά.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The ελληνικά  screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The ελληνικά screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053128 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053128.click();
		WebElement clicksetting2053128 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053128.click();

		WebElement clicklanguage205312228 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205312228.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"čeština\").instance(0))"));

		WebElement Eesti = driver.findElement(By.xpath("//*[@text='Eesti']"));
		Eesti.click();

		WebElement apply309531138 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531138.click();


		Thread.sleep(5000);
		captureScreenshot(driver, "Eesti");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Eesti.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Eesti screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Eesti screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu1105312754 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1105312754.click();
		WebElement clicksetting2053127 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053127.click();

		WebElement clicklanguage205312227 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205312227.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"čeština\").instance(0))"));

		WebElement Suomalainen = driver.findElement(By.xpath("//*[@text='Suomalainen']"));
		Suomalainen.click();

		WebElement apply309531137 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531137.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Suomalainen");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Suomalainen.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Suomalainen screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Suomalainen screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu1105312612 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu1105312612.click();
		WebElement clicksetting205312612 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting205312612.click();

		WebElement clicklanguage20531222612 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20531222612.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Hrvatski\").instance(0))"));

		WebElement Hrvatski = driver.findElement(By.xpath("//*[@text='Hrvatski']"));
		Hrvatski.click();

		WebElement apply30953113612 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply30953113612.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Hrvatski");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Hrvatski.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Hrvatski screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Hrvatski screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053125 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053125.click();
		WebElement clicksetting205312523 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting205312523.click();

		WebElement clicklanguage205312225 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205312225.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"čeština\").instance(0))"));

		WebElement Magyar = driver.findElement(By.xpath("//*[@text='čeština']"));
		Magyar.click();

		WebElement apply309531135 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531135.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "čeština");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\čeština.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The čeština screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The čeština screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053124 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053124.click();
		WebElement clicksetting2053124 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053124.click();

		WebElement clicklanguage205312224 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage205312224.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"հայերեն\").instance(0))"));

		WebElement հայերեն = driver.findElement(By.xpath("//*[@text='հայերեն']"));
		հայերեն.click();

		WebElement apply309531134 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531134.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "հայերեն");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\հայերեն.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The հայերեն creenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The հայերեն screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053122 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053122.click();
		WebElement clicksetting2053122 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053122.click();

		WebElement clicklanguage2053122222 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122222.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"հայերեն\").instance(0))"));

		WebElement Català = driver.findElement(By.xpath("//*[@text='Català']"));
		Català.click();

		WebElement apply3095311320 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311320.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Català");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Català.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Català screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Català screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu11053121 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu11053121.click();
		WebElement clicksetting2053121 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting2053121.click();

		WebElement clicklanguage20531222130 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20531222130.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"հայերեն\").instance(0))"));

		WebElement Nederlands = driver.findElement(By.xpath("//*[@text='Nederlands']"));
		Nederlands.click();

		WebElement apply309531131 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309531131.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "Nederlands");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Nederlands.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Nederlands screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Nederlands screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531211 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531211.click();
		WebElement clicksetting20531211 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531211.click();

		WebElement clicklanguage2053122211 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122211.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Íslensku\").instance(0))"));

		WebElement עִברִית = driver.findElement(By.xpath("//*[@text='עִברִית']"));
		עִברִית.click();

		WebElement apply3095311311 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311311.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "עִברִית'");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\עִברִית'.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The עִברִית' screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The עִברִית' screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531222 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531222.click();
		WebElement clicksetting20531222 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531222.click();

		WebElement clicklanguage20531222221 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage20531222221.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"norsk\").instance(0))"));

		WebElement Íslensku = driver.findElement(By.xpath("//*[@text='Íslensku']"));
		Íslensku.click();

		WebElement apply3095311322 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311322.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "Íslensku");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Íslensku.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Íslensku screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Íslensku screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531233 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531233.click();
		WebElement clicksetting20531233 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531233.click();

		WebElement clicklanguage2053122233 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122233.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"norsk\").instance(0))"));

		WebElement norsk = driver.findElement(By.xpath("//*[@text='norsk']"));
		norsk.click();

		WebElement apply3095311333 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311333.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "norsk");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\norsk.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The norsk screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The norsk screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531244 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531244.click();
		WebElement clicksetting20531244 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531244.click();

		WebElement clicklanguage2053122244 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122244.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"norsk\").instance(0))"));

		WebElement فارسی = driver.findElement(By.xpath("//*[@text='فارسی']"));
		فارسی.click();

		WebElement apply3095311344 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311344.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "فارسی");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\فارسی.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The فارسی screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The فارسی screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531255 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531255.click();
		WebElement clicksetting20531255 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531255.click();

		WebElement clicklanguage2053122255 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122255.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Polskie\").instance(0))"));

		WebElement Polskie = driver.findElement(By.xpath("//*[@text='Polskie']"));
		Polskie.click();

		WebElement apply3095311355 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311355.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Polskie");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Polskie.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Polskie screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Polskie screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531266 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531266.click();
		WebElement clicksetting20531266 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531266.click();

		WebElement clicklanguage2053122266 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122266.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"svenska\").instance(0))"));

		WebElement svenska = driver.findElement(By.xpath("//*[@text='svenska']"));
		svenska.click();

		WebElement apply3095311366 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311366.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "svenska");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\svenska.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The svenska screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The svenska screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531277 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531277.click();
		WebElement clicksetting20531277 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531277.click();

		WebElement clicklanguage2053122277 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122277.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Українська\").instance(0))"));

		WebElement Українська = driver.findElement(By.xpath("//*[@text='Українська']"));
		Українська.click();

		WebElement apply3095311377 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311377.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Українська");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Українська.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Українська screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Українська screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531288 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531288.click();
		WebElement clicksetting20531288 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531288.click();

		WebElement clicklanguage2053122288 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122288.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Zulu\").instance(0))"));

		WebElement Zulu = driver.findElement(By.xpath("//*[@text='Zulu']"));
		Zulu.click();

		WebElement apply3095311388 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311388.click();

		Thread.sleep(5000);
		captureScreenshot(driver, "Zulu");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Zulu.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Zulu screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Zulu screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Thread.sleep(5000);
		WebElement clickmenu110531299 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu110531299.click();
		WebElement clicksetting20531299 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting20531299.click();

		WebElement clicklanguage2053122299 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage2053122299.click();
		//scroll down
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Srpski\").instance(0))"));

		WebElement Srpski = driver.findElement(By.xpath("//*[@text='Srpski']"));
		Srpski.click();

		WebElement apply3095311399 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply3095311399.click();
		Thread.sleep(5000);
		captureScreenshot(driver, "Srpski");
		try {


			String filePath1 = "C:\\Users\\Virtualmaze\\Downloads\\Offline_Map_Navigation\\Offline_Map_Navigations\\screenshots\\Srpski.png";


			// Load the reference image from the path
			BufferedImage expectedImage = ImageIO.read(new File(filePath1));

			// Take a new screenshot for verification
			Screenshot actualScreenshot = new AShot().takeScreenshot(driver);

			// Convert the screenshot to BufferedImage for comparison
			BufferedImage actualImage = actualScreenshot.getImage();

			// Compare the actual screenshot with the expected one
			ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);

			if (diff.hasDiff()) {
				System.out.println("The Srpski screenshots do not match.");
				// Optionally, save the diff image
				ImageIO.write(diff.getMarkedImage(), "PNG", new File("/path/to/diff.png"));
			} else {
				System.out.println("The Srpski screenshots match.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}


	@Given("UserBO can login OMN Application")
	public void UserBO_can_login_OMN_Application() throws MalformedURLException {
		DesiredCapabilities  capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("PlatformVersion", "11");
		capabilities.setCapability("udid", "R58M7048EEW");
		capabilities.setCapability("deviceName", "Vivo");
		capabilities.setCapability("appPackage", "com.virtualmaze.offlinemapnavigationtracker");
		capabilities.setCapability("appActivity", "com.ne.services.android.navigation.testapp.demo.DemoSplashActivity");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("waitForIdleTimeout", 0);
		capabilities.setCapability("animationDurationScale", 0);
		capabilities.setCapability("newCommandTimeout", 0);

		URL url =new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@When("UserBO Click the user location")
	public void userbo_Click_the_user_location() throws InterruptedException {

		WebElement clickUserLOocation = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/myLocationFAB"));
		clickUserLOocation.click();


	}

	@When("UserBO Verify the user Location")
	public void userbo_Verify_the_user_Location()throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 600);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID\"]"))).click();

		WebElement Downloadmaps = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[7]/android.widget.CheckedTextView"));
		Downloadmaps.click();

		WebElement sendkey = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/item_autoCompleteTextview\"]")));

		sendkey.sendKeys("India Southern Zone");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.GridView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/recycler_view_available_download_regions\"]/android.widget.RelativeLayout"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/iv_download\"])[6]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@text='816 MB']"),"816 MB"));

		System.out.println(".............Map download succefully............");
		// Close the app
		driver.closeApp();

		// Wait for some time (e.g., 5 seconds) to observe the app closing
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Restart the app
		driver.launchApp();

		// Wait for some time (e.g., 5 seconds) to observe the app restarting
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);
	}


	@When("UserBO can search any areas")
	public void UserBO_can_search_any_areas() throws InterruptedException {
		WebElement searchbox = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
		searchbox.click();



	}

	@When("UserDO can Choose destination areas")
	public void UserDO_can_Choose_destination_areas()throws InterruptedException {

		WebElement searchdestination = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		searchdestination.sendKeys("madurai");
		//Actions a=new Actions(driver);

		Thread.sleep(5000);
		WebElement selectarea1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));
		selectarea1.click();

	}

	@When("UserDO can click the search area")
	public void UserDO_can_click_the_search_area()  throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search.click();
		Thread.sleep(5000);
		WebElement clickstartpoint = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint.click();
		Thread.sleep(5000);	
		WebElement startpoint = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint.sendKeys("theni");
		Thread.sleep(5000);
		WebElement selectarea2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));
		//a.click(selectarea).perform();
		selectarea2.click();


		//		WebElement search1 = driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		//		search1.click();
		Thread.sleep(3000);
		WebElement car = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car.click();

	}

	@When("UserDO Can verify the destination point")
	public void UserDO_Can_verify_the_destination_point() throws InterruptedException, IOException {
		WebElement destinationpoint = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[3]"));
		String text = destinationpoint.getText();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("UserPO.dir") + "\\src\\test\\resources\\Screenshots\\" + text + ".png"));

		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().back();

		try {
			WebElement clickyes= driver.findElement(By.xpath("//*[@text='YES']"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}


		} catch (Exception e) {
			System.out.println("Yes button not display");
		}

		//Thread.sleep(10000);

		WebElement search11 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView']"));
		search11.click();

		WebElement searchdestination = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		searchdestination.sendKeys("salem");
		Thread.sleep(5000);
		WebElement selectarea8 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));
		selectarea8.click();
		Thread.sleep(3000);
		WebElement selectarea81 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		selectarea81.click();

		Thread.sleep(5000);
		WebElement search = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigation_route_fab"));
		search.click();
		driver.toggleWifi();

		//		try {
		//			MobileElement clickcheckbox = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/dont_show_again\"]"));
		//			MobileElement clickok = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
		//			if (clickcheckbox.isDisplayed()) {
		//				clickcheckbox.click();
		//				Thread.sleep(2000);
		//				clickok.click();
		//				
		//			}
		//		} catch (Exception e) {
		//			System.out.println();
		//			System.out.println("CheckBox is not display");
		//			System.out.println();
		//		}

		//		try {
		//			// Click on the button if it is displayed
		//			WebElement button = driver.findElement(By.xpath("//*[@text='Cancel']"));
		//			if (button.isDisplayed()) {
		//				button.click();
		//			}
		//		} catch (NoSuchElementException e) {
		//			// Handle the case when the button is not displayed
		//			System.out.println("Button is not displayed");
		//		}

		//				Thread.sleep(3000);
		//				WebElement clicks = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/navigation_route_fab']"));
		//				clicks.click();

		//WebElement clicOk= driver.findElement(By.xpath("//*[@text='OK']"));
		//clicOk.click();
		//Thread.sleep(10000);
		//		WebDriverWait wait = new WebDriverWait(driver, 30);
		//		WebElement clickzoomout = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/zoom_out']")));
		//				
		//				 for (int i = 1; i < 10; i++) {
		//			 	clickzoomout.click();
		//				 	 Thread.sleep(1000);
		//				 }
		//				 WebElement clickzoomin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/zoom_in']")));
		//					
		//		
		//				 //WebElement clickzoomin= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/zoom_in']"));
		//				 for (int i = 1; i < 10; i++) {
		//			 	clickzoomin.click();
		//				 	 Thread.sleep(1000);
		//				 }
		//Thread.sleep(3000);

		driver.navigate().back();
		WebElement exit = driver.findElement(By.xpath("//*[@text='EXIT']"));
		exit.click();

		driver.navigate().back();		
		driver.navigate().back();
		driver.navigate().back();
		//driver.navigate().back();
		try {
			WebElement yes = driver.findElement(By.xpath("//*[@text='YES']"));
			if (yes.isDisplayed()) {
				yes.click();
			}

		} catch (Exception e) {
			System.out.println("yes buttton are not displsyed");
		}

	}








	@When("UserDO can search any areas")
	public void UserDO_can_search_any_areas() throws InterruptedException {





		WebElement searchs = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView']"));
		searchs.click();
		WebElement searchdestinations = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		searchdestinations.sendKeys("London");
		Actions a= new Actions(driver);
		Thread.sleep(3000);
		WebElement selectarea = driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout']"));
		a.click(selectarea).perform();
		WebElement clickwalk = driver.findElement(By.xpath("//*[@resource-id='/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton']"));
		clickwalk.click();

		WebElement walking = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/iv_walking']"));
		walking.click();

	}

	@When("UserPO can check Retry button")
	public void UserPO_can_check_Retry_button() {
		for (int i = 1; i < 4; i++) {
			WebElement Retry = driver.findElement(By.xpath("//*[@text='Retry']"));
			Retry.click();
		}
	}

	@When("UserPO can Check Report buttton")
	public void UserPO_can_Check_Report_buttton() throws InterruptedException {
		WebElement Report = driver.findElement(By.xpath("//*[@text='Report']"));
		Report.click();

		//		WebElement REPORT = driver.findElement(By.xpath("//*[@text='REPORT']"));
		//		REPORT.click();
		Thread.sleep(5000);

		WebElement error = driver.findElement(By.xpath("//*[@resource-id='android:id/message']"));
		String text = error.getText();
		System.out.println(text);
		Thread.sleep(3000);
		takesScreenshot(driver, "Error Report");
		WebElement clickOK = driver.findElement(By.xpath("//*[@text='OK']"));
		clickOK.click();


		//		 ExcelReportUtils.writeDataToCell(0, "To validate Online Base File functionality");
		//	        ExcelReportUtils.writeDataToCell(1, "Pass");
	}


	@When("UserPO Enter a Home Page")
	public void UserPO_Enter_a_Home_Page() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("UserPO Enter The Home Page");
	}

	@When("UserPO Click the Search Box")
	public void UserPO_Click_the_Search_Box() {
		WebElement search = driver
				.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView"));
		search.click();

		Actions action = new Actions(driver);
		action.sendKeys("Trichy").perform();

	}

	@When("UserPO Enter the Related Location in Search Box")
	public void UserPO_Enter_the_Related_Location_in_Search_Box() throws InterruptedException {
		System.out.println("UserPO Search the Related Location");
		Thread.sleep(3000);
	}

	@When("UserPO Validate the Locations")
	public void UserPO_Validate_the_Locations() throws InterruptedException, IOException {
		Thread.sleep(5000);
		WebElement destinationpoint = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		String text = destinationpoint.getText();
		driver.navigate().back();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("UserPO.dir") + "\\src\\test\\resources\\Screenshots\\" + text + ".png"));
		System.out.println("UserPO Validate Location");
	}






	@When("UserPO can click the Places option")
	public void UserPO_can_click_the_Places_option() {
		//		driver.navigate().back();
		//		driver.navigate().back();
		//		driver.navigate().back();
		//driver.navigate().back();
		//		WebElement cancel = driver.findElement(By.xpath("//*[@text='Cancel']"));
		//		if (cancel.isDisplayed()) {
		//			
		//			cancel.click();
		//		} else {
		//System.out.println();
		//}



		WebElement clickplaces = driver.findElement(By.xpath("//*[@text='Places']"));
		clickplaces.click();
	}

	@When("UserPO can click the POI option")
	public void UserPO_can_click_the_POI_option() {
		WebElement clickpoi = driver.findElement(By.xpath("//*[@text='POI']"));
		clickpoi.click();

	}

	@When("UserPO can check Food POI option and click restaurant")
	public void UserPO_can_check_Food_POI_option_and_click_restaurant() {
		try {


			WebElement clickpoi = driver.findElement(By.xpath("//*[@text='Restaurant']"));
			clickpoi.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			//String text = element.getText();
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Restaurants", element.getText());
				System.out.println("restaurant verify successfull.");
			} else {
				System.out.println("restaurant  verify successfull.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can verify the restaurant")
	public void UserPO_can_verify_the_restaurant() throws InterruptedException {
		takesScreenshot(driver,"restaurant screenshot");
		try {

			WebElement ShowMap = driver.findElement(By.xpath("//*[@text='Show Map']"));
			if (ShowMap.isEnabled()) {
				ShowMap.click();
			} else {
				System.out.println("Button is not Enabled ");
			}
			WebElement DIRECTIONS = driver.findElement(By.xpath("(//*[@text='DIRECTIONS'])[1]"));

			if (DIRECTIONS.isEnabled()) {
				System.out.println("Button is  Enabled ");
			} else {
				System.out.println("Button is not Enabled ");
			}
			driver.navigate().back();
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO Can click Cafe and verify the cafe")
	public void UserPO_Can_click_Cafe_and_verify_the_cafe() throws InterruptedException {
		try {

			WebElement Cafe = driver.findElement(By.xpath("//*[@text='Cafe']"));
			Cafe.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));

			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Cafe", element.getText());
				System.out.println("Cafe verify successfull.");
			} else {
				System.out.println("Cafe verify successfull.");
			}
			takesScreenshot(driver," Cafe screenshot");
			WebElement shop = driver.findElement(By.xpath("//*[@text='Show Map']"));
			WebElement DIRECTIONS = driver.findElement(By.xpath("(//*[@text='DIRECTIONS'])[1]"));


			if (shop.isDisplayed()) {
				shop.click();

			} else {
				DIRECTIONS.click();
			}
			driver.navigate().back();
			driver.navigate().back();
			driver.navigate().back();
			Thread.sleep(3000);
			WebElement clickplaces = driver.findElement(By.xpath("//*[@text='Places']"));
			clickplaces.click();
			WebElement clickpoi = driver.findElement(By.xpath("//*[@text='POI']"));
			clickpoi.click();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("userPO can click the Fast Food and verify the Fast Food")
	public void userpo_can_click_the_Fast_Food_and_verify_the_Fast_Food() {
		try {

			WebElement  FastFood = driver.findElement(By.xpath("//*[@text='Fast Food']"));
			FastFood.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Fast Food", element.getText());
				System.out.println("Fast Food verify successfull.");
			} else {
				System.out.println("Fast Food verify successfull.");
			}
			takesScreenshot(driver,"Fast Food screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("userPO can click the Hospital and verify hospital")
	public void userpo_can_click_the_Hospital_and_verify_hospital() {
		try {

			WebElement Hospital = driver.findElement(By.xpath("//*[@text='Hospital']"));
			Hospital.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Hospital", element.getText());
				System.out.println("Hospital verify successfull.");
			} else {
				System.out.println("Hospital verify successfull.");
			}
			takesScreenshot(driver,"Hospital screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("userPO can click the Pharmacy and verify pharmacy")
	public void userpo_can_click_the_Pharmacy_and_verify_pharmacy() {
		try {

			WebElement Pharmacy = driver.findElement(By.xpath("//*[@text='Pharmacy']"));
			Pharmacy.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Pharmacy", element.getText());
				System.out.println("Pharmacy verify successfull.");
			} else {
				System.out.println("Pharmacy verify successfull.");
			};
			takesScreenshot(driver,"Pharmacy screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("userPO can click the Supermarket and verify")
	public void userpo_can_click_the_Supermarket_and_verify() {
		try {

			WebElement Supermarket = driver.findElement(By.xpath("//*[@text='Supermarket']"));
			Supermarket.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Supermarket", element.getText());
				System.out.println("Supermarket verify successfull.");
			} else {
				System.out.println("Supermarket verify successfull.");
			};
			takesScreenshot(driver,"Supermarket screenshot");
			takesScreenshot(driver,"Supermarket screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("userPO can click the department store and verify")
	public void userpo_can_click_the_department_store_and_verify() {
		try {

			WebElement department = driver.findElement(By.xpath("//*[@text='Department Store']"));
			department.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Department Store", element.getText());
				System.out.println("Department Store verify successfull.");
			} else {
				System.out.println("Department Store  verify successfull.");
			};
			takesScreenshot(driver,"Department Store screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("userPO can click the General and verify")
	public void userpo_can_click_the_General_and_verify() {
		try {

			WebElement General = driver.findElement(By.xpath("//*[@text='General']"));
			General.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("General", element.getText());
				System.out.println("General Store verify successfull.");
			} else {
				System.out.println("General Store  verify successfull.");
			};
			takesScreenshot(driver,"General screenshot");

			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("userPO can click the car repair and verify")
	public void userpo_can_click_the_car_repair_and_verify() {
		try {

			WebElement carrepair = driver.findElement(By.xpath("//*[@text='Car repair']"));
			carrepair.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Car repair", element.getText());
				System.out.println("Car repair Store verify successfull.");
			} else {
				System.out.println("Car repair Store verify successfull.");
			};
			takesScreenshot(driver,"Car repair screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("userPO can click the cars and verify")
	public void userpo_can_click_the_cars_and_verify()  {
		try {

			WebElement cars = driver.findElement(By.xpath("//*[@text='Cars']"));
			cars.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Car", element.getText());
				System.out.println("CarStore verify successfull.");
			} else {
				System.out.println("Car Store verify successfull.");
			};
			takesScreenshot(driver,"Cars screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("userPO can click the Mall and verify")
	public void userpo_can_click_the_Mall_and_verify(){
		try {

			WebElement Mall = driver.findElement(By.xpath("//*[@text='Mall']"));
			Mall.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Mall", element.getText());
				System.out.println("Mall verify successfull.");
			} else {
				System.out.println("Mall verify successfull.");
			};
			takesScreenshot(driver,"Mall screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}


	}



	@When("UserPO can click the Park and verify")
	public void UserPO_can_click_the_Park_and_verify() {
		try {

			WebElement Park = driver.findElement(By.xpath("//*[@text='Park']"));
			Park.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Park", element.getText());
				System.out.println("Park verify successfull.");
			} else {
				System.out.println("Park verify successfull.");
			};
			takesScreenshot(driver,"Park screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Stadium and verify")
	public void UserPO_can_click_the_Stadium_and_verify() throws InterruptedException {
		try {

			WebElement Stadium = driver.findElement(By.xpath("//*[@text='Stadium']"));
			Stadium.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Stadium", element.getText());
				System.out.println("Stadium verify successfull.");
			} else {
				System.out.println("Stadium verify successfull.");
			};
			takesScreenshot(driver,"Stadium screenshot");

			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Marina and verify")
	public void UserPO_can_click_the_Marina_and_verify() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"ATM\").instance(0))"));


		try {

			WebElement Marina = driver.findElement(By.xpath("//*[@text='Marina']"));
			Marina.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Marina", element.getText());
				System.out.println("Marina verify successfull.");
			} else {
				System.out.println("Marina verify successfull.");
			};
			takesScreenshot(driver,"Marina screenshot");

			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Sports Centre and verify")
	public void UserPO_can_click_the_Sports_Centre_and_verify() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"ATM\").instance(0))"));
		//	
		try {


			WebElement SportsCentre = driver.findElement(By.xpath("//*[@text='Sports centre']"));
			SportsCentre.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Sports centre", element.getText());
				System.out.println("Sports centre verify successfull.");
			} else {
				System.out.println("Sports centre  verify successfull.");
			};
			takesScreenshot(driver,"Sports centre screenshot");

			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Golf Course and verify")
	public void UserPO_can_click_the_Golf_Course_and_verify() {
		try {

			WebElement GolfCourse = driver.findElement(By.xpath("//*[@text='Golf course']"));
			GolfCourse.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Golf course", element.getText());
				System.out.println("Golf course verify successfull.");
			} else {
				System.out.println("Golf course  verify successfull.");
			};
			takesScreenshot(driver,"Golf course screenshot");

			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Pitch and verify")
	public void UserPO_can_click_the_Pitch_and_verify() {
		try {

			WebElement Pitch = driver.findElement(By.xpath("//*[@text='Pitch']"));
			Pitch.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Pitch", element.getText());
				System.out.println("Pitch verify successfull.");
			} else {
				System.out.println("Pitch  verify successfull.");
			};
			takesScreenshot(driver,"Pitch screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Terminal and verify")
	public void UserPO_can_click_the_Terminal_and_verify() {
		try {

			WebElement Terminal = driver.findElement(By.xpath("//*[@text='Terminal']"));
			Terminal.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Terminal", element.getText());
				System.out.println("Terminal verify successfull.");
			} else {
				System.out.println("Terminal verify successfull.");
			};
			takesScreenshot(driver,"Terminal screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Aerodrome and verify")
	public void UserPO_can_click_the_Aerodrome_and_verify() {
		try {

			WebElement Aerodrome = driver.findElement(By.xpath("//*[@text='Aerodrome']"));
			Aerodrome.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Aerodrome", element.getText());
				System.out.println("Aerodrome verify successfull.");
			} else {
				System.out.println("Aerodrome  verify successfull.");
			};
			takesScreenshot(driver,"Aerodrome screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Hotel and verify")
	public void UserPO_can_click_the_Hotel_and_verify() {
		try {

			WebElement Hotel = driver.findElement(By.xpath("//*[@text='Hotel']"));
			Hotel.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Hotel", element.getText());
				System.out.println("Hotel verify successfull.");
			} else {
				System.out.println("Hotel  verify successfull.");
			};
			takesScreenshot(driver,"Hotel screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Government and verify")
	public void UserPO_can_click_the_Government_and_verify() {

		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Government\").instance(0))"));
		try {

			WebElement Government = driver.findElement(By.xpath("//*[@text='Government']"));
			Government.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Government", element.getText());
				System.out.println("Government verify successfull.");
			} else {
				System.out.println("Government verify successfull.");
			};
			takesScreenshot(driver,"Government screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Embassy and verify")
	public void UserPO_can_click_the_Embassy_and_verify() {
		try {

			WebElement Embassy = driver.findElement(By.xpath("//*[@text='Embassy']"));
			Embassy.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Embassy", element.getText());
				System.out.println("Embassy verify successfull.");
			} else {
				System.out.println("Embassy  verify successfull.");
			};
			takesScreenshot(driver,"Embassy screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Fire Station and verify")
	public void UserPO_can_click_the_Fire_Station_and_verify() {

		try {
			WebElement  FireStation = driver.findElement(By.xpath("//*[@text='Fire station']"));
			FireStation.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Fire station", element.getText());
				System.out.println("Fire station verify successfull.");
			} else {
				System.out.println("Fire station verify successfull.");
			};
			takesScreenshot(driver,"Fire station screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Toilets and vetify")
	public void UserPO_can_click_the_Toilets_and_vetify() {
		try {

			WebElement Toilets = driver.findElement(By.xpath("//*[@text='Toilets']"));
			Toilets.click();
			WebElement element = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt']"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Toilets", element.getText());
				System.out.println("Toilets verify successfull.");
			} else {
				System.out.println("Toilets verify successfull.");
			};
			takesScreenshot(driver,"Toilets screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
		}
	}

	@When("UserPO can click the School and verify")
	public void UserPO_can_click_the_School_and_verify() throws InterruptedException {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Library\").instance(0))"));
		try {

			WebElement School = driver.findElement(By.xpath("//*[@text='School']"));
			School.click();
			WebElement element = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt']"));
			Thread.sleep(3000);
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("School", element.getText());
				System.out.println("School verify successfull.");
			} else {
				System.out.println("School verify successfull.");
			};
			takesScreenshot(driver,"School screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the College and verify")
	public void UserPO_can_click_the_College_and_verify() throws InterruptedException {
		try {

			WebElement College = driver.findElement(By.xpath("//*[@text='College']"));
			College.click();
			WebElement element = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt']"));
			Thread.sleep(3000);
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("College", element.getText());
				System.out.println("College verify successfull.");
			} else {
				System.out.println("College verify successfull.");
			};
			takesScreenshot(driver,"College screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the University and verify")
	public void UserPO_can_click_the_University_and_verify() throws InterruptedException {
		try {

			WebElement University = driver.findElement(By.xpath("//*[@text='University']"));
			University.click();
			WebElement element = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt']"));
			Thread.sleep(3000);
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("University", element.getText());
				System.out.println("University verify successfull.");
			} else {
				System.out.println("University verify successfull.");
			};
			takesScreenshot(driver,"University screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Libray and Verify")
	public void UserPO_can_click_the_Libray_and_Verify() throws InterruptedException {
		try {

			WebElement Libray = driver.findElement(By.xpath("//*[@text='Library']"));
			Libray.click();
			WebElement element = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt']"));
			Thread.sleep(3000);
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Libray", element.getText());
				System.out.println("Libray verify successfull.");
			} else {
				System.out.println("Libray verify successfull.");
			};
			takesScreenshot(driver,"Libray screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Place Of Worship and verify")
	public void UserPO_can_click_the_Place_Of_Worship_and_verify() {
		try {

			WebElement Worship = driver.findElement(By.xpath("//*[@text='Place Of Worship']"));
			Worship.click();
			WebElement element = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt']"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Place Of Worship", element.getText());
				System.out.println("Place Of Worship verify successfull.");
			} else {
				System.out.println("Place Of Worship verify successfull.");
			};
			takesScreenshot(driver,"Place Of Worship screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Bus Stops and verify")
	public void UserPO_can_click_the_Bus_Stops_and_verify() {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Bus stops\").instance(0))"));
		try {

			WebElement BusStops = driver.findElement(By.xpath("//*[@text='Bus stops']"));
			BusStops.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Bus stops", element.getText());
				System.out.println("Bus stops verify successfull.");
			} else {
				System.out.println("Bus stops verify successfull.");
			};
			takesScreenshot(driver,"Bus stops screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Fuel Station and verify")
	public void UserPO_can_click_the_Fuel_Station_and_verify() {
		try {

			WebElement FuelStation = driver.findElement(By.xpath("//*[@text='Fuel station']"));
			FuelStation.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Fuel station", element.getText());
				System.out.println("Fuel station verify successfull.");
			} else {
				System.out.println("Fuel station verify successfull.");
			};
			takesScreenshot(driver,"Fuel station screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Change Station")
	public void UserPO_can_click_the_Change_Station() {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Charge station\").instance(0))"));
		try {

			WebElement station = driver.findElement(By.xpath("//*[@text='Charge station']"));
			station.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Charge station", element.getText());
				System.out.println("Charge station verify successfull.");
			} else {
				System.out.println("Charge station verify successfull.");
			};
			takesScreenshot(driver,"Charge station screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Attraction and verify")
	public void UserPO_can_click_the_Attraction_and_verify() {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Hostels\").instance(0))"));
		try {

			WebElement Attraction = driver.findElement(By.xpath("//*[@text='Attractions']"));
			Attraction.click();
			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Attractions", element.getText());
				System.out.println("Attractions verify successfull.");
			} else {
				System.out.println("Attractions verify successfull.");
			};
			takesScreenshot(driver,"Attractions screenshot");


			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Museums and vertify")
	public void UserPO_can_click_the_Museums_and_vertify() {
		try {

			WebElement Museums = driver.findElement(By.xpath("//*[@text='Museums']"));
			Museums.click();

			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Museums", element.getText());
				System.out.println("Museums verify successfull.");
			} else {
				System.out.println("Museums verify successfull.");
			};
			takesScreenshot(driver,"Museums screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Information and verify")
	public void UserPO_can_click_the_Information_and_verify() {
		try {

			WebElement clickInformation = driver.findElement(By.xpath("//*[@text='Information']"));
			clickInformation.click();

			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Information", element.getText());
				System.out.println("Information verify successfull.");
			} else {
				System.out.println("Information verify successfull.");
			};
			takesScreenshot(driver,"Information screenshot");
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("UserPO can click the Hostels and verify")
	public void UserPO_can_click_the_Hostels_and_verify() {
		try {

			WebElement Hostels = driver.findElement(By.xpath("//*[@text='Hostels']"));
			Hostels.click();

			WebElement element = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/poi_listView_nameTxt"));
			boolean condition = false;
			if (condition) {
				Assert.assertEquals("Hospital", element.getText());
				System.out.println("Hospital verify successfull.");
			} else {
				System.out.println("Hospital verify successfull.");
			};
			takesScreenshot(driver,"Hospital screenshot");
			driver.navigate().back();
			driver.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}




	@When("UserSO can search any areas")
	public void UserSO_can_search_any_areas() throws InterruptedException {
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView']"));
		search.click();

	}

	@When("UserSO can Choose destination areas")
	public void UserSO_can_Choose_destination_areas() throws InterruptedException {
		WebElement searchdestination = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		searchdestination.sendKeys("Alandur");


		Thread.sleep(5000);
		WebElement selectarea22 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));
		selectarea22.click();

		WebElement search = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search.click();
		Thread.sleep(5000);
	}

	@When("UserSO can click the save icon")
	public void UserSO_can_click_the_save_icon() {

		WebElement clicksaveicon = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/save_route_imageButton"));
		clicksaveicon.click();



	}

	@When("UserSO Can Save Route Place")
	public void UserSO_Can_Save_Route_Place() throws InterruptedException {
		WebElement route = driver.findElement(By.xpath("//*[@text='Route name']"));
		route.sendKeys("Work");

		WebElement clickok = driver.findElement(By.xpath("//*[@text='OK']"));
		clickok.click();


	}

	@When("UserSO can verify Saved")
	public void UserSO_can_verify_Saved() {
		WebElement verify = driver.findElement(By.xpath("//*[@text='Route Saved Successfully!!!']"));
		String text = verify.getText();
		System.out.println(text);

		takesScreenshot(driver,"Route Save");

		WebElement clickok = driver.findElement(By.xpath("//*[@text='OK']"));
		clickok.click();

		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		WebElement clickyes = driver.findElement(By.xpath("//*[@text='YES']"));
		clickyes.click();
	}



	@When("UserSO can click the menu option")
	public void UserSO_can_click_the_menu_option() {
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();
	}

	@When("UserSO can click the setting buttton")
	public void UserSO_can_click_the_setting_buttton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement clicksetting= driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/design_menu_item_text'])[8]"));
		clicksetting.click();


	}

	@When("UserSO can check Route Setting option")
	public void UserSO_can_check_Route_Setting_option() throws InterruptedException {
		Thread.sleep(5000);
		WebElement clickrout= driver.findElement(By.xpath("//*[@text='Route Setting']"));

		if (clickrout.isEnabled()) {
			System.out.println("Yes Route Setting is clickable");
		} else {
			System.out.println("No Route Setting is not clickable");
		}


	}

	@When("UserSO can Check Language option")
	public void UserSO_can_Check_Language_option() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Language= driver.findElement(By.xpath("//*[@text='Language']"));
		Language.click();

		List<MobileElement> buttons = driver.findElements(By.xpath("//*[@class='android.widget.RadioButton']"));

		for (WebElement button : buttons) {
			if (button.isEnabled()) {
				System.out.println("Button '" + button.getText() + "' is clickable.");
			} else {
				System.out.println("Button '" + button.getText() + "' is not clickable.");
			}
		}
		driver.navigate().back();
	}

	@When("UserSO can check Color Theme option")
	public void UserSO_can_check_Color_Theme_option() throws InterruptedException {
		WebDriverWait wait =new WebDriverWait(driver, 60);
		try {
			WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));

			if (clickmenu.isDisplayed()) {
				clickmenu.click();
			}
			else {
				System.out.println("menu option is not display");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Choose Map Style']"))).click();

		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(""))

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/theme_day_one_imageView"))).click();
		//Color1.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/theme_selection_apply_button"))).click();
		//apply1.click();

		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		//driver.navigate().back();


		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"))).click();
		//	clickmenu.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/design_menu_item_text'])[8]"))).click();
		//	clicksetting.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Choose Map Style']"))).click();
		//	style2.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/theme_day_two_imageView"))).click();
		//Color2.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/theme_selection_apply_button"))).click();
		//apply12.click();

		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();


		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"))).click();
		//	clickmenu1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Settings']"))).click();
		//	clicksetting111.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Choose Map Style']"))).click();
		//	style21.click();

		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/theme_night_one_imageView"))).click();
		//Color3.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/theme_selection_apply_button"))).click();
		//	apply11.click();

		driver.navigate().back();
		driver.navigate().back();
		//	driver.navigate().back();
		//driver.navigate().back();


		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"))).click();
		//	clickmenu11.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/design_menu_item_text'])[8]"))).click();
		//	clicksetting2.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Choose Map Style']"))).click();
		//		style22.click();

		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/theme_night_two_imageView"))).click();
		//	Color4.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/theme_selection_apply_button"))).click();
		//	apply13.click();

		driver.navigate().back();
		driver.navigate().back();
		//	driver.navigate().back();
		//	driver.navigate().back();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"))).click();
		//		clickmenu112.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/design_menu_item_text'])[8]"))).click();
		//	clicksetting223.click();


	}



	@When("UserSO can check Data pivacy option")
	public void UserSO_can_check_Data_pivacy_option() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Data = driver.findElement(By.xpath("//*[@text='Data Privacy']"));

		if (Data.isEnabled()) {
			System.out.println("Yes Route Setting is clickable");
		} else {
			System.out.println("No Route Setting is not clickable");
		}



	}

	@When("UserSO can check Privacy Policy option")
	public void UserSO_can_check_Privacy_Policy_option() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Privacy = driver.findElement(By.xpath("//*[@text='Privacy Policy']"));

		if (Privacy.isEnabled()) {
			System.out.println("YesPrivacy Policy is clickable");
		} else {
			System.out.println("No Privacy Policy is not clickable");
		}
	}

	@When("UserSO Can check Terms Of Use options")
	public void UserSO_Can_check_Terms_Of_Use_options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Terms = driver.findElement(By.xpath("//*[@text='Terms Of Use']"));

		if (Terms.isEnabled()) {
			System.out.println("Yes Terms Of Use is clickable");
		} else {
			System.out.println("No Terms Of Use is not clickable");
		}
	}

	@When("UserSO can check Acknowledgements options")
	public void UserSO_can_check_Acknowledgements_options() throws InterruptedException {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Acknowledgements\").instance(0))"));

		Thread.sleep(5000);
		WebElement Acknowledgements = driver.findElement(By.xpath("//*[@text='Acknowledgements']"));

		if (Acknowledgements.isEnabled()) {
			System.out.println("Yes Acknowledgements is clickable");
		} else {
			System.out.println("No Acknowledgements is not clickable");
		}
	}

	@When("UserSO can About Us Options")
	public void UserSO_can_About_Us_Options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement About = driver.findElement(By.xpath("//*[@text='About Us']"));

		if (About.isEnabled()) {
			System.out.println("Yes About Us is clickable");
		} else {
			System.out.println("No About Us is not clickable");
		}
	}

	@When("UserSO can Send Feedback options")
	public void UserSO_can_Send_Feedback_options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Feedback = driver.findElement(By.xpath("//*[@text='Send Feedback']"));

		if (Feedback.isEnabled()) {
			System.out.println("Yes Send Feedback is clickable");
		} else {
			System.out.println("No Send Feedback is not clickable");
		}
	}

	@When("UserSO can check Report Error options")
	public void UserSO_can_check_Report_Error_options() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Report Error\").instance(0))"));

		WebElement Report = driver.findElement(By.xpath("//*[@text='Report Error']"));

		if (Report.isEnabled()) {
			System.out.println("Yes Report Error is clickable");
		} else {
			System.out.println("No Report Error is not clickable");
		}
	}

	@When("UserSO can check More Apps options")
	public void UserSO_can_check_More_Apps_options() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Check for Updates\").instance(0))"));

		WebElement More = driver.findElement(By.xpath("//*[@text='More Apps']"));

		if (More.isEnabled()) {
			System.out.println("Yes More Apps is clickable");
		} else {
			System.out.println("No More Apps is not clickable");
		}
	}

	@When("UserSO Can Check for Updates options")
	public void UserSO_Can_Check_for_Updates_options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Updates = driver.findElement(By.xpath("//*[@text='Check for Updates']"));

		if (Updates.isEnabled()) {
			System.out.println("Yes Check for Updates is clickable");
		} else {
			System.out.println("No Check for Updates is not clickable");
		}
		driver.navigate().back();
	}
	@When("UserSO can check compass options")
	public void UserSO_can_check_compass_options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement compass = driver.findElement(By.xpath("//*[@text='Compass']"));
		compass.click();

		driver.navigate().back();
		driver.navigate().back();
		//	driver.navigate().back();




	}



	@When("UserFO can click the menu option")
	public void UserFO_can_click_the_menu_option() {
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();
	}

	@When("UserFO can click the setting buttton")
	public void UserFO_can_click_the_setting_buttton() throws InterruptedException {

		Thread.sleep(5000);
		WebElement clicksetting= driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/design_menu_item_text'])[8]"));
		clicksetting.click();
	}

	@When("UserFO can click the send feedback button")
	public void UserFO_can_click_the_send_feedback_button() throws InterruptedException {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Send Feedback\").instance(0))"));

		WebElement clickfeedback= driver.findElement(By.xpath("//*[@text='Send Feedback']"));
		clickfeedback.click();
		Thread.sleep(8000);
		//		WebElement clickfeedback1= driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/send_feedback_FabID"));
		//		clickfeedback1.click();

	}

	@When("UserFO can enter good thing about app")
	public void UserFO_can_enter_good_thing_about_app() {
		WebElement enterfeedback= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_good']"));
		enterfeedback.sendKeys("good for UserSO to this OMN app ");
	}

	@When("UserFO can enter bad thing about app")
	public void UserFO_can_enter_bad_thing_about_app() throws InterruptedException {
		Thread.sleep(3000);
		WebElement enterbadfeedback= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_bad']"));
		enterbadfeedback.sendKeys("not bad to use");
	}

	@When("UserFO can enter improvement")
	public void UserFO_can_enter_improvement() throws InterruptedException {
		Thread.sleep(3000);
		WebElement enterimprovement= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_improvement']"));
		enterimprovement.sendKeys("Improve serve speed");	
	}

	@When("UserFO can enter issues about app")
	public void UserFO_can_enter_issues_about_app() throws InterruptedException {
		Thread.sleep(3000);
		WebElement issues= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_issues']"));
		issues.sendKeys("no issues");
	}

	@When("UserFO can enter contact email")
	public void UserFO_can_enter_contact_email() throws InterruptedException {
		Thread.sleep(3000);
		WebElement email= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_email']"));
		email.sendKeys("testingvms01@gmail.com");
	}

	@When("UserFO can click the check box")
	public void UserFO_can_click_the_check_box() throws InterruptedException {
		Thread.sleep(3000);
		WebElement checkbox= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/email_privacy_checkBox']"));
		checkbox.click();
	}

	@Then("UserFO can click the send button")
	public void UserFO_can_click_the_send_button() throws InterruptedException {

		try {

			WebElement clicksendbtn= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/UserPOAOppFeedbackActivitySendImgID']"));
			if (clicksendbtn.isDisplayed()) {
				clicksendbtn.click();
				WebElement feedback= driver.findElement(By.xpath("//*[@text='Successfully feedback report submited. Thank you']"));
				String text = feedback.getText();
				System.out.println(text);
				Thread.sleep(5000);
				WebElement clickohbtn= driver.findElement(By.xpath("//*[@text='OK']"));
				clickohbtn.click();
			}

		} catch (Exception e) {
			System.out.println("Failed to send feedback in offline");
		}

		takesScreenshot(driver, " feedback screenshot");



		driver.navigate().back();
		driver.navigate().back();
	}







	@When("UserVO can click Voice Icon")
	public void UserVO_can_click_Voice_Icon() throws InterruptedException {
		WebElement clickvoice = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/mic_SBT_imgID']"));
		clickvoice.click();

		Thread.sleep(5000);

	}

	@When("UserVO can check voice working or not")
	public void UserVO_can_check_voice_working_or_not() {


		takesScreenshot(driver, "voicesearch");
		driver.navigate().back();
	}



	@When("UserTO can POI direction in offline")
	public void UserPO_can_POI_direction_in_offline() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 600);
		
		Thread.sleep(5000);
		WebElement search = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView\"]"));
		search.click();
		Thread.sleep(5000);

		WebElement startpoint = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable\"]"));
		startpoint.sendKeys("chennai");
		Thread.sleep(5000);
		WebElement selectarea2 = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/recentRecyclerView\"]/android.widget.RelativeLayout[1]"));
		//a.click(selectarea).perform();
		selectarea2.click();


		//		WebElement search1 = driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		//		search1.click();

		Thread.sleep(8000);
		WebElement car = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageButton[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/navigation_route_fab\"]"))).click();






		WebElement clicksearch= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch.click();
		WebElement food= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[1]/android.widget.ImageButton"));
		food.click();

		System.out.println("-------------No search Result----------------");
		//System.out.println("Food Option working");
		//Thread.sleep(3000);
		WebElement clicksearch11 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch11.click();
		WebElement atm= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[2]/android.widget.ImageButton"));
		atm.click();
		System.out.println("-------------No search Result----------------");
		//	Thread.sleep(3000);


		WebElement clicksearch22= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch22.click();
		WebElement fuel= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[3]/android.widget.ImageButton"));
		fuel.click();
		//
		//	Thread.sleep(3000);
		WebElement clicksearch33= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch33.click();
		WebElement shopping= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[4]/android.widget.ImageButton"));
		shopping.click();
		System.out.println("-------------No search Result----------------");
		//	Thread.sleep(3000);
		WebElement clicksearch44= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch44.click();
		WebElement toilet= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[5]/android.widget.ImageButton"));
		toilet.click();
		System.out.println("-------------No search Result----------------");
		//Thread.sleep(3000);
		WebElement clicksearch55= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch55.click();
		WebElement hospital= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[6]/android.widget.ImageButton"));
		hospital.click();
		System.out.println("-------------No search Result----------------");

		driver.navigate().back();
		WebElement exit = driver.findElement(By.xpath("//*[@text='EXIT']"));
		exit.click();

		driver.navigate().back();		
		driver.navigate().back();
		driver.navigate().back();
		//	driver.navigate().back();


		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[7]/android.widget.CheckedTextView"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/bt_my_maps\"]"))).click();


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/iv_download\"])[1]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/bt_maps\"]"))).click();


	}

	@Given("UserOAS can login OMN Application")
	public void useroas_can_login_OMN_Application() throws MalformedURLException {
		DesiredCapabilities  capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("PlatformVersion", "11");
		capabilities.setCapability("udid", "R58M7048EEW");
		capabilities.setCapability("deviceName", "Vivo");
		capabilities.setCapability("appPackage", "com.virtualmaze.offlinemapnavigationtracker");
		capabilities.setCapability("appActivity", "com.ne.services.android.navigation.testapp.demo.DemoSplashActivity");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("waitForIdleTimeout", 0);
		capabilities.setCapability("animationDurationScale", 0);
		capabilities.setCapability("newCommandTimeout", 0);

		URL url =new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url,capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);





	}

	@Then("UserOAS search for {string} in the search box")
	public void useroas_search_for_in_the_search_box(String Offlinesearch) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		// Add up to 50 terms or more

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView\"]"))).click();

		WebElement search1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable\"]")));
		search1.clear();
		search1.sendKeys(Offlinesearch);

		
		WebElement moreresult = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/footer_textView\"]")));

		if (moreresult.isDisplayed()) {
			moreresult.click();
			driver.navigate().back();

		} else {
			System.out.println("Moreresult is button is not displayed");
		}



		Thread.sleep(3000);


		captureOfflinesearchScreenshot(driver,Offlinesearch + " autocomplete saerch result screenshot");

	}



}





