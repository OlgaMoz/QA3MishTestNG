package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{




    @BeforeMethod
    public void initTests() throws InterruptedException {
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        System.out.println("HomePage - loginIcon exists, user unauthorized: " + loginIcon.getText().equals("Login"));
        loginIcon.click();
        Thread.sleep(3000);

    }
    @Test
    public void loginNegativeTest(){
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        driver.findElement(By.id("logininput")).sendKeys(LOGIN);
        driver.findElement(By.id("passwordinput")).sendKeys(PASSWORD);
        driver.findElement(By.id("signinrequest")).click();
        String message = driver.findElement(By.id("wrongloginorpassword")).getText();
        System.out.println("Message 'Wrong Authorization!' is visible: " + message.contains("Wrong Authorization!"));
        WebElement closeSignIn =driver.findElement(By.id("closedsignin"));
        closeSignIn.click();
        System.out.println("HomePage - loginIcon exists, user unauthorized: " + loginIcon.getText().equals("Login"));
    }

    @Test
    public void LoginExitByCancelTest(){
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        System.out.println("SignInButton exists: " + signInButton.getText().equals("Sign in"));
        WebElement closeSignIn =driver.findElement(By.id("closedsignin"));
        closeSignIn.click();
        System.out.println("HomePage - loginIcon exists: " + loginIcon.getText().equals("Login"));
    }
    @Test
    public void loginPositiveTest() throws InterruptedException {


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
    }


}
