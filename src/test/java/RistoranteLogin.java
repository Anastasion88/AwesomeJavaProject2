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

public class RistoranteLogin {

    WebDriver driver;



    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        openPage();
        inputData();
        submitData();
        waitForResults();
        assertResultPage();
    }

    private void assertResultPage() {
        WebElement resultsStatsElement = driver.findElement(By.id("main"));
        boolean isElementDisplayed = resultsStatsElement.isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(isElementDisplayed, expectedResult);

    }

    private void waitForResults() {
        By waitingResult = By.id("main");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitingResult));
    }

    private void submitData() {
        WebElement searchSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        searchSubmit.submit();

    }

    private void inputData() {
        String singleAttributeXpath = "//input[@name='restaurant_id']";
        String positionXpath = "(//input[@type='text'])[position()=2]";
        String multipleAttributeXpath = "//input[@name='password'][@type='password']";
        driver.findElement(By.xpath(singleAttributeXpath)).sendKeys("Stasik");
        driver.findElement(By.xpath(positionXpath)).sendKeys("anastasion88@mail.ru");
        driver.findElement(By.xpath(multipleAttributeXpath)).sendKeys("123stasik");
    }

    private void openPage() {
        String url = "http://52.9.182.211:3001/v1/log-in";
        driver.get(url);
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
   }

   @AfterSuite
    public void afterSuite() {
        driver.close();
   }



}
