import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleclickWithActions {

    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://qa-practice.netlify.app/double-click");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void DoubleClick() throws InterruptedException {
        WebElement message = driver.findElement(By.id("double-click-btn"));

        System.out.println(message.getCssValue("background-color"));

        Actions builder = new Actions(driver);
        builder.doubleClick(message).perform();

        Thread.sleep(3000);

        String  msm = driver.findElement(By.xpath("//*[@id=\"double-click-result\"]")).getText();
        System.out.println(message.getCssValue("background-color"));

        Assert.assertEquals("Congrats, you double clicked!",msm);
    }
}
