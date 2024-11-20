import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testScrollwithJS {

    WebDriver driver = null;

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://www.amazon.ae/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void TestSC() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,4000)");
        Thread.sleep(5000);

        WebElement amazonLogo = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[3]/span[1]/div/a/div"));
        Assert.assertTrue(amazonLogo.isDisplayed());
    }


}
