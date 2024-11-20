package com.freecrm.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.freecrm.base.TestBase;
import com.freecrm.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class ContactPageTest extends TestBase {
    public ContactPageTest() throws IOException {
        super();
    }
    @Parameters({"browser"})
    @BeforeMethod
    public void BeforeTest(String browser, Method method) throws InterruptedException, ATUTestRecorderException {

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

    @Test (dataProvider = "testData")
    public void addContact(String fName, String lName, String departmentName) throws InterruptedException, ATUTestRecorderException {
        Thread.sleep(3000);
        WebElement menu =driver.findElement(By.xpath("//div[@id=\"main-nav\"]"));
        Actions action =new Actions(driver);
        action.moveToElement(menu).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href=\"/contacts\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class=\"edit icon\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("first_name")).sendKeys(fName);
        Thread.sleep(1000);
        driver.findElement(By.name("last_name")).sendKeys(lName);
        Thread.sleep(1000);
        driver.findElement(By.name("department")).sendKeys(departmentName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class=\"save icon\"]")).click();
        Thread.sleep(1000);
    }

    @DataProvider
    public Object[][] testData() throws IOException {
        Object data[][]=TestUtils.getDataFromExcel("ContactPage");

        return data;
    }

    @AfterMethod
    public void AfterTest(Method method) throws ATUTestRecorderException, IOException {
        TestUtils.takePicture(method.getName());
        recorder.stop();
        driver.quit();
    }
}
