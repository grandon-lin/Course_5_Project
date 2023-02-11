package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	AndroidDriver<MobileElement> driver;
	
	public HomePage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
	}
	
	@SuppressWarnings("deprecation")
	public void search(String productName) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.walmart.android:id/search_view")));
		
		driver.findElement(By.id("com.walmart.android:id/search_view")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("com.walmart.android:id/search_view")).sendKeys(productName);
		
		driver.getKeyboard().pressKey(Keys.ENTER);
	}
	
	public List<MobileElement> getResult()
	{
		List<MobileElement> searchResult = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id=\"com.walmart.android:id/product_tile_list_view\"]"));
		return searchResult;
	}
	
	public void chooseProduct(int nth)
	{
		getResult().get(nth).click();
	}
}
