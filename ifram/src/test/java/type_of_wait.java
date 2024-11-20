import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class type_of_wait {

    WebDriver driver = null;

//    @BeforeTest
//    public void BeforeTest() throws InterruptedException {
//        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
//        System.out.println(chromePath);
//        System.setProperty("WebDriver.chrome.driver", chromePath);
//        driver  = new ChromeDriver();
//        Thread.sleep(5000);
//
//        driver.navigate().to("https://library-app.firebaseapp.com/");
//
//        driver.manage().window().maximize();
//        Thread.sleep(5000);
//    }

    @Test
    public void sleep() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://library-app.firebaseapp.com/");

        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Libraries")).click();
//1- Thread sleep____from Java____static___it will wait till the time of sleep finish then take action
        Thread.sleep(9000);
        driver.findElement(By.linkText("Abc")).click();
        System.out.println("waiting by Thread.sleep Done successfully");
        driver.quit();

    }

    @Test
    public void Implicitly() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://library-app.firebaseapp.com/");

        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Libraries")).click();
//2- implicit Wait____from Selenium____Dynamic____Global___it will wait till the element appear then take action
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Abc")).click();
        System.out.println("waiting by implicit wait Done successfully");
        driver.quit();

    }

    @Test
    public void testexplicitwait() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://library-app.firebaseapp.com/");

        driver.manage().window().maximize();
        //Thread.sleep(5000);
        driver.findElement(By.linkText("Libraries")).click();
        //Thread.sleep(5000);
//2- Explicit wait__from Selenium__Dynamic__private__it will wait till the element appear then take action
//        int seconds = 2000; // Example integer
//        Duration duration = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Abc")))).click();

       // driver.findElement(By.linkText("Abc")).click();
        System.out.println("waiting by Explicit wait Done successfully");

    }

//    @AfterTest
//    public void AfterTest() {
//        driver.quit();
//
//    }
}
