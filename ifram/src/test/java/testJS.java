import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testJS {

    WebDriver driver = null;

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void Test_Java_Script(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = (String) js.executeScript("return document.title");
        Assert.assertEquals("Google",title);
        System.out.println(title);

        long links = (long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
        System.out.println(links);
        Assert.assertEquals(16,links);
    }
}
