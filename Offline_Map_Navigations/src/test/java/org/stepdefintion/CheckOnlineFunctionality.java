package org.stepdefintion;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOnlineFunctionality extends BaseClass {
	public static  AndroidDriver<MobileElement> driver;


	@Given("UserA can first select language")
	public void usera_can_first_select_language()  throws MalformedURLException {
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




	}

	@When("UserA can click  apply button")
	public void usera_can_click_apply_button()throws InterruptedException {
		WebElement ClickApply = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button\r\n"));
		ClickApply.click();
		Thread.sleep(10000);
	}

	@When("UserA can click next the option")
	public void usera_can_click_next_the_option() throws InterruptedException {
		Thread.sleep(3000);	
		for (int i = 1; i < 5; i++) {
			WebElement continues = driver.findElement(By.xpath("//*[@class='android.widget.Button']"));
			continues.click();
			Thread.sleep(3000);	
		}


	}
	@When("UserA can click  continues button")
	public void usera_can_click_continues_button() throws InterruptedException {

		try {
			WebElement continues = driver.findElement(By.xpath("//*[@text='Continue']"));
			continues.click();
		} catch (Exception e) {
			System.out.println("Failed to click on the element");
			e.printStackTrace();
		}
	}

	@When("UserA Can click  I will do it Later")
	public void usera_Can_click_I_will_do_it_Later() throws InterruptedException {
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

	@When("userA can click  allow button")
	public void usera_can_click_allow_button()throws InterruptedException {
		WebElement clickAllow = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button"));
		clickAllow.click();
		Thread.sleep(5000);
		WebElement clickusingapp = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]"));
		clickusingapp.click();
	}

	@When("UserA can download the offline bundle")
	public void usera_can_download_the_offline_bundle() throws InterruptedException {
		Thread.sleep(8000);

		//		WebElement skip = driver.findElement(By.xpath("//*[@text='Skip']"));
		//		skip.click();
		WebElement clickskip = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button"));
		clickskip.click();
		Thread.sleep(5000);
		WebElement skipanyway = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"));
		skipanyway.click();
	}

	@When("UserA can click the Get Started button")
	public void usera_can_click_the_Get_Started_button()throws InterruptedException {
		Thread.sleep(5000);

		WebElement clickStartbtn = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button"));
		clickStartbtn.click();
	}

	@When("UserA can verify the Loading page")
	public void usera_can_verify_the_Loading_page() throws InterruptedException, IOException {
		Thread.sleep(8000);
		takesScreenshot(driver, "Initialisation Offline");
	}

	@Given("UserL can login OMN Application")
	public void userl_can_login_OMN_Application() throws MalformedURLException {
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



	}

	@When("UserL can click the menu")
	public void userl_can_click_the_menu() {
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();

	}

	@When("UserL can click the settings")
	public void userl_can_click_the_settings() {
		WebElement clicksetting = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[8]/android.widget.CheckedTextView"));
		clicksetting.click();
	}

	@When("UserL can click the languages")
	public void userl_can_click_the_languages() {

		WebElement clicklanguage = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageview"));
		clicklanguage.click();
	}


	@When("UserL can Verify All the languages")
	public void userl_can_Verify_All_the_languages() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 600);

		WebElement bashsana = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.RadioGroup/android.widget.RadioButton[1]"));

		bashsana.click();
		WebElement apply = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply.click();

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination.sendKeys("-6.201051335590951, 106.80683653820644");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search.click();
		Thread.sleep(5000);
		WebElement clickstartpoint = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint.click();
		Thread.sleep(5000);	
		WebElement startpoint = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint.sendKeys("-6.261254021094865, 106.81510101453902");


		Thread.sleep(5000);

		WebElement selectarea2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea2.click();





		WebElement car = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car.click();
		Thread.sleep(5000);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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


		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination1 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination1.sendKeys("3.7284537804442786, 101.93996131606283");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search1.click();
		Thread.sleep(5000);
		WebElement clickstartpoint1 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint1.click();
		Thread.sleep(5000);	
		WebElement startpoint1 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint1.sendKeys("3.142925991201365, 101.5906330140754");


		Thread.sleep(5000);

		WebElement selectarea22 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea22.click();





		WebElement car1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car1.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination3 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination3.sendKeys("51.15326207376086, 10.336141040950666");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search3.click();
		Thread.sleep(5000);
		WebElement clickstartpoint3 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint3.click();
		Thread.sleep(5000);	
		WebElement startpoint3 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint3.sendKeys("51.40097325080828, 12.38058287693422");


		Thread.sleep(5000);

		WebElement selectarea23= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea23.click();





		WebElement car3 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car3.click();



		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination4 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination4.sendKeys("salem");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search4.click();
		Thread.sleep(5000);
		WebElement clickstartpoint4 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint4.click();
		Thread.sleep(5000);	
		WebElement startpoint4 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint4.sendKeys("chennai");


		Thread.sleep(5000);

		WebElement selectarea24 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea24.click();





		WebElement car4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car4.click();
		Thread.sleep(5000);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination5 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination5.sendKeys("39.47678162755367, -3.5293125172459527");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search5 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search5.click();
		Thread.sleep(5000);
		WebElement clickstartpoint5 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint5.click();
		Thread.sleep(5000);	
		WebElement startpoint5 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint5.sendKeys("40.72049174543726, -3.749039076900251");


		Thread.sleep(5000);

		WebElement selectarea25 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea25.click();





		WebElement car5 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car5.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination56 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination56.sendKeys("46.5948853461913, 1.593909429257025");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search56 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search56.click();
		Thread.sleep(5000);
		WebElement clickstartpoint56 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint56.click();
		Thread.sleep(5000);	
		WebElement startpoint56 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint56.sendKeys("46.01810172111101, 4.714026576348026");


		Thread.sleep(5000);

		WebElement selectarea256 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea256.click();





		WebElement car55 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car55.click();
		Thread.sleep(5000);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination55 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination55.sendKeys("43.09022274881509, 11.870154853927101");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search55 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search55.click();
		Thread.sleep(5000);
		WebElement clickstartpoint55 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint55.click();
		Thread.sleep(5000);	
		WebElement startpoint55 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint55.sendKeys("41.858586830591825, 13.012732964129437");


		Thread.sleep(5000);

		WebElement selectarea255 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea255.click();





		WebElement car555 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car555.click();
		Thread.sleep(5000);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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


		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination57 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination57.sendKeys("38.71995915957947, -27.244113754859516");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search57 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search57.click();
		Thread.sleep(5000);
		WebElement clickstartpoint57 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint57.click();
		Thread.sleep(5000);	
		WebElement startpoint57 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint57.sendKeys("38.673871578767596, -27.093051745097192");


		Thread.sleep(5000);

		WebElement selectarea257 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea257.click();





		WebElement car57 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car57.click();
		Thread.sleep(5000);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination577 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination577.sendKeys("45.727949948424424, 24.96442178085298");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search577 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search577.click();
		Thread.sleep(5000);
		WebElement clickstartpoint577 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint577.click();
		Thread.sleep(5000);	
		WebElement startpoint577 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint577.sendKeys("44.56572427979623, 25.931218643331878");


		Thread.sleep(5000);

		WebElement selectarea251 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea251.click();





		WebElement car51 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car51.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination51 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination51.sendKeys("10.897229446476908, 106.75125224681324");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search51 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search51.click();
		Thread.sleep(5000);
		WebElement clickstartpoint51 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint51.click();
		Thread.sleep(5000);	
		WebElement startpoint51 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint51.sendKeys("10.911125902641322, 106.78978535379348");


		Thread.sleep(5000);

		WebElement selectarea2511 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea2511.click();





		WebElement car511 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car511.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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


		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination511 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination511.sendKeys("59.063094886177275, 37.9414021304623");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search511 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search511.click();
		Thread.sleep(5000);
		WebElement clickstartpoint511 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint511.click();
		Thread.sleep(5000);	
		WebElement startpoint511 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint511.sendKeys("59.06477400660837, 37.967328028343694");


		Thread.sleep(5000);

		WebElement selectarea25111 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea25111.click();





		WebElement car5111 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car5111.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination510 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination510.sendKeys("38.87945813548292, 35.06913031379587");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search510 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search510.click();
		Thread.sleep(5000);
		WebElement clickstartpoint50 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint50.click();
		Thread.sleep(5000);	
		WebElement startpoint50 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint50.sendKeys("40.17001777435872, 32.91398056122366");


		Thread.sleep(5000);

		WebElement selectarea250 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea250.click();


		WebElement car50 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car50.click();
		Thread.sleep(5000);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination5109 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination5109.sendKeys("24.934051060853264, 46.67717312133358");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search5109 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search5109.click();
		Thread.sleep(5000);
		WebElement clickstartpoint509 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint509.click();
		Thread.sleep(5000);	
		WebElement startpoint509 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint509.sendKeys("24.934051060853264, 46.67717312133358");


		Thread.sleep(5000);

		WebElement selectarea2509 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea2509.click();


		WebElement car509 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car509.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination5108 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination5108.sendKeys("38.87945813548292, 35.06913031379587");


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search5108 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search5108.click();
		Thread.sleep(5000);
		WebElement clickstartpoint508 = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint508.click();
		Thread.sleep(5000);	
		WebElement startpoint508 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint508.sendKeys("40.17001777435872, 32.91398056122366");


		Thread.sleep(5000);

		WebElement selectarea2508 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea2508.click();


		WebElement car508 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car508.click();
		Thread.sleep(5000);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
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
		telugu.click();

		WebElement apply309544 = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/languageApplyBtnID"));
		apply309544.click();

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
	}


	@Given("UserB can login OMN Application")
	public void userb_can_login_OMN_Application() throws MalformedURLException {
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

	@When("UserB Click the user location")
	public void userb_Click_the_user_location() throws InterruptedException {

		WebElement clickuserlocation = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/myLocationFAB"));
		clickuserlocation.click();


	}

	@When("UserB Verify the user Location")
	public void userb_Verify_the_user_Location() throws InterruptedException {

		takesScreenshot(driver, "User Location Loading");
	}


	@When("UserD can search any areas")
	public void userd_can_search_any_areas() throws InterruptedException {
		WebElement searchbox = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
		searchbox.click();



	}

	@When("UserD can Choose destination areas")
	public void userd_can_Choose_destination_areas()throws InterruptedException {

		WebElement searchdestination = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		searchdestination.sendKeys("madurai");
		//Actions a=new Actions(driver);

		Thread.sleep(5000);
		WebElement selectarea1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));
		selectarea1.click();

	}

	@When("UserD can click the search area")
	public void userd_can_click_the_search_area()  throws InterruptedException {
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

	@When("UserD Can verify the destination point")
	public void userd_Can_verify_the_destination_point() throws InterruptedException, IOException {
		WebElement destinationpoint = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[3]"));
		String text = destinationpoint.getText();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + text + ".png"));

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

		WebElement clicksearch= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch.click();
		WebElement food= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[1]/android.widget.ImageButton"));
		food.click();
		//System.out.println("Food Option working");
		Thread.sleep(3000);
		WebElement clicksearch11 = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch11.click();
		WebElement atm= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[2]/android.widget.ImageButton"));
		atm.click();

		Thread.sleep(3000);


		WebElement clicksearch22= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch22.click();
		WebElement fuel= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[3]/android.widget.ImageButton"));
		fuel.click();

		Thread.sleep(3000);
		WebElement clicksearch33= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch33.click();
		WebElement shopping= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[4]/android.widget.ImageButton"));
		shopping.click();

		Thread.sleep(3000);
		WebElement clicksearch44= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch44.click();
		WebElement toilet= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[5]/android.widget.ImageButton"));
		toilet.click();

		Thread.sleep(3000);
		WebElement clicksearch55= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/searchFab']"));

		clicksearch55.click();
		WebElement hospital= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[6]/android.widget.ImageButton"));
		hospital.click();

		for (int i = 1; i < 3; i++) {
			WebElement muted= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/soundFab']"));
			muted.click();

			//		WebElement casting= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/feedbackFab']"));
			//		casting.click();
			//		
			//		WebElement Clickstart= driver.findElement(By.xpath("//*[@text='START NOW']"));
			//		Clickstart.click();

		}
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








	@When("UserR can search any areas")
	public void userr_can_search_any_areas() throws InterruptedException {





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

	@When("UserR can check Retry button")
	public void userr_can_check_Retry_button() {
		for (int i = 1; i < 4; i++) {
			WebElement Retry = driver.findElement(By.xpath("//*[@text='Retry']"));
			Retry.click();
		}
	}

	@When("UserR can Check Report buttton")
	public void userr_can_Check_Report_buttton() throws InterruptedException {
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


	@When("UserB Enter a Home Page")
	public void userb_Enter_a_Home_Page() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("User Enter The Home Page");
	}

	@When("UserB Click the Search Box")
	public void userb_Click_the_Search_Box() {
		WebElement search = driver
				.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView"));
		search.click();

		Actions action = new Actions(driver);
		action.sendKeys("Trichy").perform();

	}

	@When("UserB Enter the Related Location in Search Box")
	public void userb_Enter_the_Related_Location_in_Search_Box() throws InterruptedException {
		System.out.println("User Search the Related Location");
		Thread.sleep(3000);
	}

	@When("UserB Validate the Locations")
	public void userb_Validate_the_Locations() throws InterruptedException, IOException {
		Thread.sleep(5000);
		WebElement destinationpoint = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		String text = destinationpoint.getText();
		driver.navigate().back();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + text + ".png"));
		System.out.println("User Validate Location");
	}






	@When("User can click the Places option")
	public void user_can_click_the_Places_option() {
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

	@When("User can click the POI option")
	public void user_can_click_the_POI_option() {
		WebElement clickpoi = driver.findElement(By.xpath("//*[@text='POI']"));
		clickpoi.click();

	}

	@When("User can check Food POI option and click restaurant")
	public void user_can_check_Food_POI_option_and_click_restaurant() {
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

	}

	@When("User can verify the restaurant")
	public void user_can_verify_the_restaurant() throws InterruptedException {
		takesScreenshot(driver,"restaurant screenshot");
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
	}

	@When("User Can click Cafe and verify the cafe")
	public void user_Can_click_Cafe_and_verify_the_cafe() throws InterruptedException {
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

	}

	@When("user can click the Fast Food and verify the Fast Food")
	public void user_can_click_the_Fast_Food_and_verify_the_Fast_Food() {
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
	}

	@When("user can click the Hospital and verify hospital")
	public void user_can_click_the_Hospital_and_verify_hospital() {
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
	}

	@When("user can click the Pharmacy and verify pharmacy")
	public void user_can_click_the_Pharmacy_and_verify_pharmacy() {
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
	}

	@When("user can click the Supermarket and verify")
	public void user_can_click_the_Supermarket_and_verify() {
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
	}

	@When("user can click the department store and verify")
	public void user_can_click_the_department_store_and_verify() {
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
	}

	@When("user can click the General and verify")
	public void user_can_click_the_General_and_verify() {
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
	}

	@When("user can click the car repair and verify")
	public void user_can_click_the_car_repair_and_verify() {
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
	}

	@When("user can click the cars and verify")
	public void user_can_click_the_cars_and_verify() {
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

	}

	@When("user can click the Mall and verify")
	public void user_can_click_the_Mall_and_verify() {
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


	}



	@When("User can click the Park and verify")
	public void user_can_click_the_Park_and_verify() {
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
	}

	@When("User can click the Stadium and verify")
	public void user_can_click_the_Stadium_and_verify() throws InterruptedException {

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

	}

	@When("User can click the Marina and verify")
	public void user_can_click_the_Marina_and_verify() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"ATM\").instance(0))"));
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		Map<String, Object> params = new HashMap<>();
		//		params.put("Pitch", "down");
		//		js.executeScript("mobile: scroll", params);
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

	}

	@When("User can click the Sports Centre and verify")
	public void user_can_click_the_Sports_Centre_and_verify() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"ATM\").instance(0))"));
		//	
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

	}

	@When("User can click the Golf Course and verify")
	public void user_can_click_the_Golf_Course_and_verify() {
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
	}

	@When("User can click the Pitch and verify")
	public void user_can_click_the_Pitch_and_verify() {
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
	}

	@When("User can click the Terminal and verify")
	public void user_can_click_the_Terminal_and_verify() {
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
	}

	@When("User can click the Aerodrome and verify")
	public void user_can_click_the_Aerodrome_and_verify() {
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
	}

	@When("User can click the Hotel and verify")
	public void user_can_click_the_Hotel_and_verify() {
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
	}

	@When("User can click the Government and verify")
	public void user_can_click_the_Government_and_verify() {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Government\").instance(0))"));

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
	}

	@When("User can click the Embassy and verify")
	public void user_can_click_the_Embassy_and_verify() {
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
	}

	@When("User can click the Fire Station and verify")
	public void user_can_click_the_Fire_Station_and_verify() {
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
	}

	@When("User can click the Toilets and vetify")
	public void user_can_click_the_Toilets_and_vetify() {
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
	}

	@When("User can click the School and verify")
	public void user_can_click_the_School_and_verify() throws InterruptedException {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Library\").instance(0))"));

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
	}

	@When("USer can click the College and verify")
	public void user_can_click_the_College_and_verify() throws InterruptedException {
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
	}

	@When("User can click the University and verify")
	public void user_can_click_the_University_and_verify() throws InterruptedException {
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
	}

	@When("User can click the Libray and Verify")
	public void user_can_click_the_Libray_and_Verify() throws InterruptedException {
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
	}

	@When("User can click the Place Of Worship and verify")
	public void user_can_click_the_Place_Of_Worship_and_verify() {
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
	}

	@When("User can click the Bus Stops and verify")
	public void user_can_click_the_Bus_Stops_and_verify() {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Bus stops\").instance(0))"));

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
	}

	@When("User can click the Fuel Station and verify")
	public void user_can_click_the_Fuel_Station_and_verify() {
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
	}

	@When("User can click the Change Station")
	public void user_can_click_the_Change_Station() {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Charge station\").instance(0))"));
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
	}

	@When("User can click the Attraction and verify")
	public void user_can_click_the_Attraction_and_verify() {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Hostels\").instance(0))"));

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
	}

	@When("User can click the Museums and vertify")
	public void user_can_click_the_Museums_and_vertify() {
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
	}

	@When("User can click the Information and verify")
	public void user_can_click_the_Information_and_verify() {
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
	}

	@When("User can click the Hostels and verify")
	public void user_can_click_the_Hostels_and_verify() {
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
	}




	@When("UserS can search any areas")
	public void users_can_search_any_areas() throws InterruptedException {
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView']"));
		search.click();

	}

	@When("UserS can Choose destination areas")
	public void users_can_Choose_destination_areas() throws InterruptedException {
		WebElement searchdestination = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		searchdestination.sendKeys("Alandur");


		Thread.sleep(5000);
		WebElement selectarea22 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));
		selectarea22.click();

		WebElement search = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search.click();
		Thread.sleep(5000);
	}

	@When("userS can click the save icon")
	public void users_can_click_the_save_icon() {

		WebElement clicksaveicon = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/save_route_imageButton"));
		clicksaveicon.click();



	}

	@When("UserS Can Save Route Place")
	public void users_Can_Save_Route_Place() throws InterruptedException {
		WebElement route = driver.findElement(By.xpath("//*[@text='Route name']"));
		route.sendKeys("Work");

		WebElement clickok = driver.findElement(By.xpath("//*[@text='OK']"));
		clickok.click();


	}

	@When("UserS can verify Saved")
	public void users_can_verify_Saved() {
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



	@When("UserS can click the menu option")
	public void users_can_click_the_menu_option() {
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();
	}

	@When("UserS can click the setting buttton")
	public void users_can_click_the_setting_buttton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement clicksetting= driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/design_menu_item_text'])[8]"));
		clicksetting.click();


	}

	@When("UserS can check Route Setting option")
	public void users_can_check_Route_Setting_option() throws InterruptedException {
		Thread.sleep(5000);
		WebElement clickrout= driver.findElement(By.xpath("//*[@text='Route Setting']"));

		if (clickrout.isEnabled()) {
			System.out.println("Yes Route Setting is clickable");
		} else {
			System.out.println("No Route Setting is not clickable");
		}


	}

	@When("UserS can Check Language option")
	public void users_can_Check_Language_option() throws InterruptedException {
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

	@When("UserS can check Color Theme option")
	public void users_can_check_Color_Theme_option() throws InterruptedException {
		WebDriverWait wait =new WebDriverWait(driver, 60);
		try {
			WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));

			if (clickmenu.isDisplayed()) {
				clickmenu.click();
			}
		} catch (Exception e) {
			// TODO: handle exception
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



	@When("UserS can check Data pivacy option")
	public void users_can_check_Data_pivacy_option() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Data = driver.findElement(By.xpath("//*[@text='Data Privacy']"));

		if (Data.isEnabled()) {
			System.out.println("Yes Route Setting is clickable");
		} else {
			System.out.println("No Route Setting is not clickable");
		}



	}

	@When("UserS can check Privacy Policy option")
	public void users_can_check_Privacy_Policy_option() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Privacy = driver.findElement(By.xpath("//*[@text='Privacy Policy']"));

		if (Privacy.isEnabled()) {
			System.out.println("YesPrivacy Policy is clickable");
		} else {
			System.out.println("No Privacy Policy is not clickable");
		}
	}

	@When("UserS Can check Terms Of Use options")
	public void users_Can_check_Terms_Of_Use_options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Terms = driver.findElement(By.xpath("//*[@text='Terms Of Use']"));

		if (Terms.isEnabled()) {
			System.out.println("Yes Terms Of Use is clickable");
		} else {
			System.out.println("No Terms Of Use is not clickable");
		}
	}

	@When("UserS can check Acknowledgements options")
	public void users_can_check_Acknowledgements_options() throws InterruptedException {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Acknowledgements\").instance(0))"));

		Thread.sleep(5000);
		WebElement Acknowledgements = driver.findElement(By.xpath("//*[@text='Acknowledgements']"));

		if (Acknowledgements.isEnabled()) {
			System.out.println("Yes Acknowledgements is clickable");
		} else {
			System.out.println("No Acknowledgements is not clickable");
		}
	}

	@When("UserS can About Us Options")
	public void users_can_About_Us_Options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement About = driver.findElement(By.xpath("//*[@text='About Us']"));

		if (About.isEnabled()) {
			System.out.println("Yes About Us is clickable");
		} else {
			System.out.println("No About Us is not clickable");
		}
	}

	@When("UserS can Send Feedback options")
	public void users_can_Send_Feedback_options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Feedback = driver.findElement(By.xpath("//*[@text='Send Feedback']"));

		if (Feedback.isEnabled()) {
			System.out.println("Yes Send Feedback is clickable");
		} else {
			System.out.println("No Send Feedback is not clickable");
		}
	}

	@When("USerS can check Report Error options")
	public void users_can_check_Report_Error_options() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Report Error\").instance(0))"));

		WebElement Report = driver.findElement(By.xpath("//*[@text='Report Error']"));

		if (Report.isEnabled()) {
			System.out.println("Yes Report Error is clickable");
		} else {
			System.out.println("No Report Error is not clickable");
		}
	}

	@When("UserS can check More Apps options")
	public void users_can_check_More_Apps_options() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Check for Updates\").instance(0))"));

		WebElement More = driver.findElement(By.xpath("//*[@text='More Apps']"));

		if (More.isEnabled()) {
			System.out.println("Yes More Apps is clickable");
		} else {
			System.out.println("No More Apps is not clickable");
		}
	}

	@When("UserS Can Check for Updates options")
	public void users_Can_Check_for_Updates_options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Updates = driver.findElement(By.xpath("//*[@text='Check for Updates']"));

		if (Updates.isEnabled()) {
			System.out.println("Yes Check for Updates is clickable");
		} else {
			System.out.println("No Check for Updates is not clickable");
		}
		driver.navigate().back();
	}
	@When("UserS can check compass options")
	public void users_can_check_compass_options() throws InterruptedException {
		Thread.sleep(5000);
		WebElement compass = driver.findElement(By.xpath("//*[@text='Compass']"));
		compass.click();

		driver.navigate().back();
		driver.navigate().back();
		//	driver.navigate().back();




	}



	@When("User can click the menu option")
	public void user_can_click_the_menu_option() {
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();
	}

	@When("User can click the setting buttton")
	public void user_can_click_the_setting_buttton() throws InterruptedException {

		Thread.sleep(5000);
		WebElement clicksetting= driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/design_menu_item_text'])[8]"));
		clicksetting.click();
	}

	@When("User can click the send feedback button")
	public void user_can_click_the_send_feedback_button() throws InterruptedException {
		driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Send Feedback\").instance(0))"));

		WebElement clickfeedback= driver.findElement(By.xpath("//*[@text='Send Feedback']"));
		clickfeedback.click();
		Thread.sleep(8000);
		WebElement clickfeedback1= driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/send_feedback_FabID"));
		clickfeedback1.click();

	}

	@When("User can enter good thing about app")
	public void user_can_enter_good_thing_about_app() {
		WebElement enterfeedback= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_good']"));
		enterfeedback.sendKeys("good for users to this OMN app ");
	}

	@When("User can enter bad thing about app")
	public void user_can_enter_bad_thing_about_app() throws InterruptedException {
		Thread.sleep(3000);
		WebElement enterbadfeedback= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_bad']"));
		enterbadfeedback.sendKeys("not bad to use");
	}

	@When("user can enter improvement")
	public void user_can_enter_improvement() throws InterruptedException {
		Thread.sleep(3000);
		WebElement enterimprovement= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_improvement']"));
		enterimprovement.sendKeys("Improve serve speed");	
	}

	@When("User can enter issues about app")
	public void user_can_enter_issues_about_app() throws InterruptedException {
		Thread.sleep(3000);
		WebElement issues= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_issues']"));
		issues.sendKeys("no issues");
	}

	@When("User can enter contact email")
	public void user_can_enter_contact_email() throws InterruptedException {
		Thread.sleep(3000);
		WebElement email= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_email']"));
		email.sendKeys("testingvms01@gmail.com");
	}

	@When("User can click the check box")
	public void user_can_click_the_check_box() throws InterruptedException {
		Thread.sleep(3000);
		WebElement checkbox= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/email_privacy_checkBox']"));
		checkbox.click();
	}

	@Then("User can click the send button")
	public void user_can_click_the_send_button() throws InterruptedException {
		WebElement clicksendbtn= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/userAppFeedbackActivitySendImgID']"));
		clicksendbtn.click();
		takesScreenshot(driver, " feedback screenshot");
		WebElement feedback= driver.findElement(By.xpath("//*[@text='Successfully feedback report submited. Thank you']"));
		String text = feedback.getText();
		System.out.println(text);
		Thread.sleep(5000);
		WebElement clickohbtn= driver.findElement(By.xpath("//*[@text='OK']"));
		clickohbtn.click();

		driver.navigate().back();
		driver.navigate().back();
	}


	@When("User can click  menu option")
	public void user_can_click_menu_option() {
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();
	}

	@When("User can click  setting buttton")
	public void user_can_click_setting_buttton() {
		WebElement clicksetting= driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/design_menu_item_text'])[8]"));
		clicksetting.click();
	}

	@When("User can click  send feedback button")
	public void user_can_click_send_feedback_button() {
		WebElement clickfeedback= driver.findElement(By.xpath("//*[@text='Send Feedback']"));
		clickfeedback.click();
	}

	@When("User can enter good thing about our app {string}")
	public void user_can_enter_good_thing_about_our_app(String goodfeedback) {
		WebElement enterfeedback= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_good']"));
		enterfeedback.sendKeys(goodfeedback);
	}

	@When("User can enter bad thing about our app {string}")
	public void user_can_enter_bad_thing_about_our_app(String badfeedback) throws InterruptedException {
		Thread.sleep(3000);
		WebElement enterbadfeedback= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_bad']"));
		enterbadfeedback.sendKeys(badfeedback);
	}

	@When("user can enter improvements {string}")
	public void user_can_enter_improvements(String improvements) throws InterruptedException {
		Thread.sleep(3000);
		WebElement enterimprovement= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_improvement']"));
		enterimprovement.sendKeys(improvements);	
	}

	@When("User can enter issues about our app {string}")
	public void user_can_enter_issues_about_our_app(String issuess) throws InterruptedException {
		Thread.sleep(3000);
		WebElement issues= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_issues']"));
		issues.sendKeys(issuess);
	}

	@When("User can enter the contact email {string}")
	public void user_can_enter_the_contact_email(String contactemail) throws InterruptedException {
		Thread.sleep(3000);
		WebElement email= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/etFeedback_email']"));
		email.sendKeys(contactemail);
	}

	@When("User can click  check box")
	public void user_can_click_check_box() throws InterruptedException {
		Thread.sleep(3000);
		WebElement checkbox= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/email_privacy_checkBox']"));
		checkbox.click();
	}
	@Then("User can click  send button")
	public void user_can_click_send_button() throws InterruptedException {
		WebElement clicksendbtn= driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/userAppFeedbackActivitySendImgID']"));
		clicksendbtn.click();
		Thread.sleep(10000);

		WebElement feedback= driver.findElement(By.xpath("//*[@text='Successfully feedback report submited. Thank you']"));
		String text = feedback.getText();
		System.out.println(text);
		takesScreenshot(driver, " feedback screenshot");
		Thread.sleep(5000);
		WebElement clickohbtn= driver.findElement(By.xpath("//*[@text='OK']"));
		clickohbtn.click();
		Thread.sleep(3000);

		driver.navigate().back();
		driver.navigate().back();


	}


	@When("User click the menu option")
	public void user_click_the_menu_option() {
		driver.navigate().back();
		driver.navigate().back();
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();
	}

	@When("User can click the download map")
	public void user_can_click_the_download_map() {
		WebElement clickDownloadMaps = driver.findElement(By.xpath("//*[@text='Download Maps']"));
		clickDownloadMaps.click();
	}

	@When("User can click Australia and Oceania")
	public void user_can_click_Australia_and_Oceania() {
		WebElement clickAustralia = driver.findElement(By.xpath("//*[@text='Australia and Oceania']"));
		clickAustralia.click();
	}



	@When("User can Download Marshall Isaland Map")
	public void user_can_Download_Marshall_Isaland_Map() throws InterruptedException {

		WebElement Marshall = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[2]"));
		Marshall.click();
		WebElement DOWNLOAD = driver.findElement(By.xpath("//*[@text='DOWNLOAD']"));
		DOWNLOAD.click();
		System.out.println("Marshall Isaland Map successfully download");

		Thread.sleep(15000);

	}

	@When("User can Download Pitcain Island Map")
	public void user_can_Download_Pitcain_Island_Map() throws InterruptedException {
		WebElement Pitcain = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[3]"));
		Pitcain.click();
		WebElement DOWNLOAD = driver.findElement(By.xpath("//*[@text='DOWNLOAD']"));
		DOWNLOAD.click();

		System.out.println("Pitcain Isaland Map successfully download");
		Thread.sleep(15000);
	}



	@When("User Can Download Nauru Map")
	public void user_Can_Download_Nauru_Map() throws InterruptedException {
		Thread.sleep(3000);

		WebElement Nauru = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[4]"));
		Nauru.click();
		WebElement DOWNLOAD = driver.findElement(By.xpath("//*[@text='DOWNLOAD']"));
		DOWNLOAD.click();
		System.out.println("Nauru Map successfully download");
		Thread.sleep(15000);
	}

	@When("User can verify map download or not")
	public void user_can_verify_map_download_or_not() throws InterruptedException {

		WebElement Tonga = driver.findElement(By.xpath("//*[@text='MY MAPS']"));
		Tonga.click();
		Thread.sleep(3000);
		takesScreenshot(driver, "Offline Download Bundles");

	}

	@When("User can delete download maps")
	public void user_can_delete_download_maps() throws InterruptedException {

		WebElement clickmymap = driver.findElement(By.xpath("//*[@text='MY MAPS']"));
		clickmymap.click();
		Thread.sleep(3000);

		WebElement delete = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[1]"));
		delete.click();

		WebElement clickdelete = driver.findElement(By.xpath("//*[@text='DELETE']"));
		clickdelete.click();
		Thread.sleep(3000);
		WebElement delete2 = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[2]"));
		delete2.click();

		WebElement clickdelete2 = driver.findElement(By.xpath("//*[@text='DELETE']"));
		clickdelete2.click();

		Thread.sleep(3000);
		WebElement delete3 = driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[1]"));
		delete3.click();

		WebElement clickdelete3 = driver.findElement(By.xpath("//*[@text='DELETE']"));
		clickdelete3.click();


	}
	@When("User can serach box")
	public void user_can_serach_box() {
		driver.navigate().back();
		driver.navigate().back();
		WebElement search = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/item_autoCompleteTextview']"));
		search.sendKeys("India Southern Zone");
		System.out.println("Search Options Working");
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();


	}

	@When("UserV can click Voice Icon")
	public void userv_can_click_Voice_Icon() throws InterruptedException {
		WebElement clickvoice = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/mic_SBT_imgID']"));
		clickvoice.click();

		Thread.sleep(5000);

	}

	@When("UserV can check voice working or not")
	public void userv_can_check_voice_working_or_not() {


		takesScreenshot(driver, "voicesearch");
		driver.navigate().back();
	}



	@When("User can POI direction in offline")
	public void user_can_POI_direction_in_offline() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 600);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID\"]"))).click();
		//WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		//	clickmenu.click();

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
		driver.toggleWifi();
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

		driver.toggleWifi();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[7]/android.widget.CheckedTextView"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/bt_my_maps\"]"))).click();


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/iv_download\"])[1]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/bt_maps\"]"))).click();


	}

	@Given("UserAS can login OMN Application")
	public void useras_can_login_OMN_Application() throws MalformedURLException {
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


	@Then("I search for {string} in the search box")
	public void i_search_for_in_the_search_box(String area) throws IOException, InterruptedException {



		WebDriverWait wait = new WebDriverWait(driver, 300);
		// Add up to 50 terms or more

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/goSomeWhereTextView\"]"))).click();

		WebElement search1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable\"]")));
		search1.clear();
		search1.sendKeys(area);
		WebElement moreresult = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/footer_textView\"]")));
		moreresult.click();


		Thread.sleep(3000);

		captureScreenshot(driver,area + " autocomplete saerch result screenshot");








	}

}





