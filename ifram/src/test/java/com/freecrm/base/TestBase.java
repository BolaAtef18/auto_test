package com.freecrm.base;

import atu.testrecorder.ATUTestRecorder;
import com.freecrm.util.WebListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static  Properties prop;
    public static ATUTestRecorder recorder;

    public TestBase() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\batef\\IdeaProjects\\ifram\\src\\test\\java\\com\\freecrm\\config\\config.properties");
        prop.load(fis);
    }

    public void initialization(String browser) throws InterruptedException {

        if (browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--incognito");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
            Thread.sleep(1000);

        } else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions option = new FirefoxOptions();
            option.addArguments("--incognito");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(option);
            Thread.sleep(1000);
        }

        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);


    }

}
