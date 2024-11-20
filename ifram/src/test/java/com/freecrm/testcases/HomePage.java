package com.freecrm.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class HomePage extends TestBase {

    public HomePage() throws IOException {
        super();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void BeforeTest(String browser,Method method) throws InterruptedException, ATUTestRecorderException {

        initialization(browser);
        recorder = new ATUTestRecorder("C:\\Users\\batef\\IdeaProjects\\ifram\\Videos",method.getName(),false);
        recorder.start();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href=\"https://ui.cogmento.com/register/\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("email")).sendKeys(prop.getProperty("userName"));
        driver.findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div [@class=\"ui fluid large blue submit button\"]")).click();
        Thread.sleep(3000);


    }

    @Test (priority = 5)
    public void clickoncontact(Method method) throws InterruptedException, IOException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id=\"main-nav\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href=\"/contacts\"]")).click();
        WebElement statuslabel = driver.findElement(By.xpath("//th[text()='Status']"));
        boolean actualResult =  statuslabel.isDisplayed();
        Assert.assertTrue(actualResult, "status lable is not displayed");

    }
    @Test (priority = 6)
    public void clickondeals(Method method) throws InterruptedException, IOException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id=\"main-nav\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href=\"/deals\"]")).click();
        WebElement Amountlabel = driver.findElement(By.xpath("//th[text()='Amount']"));
        boolean actualResult =  Amountlabel.isDisplayed();
        Assert.assertTrue(actualResult, "Amount lable is not displayed");

    }
    @Test (priority = 7)
    public void clickontasks(Method method) throws InterruptedException, IOException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id=\"main-nav\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href=\"/tasks\"]")).click();
        WebElement DueDatelabel = driver.findElement(By.xpath("//th[text()='Due Date']"));
        boolean actualResult =  DueDatelabel.isDisplayed();
        Assert.assertTrue(actualResult, "Due Date lable is not displayed");

    }
    @AfterMethod
    public void AfterTest(Method method) throws ATUTestRecorderException, IOException {
        TestUtils.takePicture(method.getName());
        recorder.stop();
        driver.quit();
    }
}
