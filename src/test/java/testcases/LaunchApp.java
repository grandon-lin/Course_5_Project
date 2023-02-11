package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import pages.HomePage;

public class LaunchApp {

	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void launchApplication() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.walmart.android");
		cap.setCapability("appActivity", "com.walmart.glass.integration.splash.SplashActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		startApp();
	}
	
	public void startApp()
	{
		if(isConfirmHumanDisplayed())
		{
			confirmHuman();
		}
	}
	
	public boolean isConfirmHumanDisplayed()
	{
		try
		{
			driver.findElement(By.id("pluqaNKTjPLGKeE"));
			return true;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
	
	public void confirmHuman()
	{
		TouchAction<?> ta = new TouchAction<>(driver);
		ta.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(driver.findElement(By.id("pluqaNKTjPLGKeE")))));
	}
}
