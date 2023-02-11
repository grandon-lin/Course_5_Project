package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProductDetails {

	AndroidDriver<MobileElement> driver;
	
	public ProductDetails(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
	}
	
	public void addToCart() throws InterruptedException
	{
		driver.findElement(By.id("com.walmart.android:id/quantitystepper_root")).click();
		Thread.sleep(3000);
		try
		{
			MobileElement declineBtn = driver.findElement(By.id("com.walmart.android:id/item_aos_decline"));
			declineBtn.click();
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	public void viewCart()
	{
		driver.findElement(By.id("com.walmart.android:id/item_pac_view_cart_cta")).click();
	}
}
