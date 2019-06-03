import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XPath {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuit() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver(); //open Firefox browser

    }

    @Test
    public void test001() {
        openMainPage();

        String xPath = "";
        WebElement element = driver.findElement(By.xpath(xPath));

        String adaXPath = "html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input";


    }

    private void openMainPage() {
        String url = "http://52.9.182.211:3001/v1/log-in;";
        driver.get(url);
    }
}
