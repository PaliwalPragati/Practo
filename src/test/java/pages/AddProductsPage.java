package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductsPage {
	WebDriver driver;
	public AddProductsPage(WebDriver driver) {
		this.driver=driver;
		
	}
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/div[4]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/button")
	WebElement AddProductPage;
	public void addProductAction() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", AddProductPage);
		
	}

}
