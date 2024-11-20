import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class newWin {

    WebDriver driver = null;

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void TestMultwind() throws InterruptedException {
        String currentWindowID= driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
        Thread.sleep(5000);


        for (String windowID : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowID).getTitle();

            if (title.equals("New Window")) {
                Assert.assertEquals("New Window", driver.getTitle());
                System.out.println(driver.getTitle());
                driver.close();
                break;
            }

        }
        driver.switchTo().window(currentWindowID);
    }
}
