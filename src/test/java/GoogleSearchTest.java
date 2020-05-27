import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class GoogleSearchTest {
    /*
         1. open the google.com webpage
         2. in search box type query string and submit the search
         3. Verify that result page is showing up
         4. Verify that amount of results is more than 100
      */

    //TODO: refactor this to step-by-step format
    String resultsStatsTextValue;
    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        String pageToOpen = "https://www.google.com/";
        String quarryString ="Portnov Computer School";
        String selector = ".gLFyf";
        String resultVerify  = "result-stats";

        openWebPage(driver,pageToOpen);
        searchBoxInput(quarryString,driver,selector);
        searchResultVerify(driver, resultVerify);
        verifyResultsNumber();

        //TODO read about try and catch block
    }

    private void verifyResultsNumber() {
        String[] stringArray = resultsStatsTextValue.split(" ");
        String amountOfResults = stringArray[1];
        String finalAmount = amountOfResults.replace(",", "");
        int amountOfResultsParsed = Integer.parseInt(finalAmount);
        Assert.assertTrue(amountOfResultsParsed > 100);
    }

    private void searchResultVerify(WebDriver pageDriver, String resultVerify) {
            WebElement resultsStatsElement = pageDriver.findElement(By.id(resultVerify));
            String resultsStatsText = resultsStatsElement.getText();
            resultsStatsTextValue = resultsStatsText;
    }

    private void openWebPage(WebDriver pageDriver, String webPage) {
        pageDriver.get(webPage);
    }
    private void searchBoxInput(String quarryString, WebDriver pageDriver, String elementSelector) {
        WebElement textInput = pageDriver.findElement(By.cssSelector(elementSelector));
        textInput.sendKeys(quarryString);
        textInput.submit();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
