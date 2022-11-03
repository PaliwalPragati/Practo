package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/span/a")).click();
		
	}
	
	@FindBy(id="username")
	WebElement uName;
	
	@FindAll({
		@FindBy(id="password"),
		@FindBy(name="password")
	})
	WebElement pwd;
	
	@FindAll({
		@FindBy(id="login"),
		@FindBy(className="button"),
		@FindBy(name="login_button")
	})
	WebElement loginbtn;
	
	public void loginAction(String user,String pass) {
		uName.sendKeys(user);
		pwd.sendKeys(pass);
		loginbtn.click();
		
	}

}