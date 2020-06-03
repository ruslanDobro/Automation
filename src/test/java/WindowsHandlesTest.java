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

import java.time.Instant;
import java.util.Set;

import static java.lang.Thread.sleep;

//TODO Create a different scenarios
public class WindowsHandlesTest {
    private static final String WINDOW_MAIN_PAGE = "https://the-internet.herokuapp.com/windows";
    private WebDriver driver;
    private String originalWindowHandle;
    private String newWindowHandle;
    private By expectedElement = By.linkText("Click Here");
    private String expectedWindowTitle = "New Window";
    private String expectedWindowText = "New Window";
    private String expectedOriginalWindowTitle = "The Internet";
    private int expectedAmountOfWindows;
    private Set<String> windowHandles;
    private WebDriverWait  webDriverWait;


    @BeforeSuite
    public void testSuiteSetup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        driver = new FirefoxDriver();

    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
    //1. OPen the browser
    //2. OPen windows page
    //3. Click on "Click Here" link
    //4. Verify the amount of windows is 2
    //5. Verify new window title
    //6. Verify new window text
    //7. Switch back to original window
    //8.Verify original window title
    @Test
    public void test001() {
        expectedAmountOfWindows = 2;

        openWindowsPage();
        clickOnLink();
        verifyAmountOfWindows(expectedAmountOfWindows);
        switchToNewWindow();
        verifyWindowTitle(expectedWindowTitle);
        verifyWindowText(expectedWindowText);
        switchToOriginalWindow();
        verifyWindowTitle(expectedOriginalWindowTitle);


    }

    private void switchToNewWindow() {
        driver.switchTo().window(newWindowHandle);
        driver.getTitle();
    }

    private void switchToOriginalWindow() {
        driver.switchTo().window(originalWindowHandle);
    }

    private void verifyWindowText(String expectedText) {
        Assert.assertTrue(driver.getPageSource().contains(expectedText));
    }

    private void verifyWindowTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    private void verifyAmountOfWindows(int expectedAmount) {
        //TODO change this to explicit wait
//        try {
//            sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(expectedAmountOfWindows - 1));


        windowHandles = driver.getWindowHandles();
        int actualAmountOfHandles = windowHandles.size();
        Assert.assertEquals(actualAmountOfHandles,expectedAmount);

        originalWindowHandle = (String) windowHandles.toArray()[0];
        newWindowHandle = (String) windowHandles.toArray()[expectedAmountOfWindows-1];


    }

    private void clickOnLink() {
        WebElement webElement = waitForElement(expectedElement);
        for(int i = 0; i < expectedAmountOfWindows - 1; i++) {
            webElement.click();
        }


    }

    private WebElement waitForElement(By expectedElement) {
        webDriverWait= new WebDriverWait(driver,10);
        WebElement foundedElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
        return foundedElement;
    }

    private void openWindowsPage() {
        driver.get(WINDOW_MAIN_PAGE);
    }
// Test scenario with more then one new window open
    @Test
    public void test002() {
        expectedAmountOfWindows = 4;

        openWindowsPage();
        clickOnLink();
        verifyAmountOfWindows(expectedAmountOfWindows);
        switchToNewWindow();
        verifyWindowTitle(expectedWindowTitle);
        verifyWindowText(expectedWindowText);
        switchToOriginalWindow();
        verifyWindowTitle(expectedOriginalWindowTitle);

    }
}
