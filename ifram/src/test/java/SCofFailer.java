import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SCofFailer {
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
    public void testSCofFailer(){
        WebElement SearchTxt = driver.findElement(By.id("twotabsearchtextboxx"));
        SearchTxt.sendKeys("selenium");
        SearchTxt.submit();

        Assert.assertTrue(driver.getTitle().contains("selenium"));

    }

    @AfterMethod
    public void takeScrrenShoot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("./Snapshots/"+ result.getName()+".png"));
        }


    }
}
