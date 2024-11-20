import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class footer {

    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(3000);

        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);



    }


    @Test

    public void Footers(){

        WebElement footers = driver.findElement(By.xpath("//ul[@class=\"sc-19b1eb93-1 fwyFkM\"]"));


//        footers.findElements(By.tagName("a")).size();
        System.out.println(footers.findElements(By.tagName("a")).size());
    }
}
