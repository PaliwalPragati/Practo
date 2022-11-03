package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage {
	WebDriver driver;
	public ViewCartPage(WebDriver driver) {
		this.driver=driver;
		
	}
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/div[2]/div/div[3]/div[2]/a/button")
	WebElement ViewCartPage;
	public void viewCartAction(String string) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ViewCartPage);
		
	}

}
