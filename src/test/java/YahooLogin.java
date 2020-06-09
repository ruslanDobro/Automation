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

public class YahooLogin {
    private static final String YAHOO_MAIL_LOGINPAGE_URL = "https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd";
    private WebDriver driver;
    private  WebElement textInput;


    @BeforeSuite
    public void testSuiteSetup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        driver = new FirefoxDriver();

    }
    @AfterSuite
//    public void tearDown(){
//        driver.quit();
//    }
//    Open yahoo mail page
//    Locate user name field
//    Enter Valid user id
//    Click Next button
//    Locate password field
//    Enter valid user password
//    Click Next Button
//    Verify that user was logged in by checking for Inbox on the page


    @Test
    public void testLoginToYahooMail() {
        openMailLoginPage();
        enterUserName();
        enterPassword();
    }

    private void enterPassword() {
        textInput =  driver.findElement(By.id("login-passwd"));
        textInput.sendKeys("my password");
        driver.findElement(By.id("login-signin")).click();

    }

    private void enterUserName() {
        WebDriverWait waiter = new WebDriverWait(driver,5);
        textInput =  driver.findElement(By.id("login-username"));
        textInput.sendKeys("my username");
        driver.findElement(By.id("login-signin")).click();
    }

    private void openMailLoginPage() {
        driver.get(YAHOO_MAIL_LOGINPAGE_URL);
    }
}
