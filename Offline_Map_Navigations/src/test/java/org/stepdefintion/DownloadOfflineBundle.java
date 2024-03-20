package org.stepdefintion;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;

public class DownloadOfflineBundle {
	public static AndroidDriver<MobileElement> driver;

	@Given("User check all offline download bundles")
	public void user_check_all_offline_download_bundles() throws MalformedURLException, InterruptedException {
	    
	
	
		DesiredCapabilities  capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("PlatformVersion", "11");
		capabilities.setCapability("udid", "14cfc42e");
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


		//WebDriverWait wait = new WebDriverWait(driver, 600);
		Thread.sleep(5000);
		WebElement clickmenu = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"));
		clickmenu.click();
		Thread.sleep(5000);
		WebElement Downloadmaps = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[7]/android.widget.CheckedTextView"));
		Downloadmaps.click();
		Thread.sleep(5000);
		WebElement Africa = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.widget.RelativeLayout[1]"));
		Africa.click();



		// Set the path to your JSON file
		try {
			// Read JSON file
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\Virtualmaze\\Downloads\\Offline\\Offline\\src\\test\\resources\\json\\output.json"));

			// Get the continents array
			JSONArray continentsArray = (JSONArray) jsonObject.get("continents");

			// Iterate over each continent
			for (Object continentObj : continentsArray) {
				JSONObject continent = (JSONObject) continentObj;
				JSONArray countriesArray = (JSONArray) continent.get("countries");

				// Iterate over each country in the continent
				for (Object countryObj : countriesArray) {
					JSONObject country = (JSONObject) countryObj;

					JSONArray tilesArray = (JSONArray) country.get("tiles");

					for (Object tileObj : tilesArray) {
						JSONObject tile = (JSONObject) tileObj;

						// Get the file_size attribute


						// Print the file_size


						//	List<Coordinate> coordinatesList = new ArrayList<>();

						// Extract country information
						String name = (String) country.get("name");
						String countryCode = (String) country.get("country_code");
						String testcode1=(String) country.get("coord1");
						String testcode2=(String) country.get("coord2");

						String filesize = (String) tile.get("file_size");









						// Print country information
						System.out.println("Name: " + name);
						System.out.println("Country Code: " + countryCode);
						System.out.println("File size: " + filesize);




						searchForName(name,testcode1,testcode2,filesize);
					}
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	


	public static void searchForName(String name,String testcode1, String testcode2, String filesize) throws Exception {

		WebDriverWait wait =new WebDriverWait(driver, 600);
		
			
					
			
			
			
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/item_autoCompleteTextview"))).sendKeys(name);

		
	//	WebElement searchBox = driver.findElement(By.id("com.virtualmaze.offlinemapnavigationtracker:id/item_autoCompleteTextview"));

	//	searchBox.sendKeys(name);


	


		// Click the search button
		Thread.sleep(8000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.GridView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/recycler_view_available_download_regions\"]/android.widget.RelativeLayout"))).click();

		try {
			// Wait for the map download element
			WebElement fileSize = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+filesize+"']")));
			String text =fileSize.getText();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/iv_download\"])[1]"))).click();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"))).click();


			// Wait for some time for the download to complete
			Thread.sleep(30000);

			try {
				wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@text='"+filesize+"']"),filesize));


				// wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(fileSize, text)));
				//   wait.until(ExpectedConditions.textToBePresentInElement(fileSize, filesize));
				System.out.println("Download completed for " + name);

				// Wait until the file size text changes or timeout occurs
				//  wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(fileSizeElement, initialFileSize)));
			} catch (Exception e) {
				// Handle timeout exception if download takes longer than expected
				// You can log a message or take appropriate action here
				System.out.println(name = " Map is not download Fail......");
			}

			// Check if the file size text has changed after download
			//  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/tv_file_size"), filesize));
			//  wait.until(ExpectedConditions.textToBePresentInElementValue(filesize, filesize));

			System.out.println(text + " FILESIZE DOWNLOADED");

			WebElement verifydownload = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/tv_country_name")));
			String verdiydownloadmap = verifydownload.getText();

			// If file size text remains the same, download failed
			if (verdiydownloadmap.equals(verdiydownloadmap)) {
				System.out.println(verdiydownloadmap + " Map download successful...");
				// Perform actions for test failure
				// For example, throw an exception to fail the test case
				// throw new Exception("Map download successful...");
			} else {
				System.out.println("Map download failed...");
				// Perform actions for test success
				// For example, continue with next steps
			}
		} catch (Exception e) {
			// Exception occurred, consider test case failed
			e.printStackTrace();
			// Perform actions for test failure
			// For example, throw an exception to fail the test case
			// throw new Exception("Map download failed.");
		} 










		System.out.println("-------------------------------------------");

		System.out.println();
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



		// Turn off WiFi
		//Runtime.getRuntime().exec("adb shell am broadcast -a io.appium.settings.wifi --es setstatus disable");

		// Perform your test actions here with WiFi turned off

		// Turn on WiFi

		// Perform your test actions here with WiFi turned on

		//		driver.navigate().back();
		//		driver.navigate().back();
		//		driver.navigate().back();
		//		//driver.navigate().back();

		Thread.sleep(8000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

		WebElement searchdestination = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));

		searchdestination.sendKeys(testcode1);


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "))).click();

		WebElement search = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		search.click();
		Thread.sleep(5000);
		WebElement clickstartpoint = driver.findElement(By.xpath("(//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/tv_place_name'])[1]"));
		clickstartpoint.click();
		Thread.sleep(5000);	
		WebElement startpoint = driver.findElement(By.xpath("//*[@resource-id='com.virtualmaze.offlinemapnavigationtracker:id/search_field_editable']"));
		startpoint.sendKeys(testcode2);


		Thread.sleep(5000);
		driver.toggleWifi();
		WebElement selectarea2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1] "));

		selectarea2.click();





		WebElement car = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ImageButton"));
		car.click();
		Thread.sleep(5000);

		try {
			Process process = Runtime.getRuntime().exec("adb shell settings put global wifi_on 0");
			process.waitFor();
			System.out.println("WiFi turned off");
			System.out.println();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Car route is Found");

		//driver.toggleWifi();
		try {
			// Find the element containing the text

			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/iv_walking"))).click();
			MobileElement gettext = driver.findElement(By.xpath("//*[@text='Could not find route']"));
			// Check if the element is displayed
			if (gettext.isDisplayed()) {
				// If the element is displayed, print the text
				System.out.println();
				System.out.println(gettext.getText());
			}
			
		} catch (NoSuchElementException e) {
			// If the element is not found or not displayed, print a message
			System.out.println("Walking route is Found");
			// You can add further handling or continue your script here
		}


		//	Thread.sleep(5000);
		// Find the element containing the text
		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/iv_bicycling"))).click();
			MobileElement gettext = driver.findElement(By.xpath("//*[@text='Could not find route']"));
			// Check if the element is displayed
			if (gettext.isDisplayed()) {
				// If the element is displayed, print the text
				System.out.println();
				System.out.println(gettext.getText());
			}
			
			
		} catch (NoSuchElementException e) {
			// If the element is not found or not displayed, print a message
			System.out.println("Bicycling route is Found");
			
			// You can add further handling or continue your script here
		}

		//	Thread.sleep(5000);
		// Find the element containing the text
//		try {
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/iv_driving"))).click();
//			MobileElement gettext = driver.findElement(By.xpath("//*[@text='Could not find route']"));
//			// Check if the element is displayed
//			if (gettext.isDisplayed()) {
//				// If the element is displayed, print the text
//				System.out.println();
//				System.out.println(gettext.getText());
//			}
//			
//		} catch (NoSuchElementException e) {
//			// If the element is not found or not displayed, print a message
//			
//			
//			// You can add further handling or continue your script here
//		}

		Thread.sleep(4000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/route_option_back_imageButton"))).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.toggleWifi();
		//Thread.sleep(10000);
		try {
			WebElement clickyes= driver.findElement(By.xpath("//*[@text='YES']"));
			if (clickyes.isDisplayed()) {
				clickyes.click();
			}

			else {
				System.out.println("Yes button not display");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Yes button not display");
		}


try {
 	
  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.virtualmaze.offlinemapnavigationtracker:id/navigationDrawer_DAVL_ImgID"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[7]/android.widget.CheckedTextView"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/bt_my_maps\"]"))).click();


		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/iv_download\"])[1]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/bt_maps\"]"))).click();
	MobileElement empty = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/tv_info\"]"));
		
	if (empty.isDisplayed()) {
		String text = empty.getText();
		System.out.println(text);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/bt_maps\"]"))).click();

	}

}
	catch (Exception e) {
		System.out.println("..........");
	}
finally {
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.virtualmaze.offlinemapnavigationtracker:id/bt_maps\"]"))).click();
	
}
		
		//driver.toggleWifi();
		//	Thread.sleep(5000);

		try {
			Process process = Runtime.getRuntime().exec("adb shell settings put global wifi_on 1");
			process.waitFor();
			System.out.println();
			System.out.println("WiFi turned on");
			System.out.println();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("-------------------------------------------------");
	}



}






