import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BingSearch {

    WebDriver driver; //class field, all methods could call this variable

    @Test
    public void test001() { //the way for install and use WebDriver
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver(); //open Firefox browser

        openMainPage();
        typeQuery();
        submitSearch();
        waitForResult();
        assertResultPage();

    }

    private void waitForResult() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_tween")));

    }

    private void assertResultPage() {
        WebElement resultStatElement = driver.findElement(By.id("b_tween"));
        boolean isElementDisplayed = resultStatElement.isDisplayed();

        boolean expectedResult = true;

        Assert.assertEquals(isElementDisplayed, expectedResult);
    }

    private void submitSearch() {
        WebElement searchImput = driver.findElement(By.cssSelector("#sb_form_q"));
        searchImput.submit();
    }

    private void typeQuery() { //1.find element and 2.input text
       WebElement searchImput = driver.findElement(By.cssSelector("#sb_form_q"));
        searchImput.sendKeys("population of USA 2019");

    }

    private void openMainPage() {

        String url = "https://www.bing.com";
        driver.get(url);

    }
}
