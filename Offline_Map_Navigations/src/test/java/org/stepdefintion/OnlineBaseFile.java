package org.stepdefintion;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OnlineBaseFile extends BaseClass{

	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;

	@Given("User can first select the  language")
	public void user_can_first_select_the_language() throws MalformedURLException {
		DesiredCapabilities  capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("PlatformVersion", "12");
		capabilities.setCapability("udid", "a9f27783");
		capabilities.setCapability("deviceName", "Vivo");
		capabilities.setCapability("appPackage", "com.virtualmaze.offlinemapnavigationtracker");
		capabilities.setCapability("appActivity", "com.ne.services.android.navigation.testapp.demo.DemoSplashActivity");
		capabilities.setCapability("waitForIdleTimeout", 0);
		capabilities.setCapability("animationDurationScale", 0);
		capabilities.setCapability("newCommandTimeout", 0);

		URL url =new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,capabilities);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	

	}

	@When("User can click  apply button")
	public void user_can_click_apply_button() throws InterruptedException {
		WebElement ClickApply = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button\r\n"));
		ClickApply.click();
		Thread.sleep(10000);
	}

	@When("User can click next the option")
	public void user_can_click_next_the_option() throws InterruptedException {
		Thread.sleep(3000);	
		for (int i = 1; i < 5; i++) {
			WebElement continues = driver.findElement(By.xpath("//*[@class='android.widget.Button']"));
			continues.click();
			Thread.sleep(3000);	
		}
	}

	@When("User can click  continues button")
	public void user_can_click_continues_button() throws InterruptedException {
		
		try {
			WebElement continues = driver.findElement(By.xpath("//*[@text='Continue']"));
			continues.click();
		} catch (Exception e) {
			System.out.println("Failed to click on the element");
			e.printStackTrace();
		}
		//		WebElement continues = driver.findElement(By.xpath	("//*[@text='Continue']"));
		//		continues.click();

	}

	@When("User Can click  I will do it Later")
	public void user_Can_click_I_will_do_it_Later() throws InterruptedException {
		Thread.sleep(3000);
		int numTries = 10; 
		WebElement clicklater = driver.findElement(By.xpath("//*[@text='Thanks I will do it Later']"));

		for (int i = 0; i < numTries; i++) {
			try {
				clicklater.click();
				break; // 
			} catch (WebDriverException e) {
				System.out.println("Attempt #" + (i+1) + " failed. Retrying...");
			}
		}
	}

	@When("user can click  allow button")
	public void user_can_click_allow_button() throws InterruptedException {
		//Thread.sleep(3000);
		Actions a=new Actions(driver);
		WebElement clickAllow = driver.findElement(By.xpath	("//*[@text='ALLOW']"));
		a.click(clickAllow).perform();
		//clickAllow.click();
		WebElement clickusingapp = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]"));
		clickusingapp.click();
	}

	@When("User can download the offline bundle")
	public void user_can_download_the_offline_bundle() throws InterruptedException {


		//		WebElement skip = driver.findElement(By.xpath("//*[@text='Skip']"));
		//		skip.click();
		WebElement download = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.ImageView"));
		download.click();

		WebElement clickdownloadbtn = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]"));
		clickdownloadbtn.click();

	}

	@When("User can click the Get Started button")
	public void user_can_click_the_Get_Started_button() throws InterruptedException {

		WebElement continuess = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button"));
		continuess.click(); 
		WebElement clickStartbtn = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button"));
		clickStartbtn.click();
	}

	@When("User can search any destination any areas {string}")
	public void user_can_search_any_destination_any_areas(String locations) throws InterruptedException {

		WebElement search = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
		search.click();
		WebElement searchtext = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText"));
		searchtext.sendKeys(locations);
		Thread.sleep(3000);
		WebElement clickTheni = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView"));
		clickTheni.click();
		WebElement clickcarbtn = driver.findElement(By.xpath	("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ImageButton"));
		clickcarbtn.click();
	}

	@When("User can verify the destination")
	public void user_can_verify_the_destination() throws InterruptedException, IOException {
		Thread.sleep(8000);
		takesScreenshot(driver, "Initialisation Online");
		
	}


}
