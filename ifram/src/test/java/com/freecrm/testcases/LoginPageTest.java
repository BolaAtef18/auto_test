package com.freecrm.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.testsmith.support.listeners.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class LoginPageTest extends TestBase {

    public LoginPageTest() throws IOException {
        super();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void BeforeTest(String browser, Method method) throws InterruptedException, ATUTestRecorderException {
        initialization(browser);
        recorder = new ATUTestRecorder("C:\\Users\\batef\\IdeaProjects\\ifram\\Videos",method.getName(),false);
        recorder.start();
        Thread.sleep(1000);
    }


    @Test (priority = 1)
    public void title_test(Method method) throws InterruptedException, IOException {

        String expectedResults = "#1 Free CRM Software Power Up your Entire Business Free Forever";
        String actualResults = driver.getTitle();
        System.out.println(actualResults);
        Assert.assertEquals(actualResults, expectedResults);


    }

    @Test (priority = 2)
    public void urlCheck(Method method) throws InterruptedException, IOException {

        String actualResults = driver.getCurrentUrl();
        String expectedResults ="https://freecrm.com/";
        System.out.println(actualResults);
        Assert.assertEquals(actualResults, expectedResults);



    }

    @Test (priority = 3)
    public void logoTest(Method method) throws InterruptedException, IOException {

        WebElement logo = driver.findElement(new ByChained(By.xpath("//div[@class=\"rd-navbar-brand\"]"), By.xpath("//a[@class=\"brand-name\"]")));
        boolean actualResults = logo.isDisplayed();
        boolean expectedResults = true;
        System.out.println(actualResults);
        Assert.assertEquals(actualResults, expectedResults);

    }



    @Test (priority = 4)
    public void LoginTest(Method method) throws InterruptedException, IOException {

        driver.findElement(By.xpath("//a[@href=\"https://ui.cogmento.com/register/\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("email")).sendKeys(prop.getProperty("userName"));
        driver.findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div [@class=\"ui fluid large blue submit button\"]")).click();
        Thread.sleep(5000);


        String expectedResult = "bola atef";
        String  actualResult = driver.findElement(By.xpath("//span[@class=\"user-display\"]")).getText();
        Assert.assertEquals(expectedResult,actualResult);

    }

    @AfterMethod
   public void AfterTest(Method method) throws ATUTestRecorderException, IOException {
        TestUtils.takePicture(method.getName());
        recorder.stop();
        driver.quit();
    }

}
