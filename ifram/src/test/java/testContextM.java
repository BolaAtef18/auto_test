import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testContextM {

    WebDriver driver = null;

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void ContextM() throws InterruptedException {

        WebElement ClickMe = driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/p/span"));
        WebElement ContextMenu = driver.findElement(By.xpath("/html/body/ul/li[1]"));

        Actions builder = new Actions(driver);
        builder.contextClick(ClickMe).moveToElement(ContextMenu).click().perform();

        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals("clicked: edit",alert.getText());

        alert.dismiss();
        Thread.sleep(3000);


    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
