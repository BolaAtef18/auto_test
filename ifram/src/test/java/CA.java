import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CA {
    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(1000);

        driver.navigate().to("https://html.com/input-type-file/");
        driver.manage().window().maximize();
        Thread.sleep(1000);



    }

    @Test
    public void TestCA () throws InterruptedException {
        WebElement upload =  driver.findElement(By.id("fileupload"));

        JavascriptExecutor js =((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",upload );
        Thread.sleep(3000);

        driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\batef\\OneDrive\\Desktop\\Screenshot 2024-10-19 111839.png");
        System.out.println("Upload file Done successfully");
        Thread.sleep(3000);

    }
    @AfterTest
    public void AfterTest() {
        driver.quit();

    }
}
