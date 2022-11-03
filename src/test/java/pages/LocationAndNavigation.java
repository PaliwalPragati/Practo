package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationAndNavigation {
    WebDriver driver;

    public LocationAndNavigation(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input")
    WebElement location;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[4]/div/div/div/div/div[3]/div/a")
    WebElement medicine;

    public void locAndNavAction(String loc) {
        location.sendKeys(loc, Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", medicine);
    }
}
