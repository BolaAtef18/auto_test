import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class text {


    WebDriver driver = null;


    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        ChromeOptions option =new ChromeOptions();
        option.addArguments("--incognito");

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver(option);
        Thread.sleep(1000);
        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    public void testtext(){
        driver.manage().timeouts().getPageLoadTimeout();
        driver.findElement(By.xpath("//*[text()='News']")).click();
    }
}
