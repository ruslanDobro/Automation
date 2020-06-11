import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class YahooLogin extends TestBase {
    private static final String YAHOO_MAIL_LOGINPAGE_URL = "https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd";

    @BeforeSuite
    public void testSuiteSetup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        driver = new FirefoxDriver();

    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
//    Open yahoo mail page
//    Locate user name field
//    Enter Valid user id
//    Click Next button
//    Locate password field
//    Enter valid user password
//    Click Next Button
//    Verify that user was logged in by checking Inbox on the page


    @Test
    public void testLoginToYahooMail() {
        openMailLoginPage();
        enterUserName();
        enterPassword();
        verifyLoggedInToInbox();
    }
/*
    Valid login/Invalid Password
    Open yahoo mail page
    Locate user name field
    Enter Valid user id
    Click Next button
    Locate password field
    Enter invalid user password
    Click Next Button
    Verify that user was not logged in with an error message on the page
*/

    @Test
    public void testInValidPassword() {
        openMailLoginPage();
        enterUserName();
        enterInvalidPassword();
        verifyErrorMessage();
    }

    private void verifyErrorMessage() {
        String actualErrorMessage = driver.findElement(By.xpath("//*[contains(@class,'error') and @role='alert']")).getText();
        String expectedErrorMessage = "Invalid password. Please try again";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }

    private void enterInvalidPassword() {
        driver.findElement(By.xpath("//*[@class='password']")).sendKeys("Iamnumber1tester");
        driver.findElement(By.xpath("//button[@type='submit' and @value='Next']")).click();

    }

    private void verifyLoggedInToInbox() {
        String actualInbox = waitForElement(By.xpath("//span[contains(@data-test-folder-name,'Inbox')]")).getText();
        String expectedInbox = "Inbox";
        Assert.assertEquals(actualInbox,expectedInbox);


    }

    private void enterPassword() {
        driver.findElement(By.id("login-passwd")).sendKeys("Iamnumber1tester");
        driver.findElement(By.id("login-signin")).click();

    }

    private void enterUserName() {
        waitForElement(By.id("login-username")).sendKeys("ruslan123");
        driver.findElement(By.id("login-signin")).click();

    }

    private void openMailLoginPage() {
        driver.get(YAHOO_MAIL_LOGINPAGE_URL);
    }
}
