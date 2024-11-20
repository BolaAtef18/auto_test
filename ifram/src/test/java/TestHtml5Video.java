import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHtml5Video {

    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(1000);

        driver.navigate().to("https://www.gettyimages.ae/detail/video/joren-falls-shizuoka-prefecture-japan-stock-footage/2165893368");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    public void testHTML5VidPlayer() throws InterruptedException {

        WebElement videoPlayer = driver.findElement(By.xpath("/html/body/div[2]/section/div/div[1]/div/div[2]/div/div[3]/section/figure/div/video"));
        Actions actions = new Actions(driver);
        //actions.moveToElement(videoPlayer).click().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String source = (String) js.executeScript("return arguments[0].currentSrc;",videoPlayer);
        System.out.println(source);
        Double duration = (Double) js.executeScript("return arguments[0].duration;",videoPlayer);
        System.out.println(duration);
        Thread.sleep(3000);
//        Assert.assertEquals(source,"https://www.w3schools.com/html/mov_bbb.mp4");
//        Assert.assertEquals(duration,10.026667);
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(6000);
        actions.moveToElement(videoPlayer).click().perform();
        Thread.sleep(6000);
        actions.moveToElement(videoPlayer).click().perform();

//        js.executeScript("arguments[0].pause();", videoPlayer);
        Thread.sleep(6000);
    }

    @AfterTest
    public void Close(){
        driver.quit();
    }

}
