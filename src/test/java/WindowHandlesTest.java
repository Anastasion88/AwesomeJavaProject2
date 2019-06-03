import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlesTest {
    WebDriver driver;
    String windowHandle1;
    String windowHandle2;




    @BeforeSuite
    public void beforeSuit() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() throws InterruptedException {
        openLink();
        openNewWindow();
        defineWindowsHandles();
        assertResultOfWindowTwo();
        assertResultOfWindowOne();
    }

    private void assertResultOfWindowOne() {
        driver.switchTo().window(windowHandle1);
        String windowTitle = driver.getTitle();
        String titlePartialText = "The Internet";
        boolean isTitleThere = windowTitle.contains(titlePartialText);
        Assert.assertTrue(isTitleThere);
    }

    private void assertResultOfWindowTwo() {
        driver.switchTo().window(windowHandle2);
        String pageSource = driver.getPageSource();
        String textToCheck = "New Window";
        boolean isTextThere = pageSource.contains(textToCheck);
        Assert.assertTrue(isTextThere);
    }

    private void defineWindowsHandles() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        boolean isTwoWindowsOpened = allWindowHandles.size() == 2;
        Assert.assertTrue(isTwoWindowsOpened);

        windowHandle1 = (String) allWindowHandles.toArray()[0];
        windowHandle2 = (String) allWindowHandles.toArray() [1];
    }

    private void openNewWindow() throws InterruptedException  {
        By linkByText = By.linkText("Click Here");
        WebElement linkElement = driver.findElement(linkByText);
        linkElement.click();
        Thread.sleep(5000); //the way to waiting when the windows will open
    }

    private void openLink() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
