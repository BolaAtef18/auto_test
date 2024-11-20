import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {

    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void DAndD () throws InterruptedException {
        WebElement source = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(source,target).perform();
        Thread.sleep(3000);
        Assert.assertEquals("A",target.getText());


    }
}
