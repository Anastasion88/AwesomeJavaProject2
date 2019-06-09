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
        driver = new FirefoxDriver();

    }

    @Test
    public void test001() {
        openMainPage();

        String xPath1 = "";
        //WebElement element = driver.findElement(By.xpath(xPath1));

        String adsXPath = "html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]";
        String relativeXpath = "//form/div[1]/div/div[1]/div/div/input[1]";
        String singleAttributeXpath = "//input[@name='restaurant_id']";
        String multipleAttributeXpath = "//input[@name='restaurant_id'][@type='text']";
        String multipleAttributeAndXpath = "//input[@name='restaurant_id' and @type='text']";
        String multipleAttributeOrXpath = "//input[@name='restaurant_id' or @type='text']";
        String containsXpath = "//input[contains(@name,'taur')]";
        String startWithXpath = "//input[starts-with(@name,'restaur')]";
        String textXpath = "//*[text()='Log In']";
        String lastXpath = "(//input[@type='text'])[last()]"; // "(//input[@type='text'])[last()-1]" -1
        String positionXpath = "(//input[@type='text'])[position()=2]";
        String positionIndexXpath = "(//input[@type='text'])[2]";
        String followingXpath = "//*[@name='restaurant_id']/following::input[@type='text']"; //will find next after input
        String precedingXpath = "//*[@name='email']//preceding::input[@type='text']"; //will find before input






    }

    private void openMainPage() {
        String url = "http://52.9.182.211:3001/v1/log-in";
        driver.get(url);
    }
}
