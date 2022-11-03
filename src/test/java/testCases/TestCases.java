package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.AddProductsPage;
import pages.LocationAndNavigation;
import pages.Login;
import pages.MedicineSearch;
import pages.ViewCartPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class TestCases {
    WebDriver driver;
    ExtentTest test;
    ExtentReports report;

    @Test(priority = 0)
    public void loginTest() {
        Login loginpg = PageFactory.initElements(driver, Login.class);
        loginpg.loginAction("7014346331", "pragati@12345");

        if (driver
                .findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/span/span[1]"))
                .getText().equalsIgnoreCase("Pragati Paliwal")) {
            test.log(Status.PASS, "Successfully logged in");
        } else {
            test.log(Status.FAIL, "Invalid login");
            Screenshot s = new AShot().takeScreenshot(driver);
            try {
                ImageIO.write(s.getImage(), "PNG",
                        new File("C:\\Users\\Administrator\\java\\ExtentReportsDemo\\target\\img1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.fail(
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    "C:\\Users\\Administrator\\java\\ExtentReportsDemo\\target\\img1.png")
                            .build());
        }
    }

    @Test(priority = 1)
    public void locAndNavTest() {
        LocationAndNavigation ln = PageFactory.initElements(driver, LocationAndNavigation.class);
        ln.locAndNavAction("Chennai");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div[1]/div[4]/div/div[2]/div[2]/div[1]/div/div[1]/div/div/a/div/img")));
        if (driver.getTitle().equalsIgnoreCase(
                "Buy Medicines,Health Products Online | India's Most Reliable Online Medical Store | Practo")) {
            test.log(Status.PASS, "Successfully navigated to medicines");
        } else {
            test.log(Status.FAIL, "Navigation failed");
            Screenshot s = new AShot().takeScreenshot(driver);
            try {
                ImageIO.write(s.getImage(), "PNG",
                        new File("C:\\Users\\Administrator\\java\\Practo\\target\\img2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.fail(
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    "C:\\Users\\Administrator\\java\\Practo\\target\\img2.png")
                            .build());
        }
    }

    @Test(priority = 2)
    public void medicineTest() {
        MedicineSearch med = PageFactory.initElements(driver, MedicineSearch.class);
        med.skinClickAction();
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        if (driver.getTitle().equalsIgnoreCase("Skin care Products: Buy Online at Best Prices in India | Practo")) {
            test.log(Status.PASS, "Successfully navigated to Skin care products");
        } else {
            test.log(Status.FAIL, "Navigation failed");
            Screenshot s = new AShot().takeScreenshot(driver);
            try {
                ImageIO.write(s.getImage(), "PNG",
                        new File("C:\\Users\\Administrator\\java\\Practo\\target\\img3.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.fail(
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    "C:\\Users\\Administrator\\java\\Practo\\target\\img3.png")
                            .build());
        }

        med.acneClickAction();
        if (driver.getTitle()
                .equalsIgnoreCase("Acne care Products: Buy Online at Best Prices/Offers in India | Practo")) {
            test.log(Status.PASS, "Successfully navigated to Acne care products");
        } else {
            test.log(Status.FAIL, "Navigation failed");
            Screenshot s = new AShot().takeScreenshot(driver);
            try {
                ImageIO.write(s.getImage(), "PNG",
                        new File("C:\\Users\\Administrator\\java\\Practo\\target\\img4.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.fail(
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    "C:\\Users\\Administrator\\java\\Practo\\target\\img4.png")
                            .build());
        }
    }

    @Test(priority = 3)
    public void addProductsTest() {
        AddProductsPage addProd = PageFactory.initElements(driver, AddProductsPage.class);
        addProd.addProductAction();

        if (driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[3]/div[2]/a/button/i/span")).getText()
                .equalsIgnoreCase("1")) {
            test.log(Status.PASS, "Successfully added products");
        } else {
            test.log(Status.FAIL, "Adding product failed");
            Screenshot s = new AShot().takeScreenshot(driver);
            try {
                ImageIO.write(s.getImage(), "PNG",
                        new File("C:\\Users\\Administrator\\java\\Practo\\target\\img5.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.fail(
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    "C:\\Users\\Administrator\\java\\Practo\\target\\img5.png")
                            .build());
        }
    }

    @Test(priority = 4)
    public void viewCartTest() {
        ViewCartPage viewCart = PageFactory.initElements(driver, ViewCartPage.class);
        viewCart.viewCartAction("Chennai");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/div[7]/a/button")));
        if (driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[7]/a/button")).getText()
                .equalsIgnoreCase("Checkout")) {
            test.log(Status.PASS, "Successfully viewed cart");
        } else {
            test.log(Status.FAIL, "View cart operation failed");
            Screenshot s = new AShot().takeScreenshot(driver);
            try {
                ImageIO.write(s.getImage(), "PNG",
                        new File("C:\\Users\\Administrator\\java\\Practo\\target\\img6.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.fail(
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    "C:\\Users\\Administrator\\java\\Practo\\target\\img6.png")
                            .build());
        }
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Pragati\\driver\\chromedriver102_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.practo.com");
        driver.manage().window().maximize();

        report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        report.attachReporter(spark);
        test = report.createTest("Practo");
    }

    @AfterTest
    public void afterTest() {
        report.flush();
        driver.quit();
    }

}