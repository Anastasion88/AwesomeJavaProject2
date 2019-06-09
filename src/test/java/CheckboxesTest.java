import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuit() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver(); //open Firefox browser

    }

    @Test
    public void test001() {
        openCheckBoxesPage();

        List<WebElement> listOfInputs = driver.findElements(By.tagName("input"));
        int listSize = listOfInputs.size(); //we can delete this line and test will work

        WebElement checkbox1 = listOfInputs.get(0);
        WebElement checkbox2 = listOfInputs.get(1);

         String attributesValue1 = checkbox1.getAttribute("checked");
        String attributesValue2 = checkbox2.getAttribute("checked");

        Assert.assertNull(attributesValue1);
        Assert.assertNotNull(attributesValue2);

        checkbox1.click();
        attributesValue1 = checkbox1.getAttribute("checked");


        Assert.assertNotNull(attributesValue1);

        String expectedAttributesValue = "true";
        Assert.assertEquals(expectedAttributesValue, attributesValue1);

    }

    private void openCheckBoxesPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }

    @AfterSuite
    public void afterSuite(){
        driver.close();
    }

}
