import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FWtest {

    WebDriver driver = null;

    public void FluentWaitTest(WebDriver driver) {
    }

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://www.w3schools.com/xml/ajax_examples.asp");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @Test
    public void testFluent(){

        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/a[2]")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))  // Total wait time
                .pollingEvery(Duration.ofSeconds(2))  // Frequency of checks
                .ignoring(NoSuchElementException.class);  // Exceptions to ignore

        WebElement message = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id=\"main\"]/div[3]"));
            }
        });

        Assert.assertTrue(message.getText().contains("The W3C Document"));




    }
}
