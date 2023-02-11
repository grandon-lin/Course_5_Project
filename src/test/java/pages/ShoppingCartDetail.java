package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ShoppingCartDetail {

	AndroidDriver<MobileElement> driver;
	
	public ShoppingCartDetail(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
	}
	
	public void continueToCheckout()
	{
		driver.findElement(By.id("com.walmart.android:id/cart_continue_to_checkout_button")).click();
	}
}
