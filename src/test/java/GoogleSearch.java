import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleSearch {


        WebDriver driver;



        @BeforeSuite
        public void beforeSuite() {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        @AfterMethod
        public void afterMethod() {
            driver.manage().deleteAllCookies();
        }

        @AfterSuite
        public void afterSuite() {
            driver.close();
        }


        //TODO: make this test to use data provider
        @Test(dataProvider = "dataForGoogleTest")
        public void test001(String paramValue1) {
            String inputInfo = paramValue1;

            openMainPage();
            typeQuery(inputInfo);
            submitSearch();
            waitForResults();
            assertResultPage();
        }

        @Test
        public void test002() { //special test for unexpected input of searching
            String textValue = "#@#@!$!!#!@!";


            openMainPage();
            typeQuery(textValue);
            submitSearch();
            waitForResults2();
            assertResultPage2();
        }

    private void waitForResults2() {
        By resultsStatsElement = By.id("center_col");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsStatsElement));
    }

    private void assertResultPage2() {
        WebElement resultsStatsElement = driver.findElement(By.id("center_col"));
        boolean isElementDisplayed = resultsStatsElement.isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(isElementDisplayed, expectedResult);
    }

    private void waitForResults() {
            By resultsStatsElement = By.id("resultStats");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(resultsStatsElement));
        }

    @DataProvider(name = "dataForGoogleTest")
    public Object [][] dataForTest(){
        return new Object[][]{
                {"WebDriver Classes"}, //correct input
                {"#@#@!$!!#!@!"}, //test failed
                {"portnov computer school"}, //wrong input

        };
    }

        //TODO: add more meaningful assertion
        private void assertResultPage() {
            WebElement resultsStatsElement = driver.findElement(By.id("resultStats"));
            boolean isElementDisplayed = resultsStatsElement.isDisplayed();
            boolean expectedResult = true;
            Assert.assertEquals(isElementDisplayed, expectedResult);
        }

        private void submitSearch() {
            WebElement searchInput = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
            searchInput.submit();
        }

        private void typeQuery(String inputInfo) {
            WebElement searchInput = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
            searchInput.sendKeys(inputInfo);
        }

        private void openMainPage() {
            String url = "https://google.com";
            driver.get(url);
        }

}
