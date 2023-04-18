package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
2. Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.
1. LoginTest
3. Write down the following test into ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully
* click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’
2. verifyTheErrorMessage
* click on the ‘Sign In’ link
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘Invalid email
or password.’
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        // Find SignIn link element and click
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        String expectedMessage = "Welcome Back!";
        WebElement actualTextElement= driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualMessage= actualTextElement.getText();

        Assert.assertEquals("Welcome Back! text displayed",expectedMessage,actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        // Find the SignIn link element and click
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        // Find Username field element and send username element
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("prime123@gmail.com");
        // find Password field element and send password element
        driver.findElement(By.xpath("//input[@name='user[password]']")).sendKeys("Prime123");
        // Find SignIn button element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement= driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage= actualTextElement.getText();

        Assert.assertEquals("Invalid email or password error message displayed",expectedMessage,actualMessage);
    }


    @After
    public void tearDown(){
        closeBrowser();
    }
}
