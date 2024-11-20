import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class logo {
    WebDriver driver = null;


    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        ChromeOptions option =new ChromeOptions();
        option.addArguments("--incognito");

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver(option);
        Thread.sleep(1000);
        driver.navigate().to("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    public void logo_page(){
        String LogoSCR ="https://ir.ebaystatic.com/cr/v/c01/01_PopularDestination_Luxury.jpg";
       System.out.println(driver.findElement(new ByChained(By.className("vl-popular-destinations-evo__link"), By.tagName("div"))).getAttribute("data-src"));


    }
}
