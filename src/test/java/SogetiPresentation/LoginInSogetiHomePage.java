package SogetiPresentation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginInSogetiHomePage {
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



    @Test
    public void test001() throws InterruptedException{

        openPage();
        pushLoginButton();
        enterLoginInfo();
        submitLoginInfo();
        assertResultPage();

    }

    private void assertResultPage(){
        WebElement myProfileButton = driver.findElement(By.id("pt1:b2"));
        boolean isElementDisplayed = myProfileButton.isDisplayed();
        Assert.assertTrue(isElementDisplayed);

    }



    private void submitLoginInfo() throws InterruptedException{
        WebElement pushLoginWithData = driver.findElement(By.id("pt1:b1"));
        pushLoginWithData.click();
        Thread.sleep(5000);
    }

    private void pushLoginButton() throws InterruptedException {
        WebElement pushLoginButton = driver.findElement(By.id("pt1:gol1"));
        pushLoginButton.click();
        Thread.sleep(5000);

    }

    private void enterLoginInfo() {
        String multipleAttributeAndXpath = "//input[@name='pt1:it1' and @type='text']";
        String multipleAttributeOrXpath = "//input[@name='pt1:it2' or @type='password']";
        driver.findElement(By.xpath(multipleAttributeAndXpath)).sendKeys("anastasion88@mail.ru");
        driver.findElement(By.xpath(multipleAttributeOrXpath)).sendKeys("1234Anna");

    }

    private void openPage() {
        String url = "https://career.us.sogeti.com/jobs/faces/home";
        driver.get(url);
    }
}