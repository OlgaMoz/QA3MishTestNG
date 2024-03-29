package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;
    public static final String LOGIN = "Olga";
    public static final String PASSWORD = "Olga1";
    @BeforeMethod
    public void initWebDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        driver.findElement(By.id("closedIntro")).click();
        Thread.sleep(5000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
