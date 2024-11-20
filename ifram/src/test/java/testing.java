import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testing {
    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(3000);

        driver.navigate().to("https://demo.guru99.com/test/guru99home/");
        // driver.navigate().to("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        Thread.sleep(3000);


    }

    @Test

    public void first() throws InterruptedException {
        WebElement Submit = driver.findElement(By.id("philadelphia-field-submit"));


        JavascriptExecutor js =((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", Submit);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", Submit);

    }
}
