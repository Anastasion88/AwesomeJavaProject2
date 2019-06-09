import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BingSearch2withChanges {
    WebDriver driver; //class field, all methods could call this variable

    @BeforeSuite
    public void beforeSuit() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver(); //open Firefox browser

    }

    @AfterSuite
    public void afterSuite() {
        driver.close(); //close Firefox browser
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void test001() { //the way for install and use WebDriver
        String textValue = "population of USA 2019";

        openMainPage();
        typeQuery(textValue);
        submitSearch();
        waitForResult();
        assertResultPage();

    }

    @Test
    public void test002() {
        String textValue = "How to become a guru in JAVA";

        openMainPage();
        typeQuery(textValue);
        submitSearch();
        waitForResult();
        assertResultPage();


    }

    private void waitForResult() {

        WebDriverWait wait = new WebDriverWait(driver, 10); //the way of waiting to showing element
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

    private void typeQuery(String queryText) { //1.find element and 2.input text
        WebElement searchImput = driver.findElement(By.cssSelector("#sb_form_q"));
        searchImput.sendKeys(queryText);

    }

    private void openMainPage() {

        String url = "https://www.bing.com";
        driver.get(url);

    }



}
