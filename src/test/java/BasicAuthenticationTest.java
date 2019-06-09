import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BasicAuthenticationTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuit() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver(); //open Firefox browser

    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void test001() { //test without data provider
        String login = "admin";
        String password = "admin";

        openBasicAuthPage(login, password);
        assertThatAuthenticated();

    }

@DataProvider(name = "dataForAuthTest")
public Object [][] dataForTest(){
        return new Object[][]{
                {"admin", "admin"}, //correct input
                {"Vadim", "Rodion"}, //wrong input
                {"Admin1", "Admin2"}, //wrong input

        };
}



    @Test (dataProvider = "dataForAuthTest")
    public void test002(String paramValue1, String paramValue2) {
        String login = paramValue1;
        String password = paramValue2;

        openBasicAuthPage(login, password);
        assertThatAuthenticated();

    }

    private void assertThatAuthenticated() {
       boolean isContainCongrats = driver.getPageSource().contains("Congrat"); //how to find some word on the page

        Assert.assertTrue(isContainCongrats);
    }

    private void openBasicAuthPage(String login, String password) { //do accept string login and passw

        String url = "https://" + login + ":" + password + "@" + "the-internet.herokuapp.com/digest_auth";
        driver.get(url);
    }
    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }
}
