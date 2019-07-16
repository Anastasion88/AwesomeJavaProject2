package SogetiPresentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FindPageDigitalAssuranceTesting {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test001() throws InterruptedException {

        openWebPage();
        acceptCookies();
        findLinkServices();
        openDigitalAssuranceTesting();
        assertContent();
    }

    private void acceptCookies() {
        WebElement acceptCookies = driver.findElement(By.className("close-warning"));
        acceptCookies.click();
    }

    private void assertContent() {
        WebElement resultHeader = driver.findElement(By.className("content-intro"));
        boolean isElementDisplayed = resultHeader.isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(isElementDisplayed, expectedResult);

    }


    private void openDigitalAssuranceTesting() throws InterruptedException {
        WebElement findDigitalAssurance = driver.findElement(By.linkText("Digital Assurance & Testing"));
        findDigitalAssurance.click();
        Thread.sleep(5000);
    }

    private void findLinkServices() {
        WebElement findServices = driver.findElement(By.ByClassName.className ("level2"));
        findServices.click();
    }

    private void openWebPage() throws InterruptedException{
        String URL = "https://www.sogeti.com/";
        driver.get(URL);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }
}
