package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetails;
import pages.ShoppingCartDetail;


public class SearchTest extends LaunchApp {

	@Test
	public void searchProduct() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.search("mobile");
		
		if(hp.getResult().size() > 0)
		{
			hp.chooseProduct(0);
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.walmart.android:id/quantitystepper_root")));
		ProductDetails pd = new ProductDetails(driver);
		pd.addToCart();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.walmart.android:id/item_pac_view_cart_cta")));
		pd.viewCart();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.walmart.android:id/cart_continue_to_checkout_button")));
		ShoppingCartDetail scd = new ShoppingCartDetail(driver);
		scd.continueToCheckout();
	}
	
}
