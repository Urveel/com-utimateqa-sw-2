package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = ("https://courses.ultimateqa.com/");

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();
    }

    @Test
    public void VerifyTheTextWelcomeBack() {

        WebElement secureArea = driver.findElement(By.className("page__heading"));
        System.out.println(secureArea.getText());
        Assert.assertEquals("Incorrect Login detail", "Welcome Back!", secureArea.getText());
    }

    @Test
    // verifyTheErrorMessage
    public void verifyTheErrorMessage() {
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        loginButton.click();

        // Enter invalid username
        //to find the element give the value of id
        WebElement emailField = driver.findElement(By.id("user[email]"));
        //sending email to email field element
        emailField.sendKeys("prime333@gmail.com");

        //Enter invalid
        //find the password field element
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        //sending password to password field element
        passwordField.sendKeys("patel123");

        // Click on submit button
        WebElement SubmitButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        SubmitButton.click();

        //Verify the error message ‘Invalid email or password.'
        WebElement secureArea = driver.findElement(By.className("form-error__list-item"));
        System.out.println(secureArea.getText());
        Assert.assertEquals("Incorrect Login detail", "Invalid email or password.", secureArea.getText());
    }
}
