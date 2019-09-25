import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginVerificationPsitive {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        driver.findElement(By.id("closedIntro")).click();
        Thread.sleep(5000);

       //-----Find login button and press on it
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(3000);

        //-----Find login and password fields and fill them
        WebElement loginField = driver.findElement(By.id("logininput"));
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        loginField.click();
        Thread.sleep(5000);
        loginField.sendKeys("olga_mo_");
        passwordField.click();
        passwordField.sendKeys("Anna2019");

        //-----Find sign in button and press it
        driver.findElement(By.id("signinrequest")).click();
        Thread.sleep(3000);

        //-----Go to the HomePage Auth
        WebElement profileIcon = driver.findElement(By.id("profile"));

        //-----Check that we on the HomePage for authorized user
        System.out.println("We logged in: "
                + profileIcon.getAttribute("title").contains("olga_mo_"));
        driver.quit();
    }
}
