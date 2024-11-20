import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class list {
    WebDriver driver = null;


    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        ChromeOptions option =new ChromeOptions();
        option.addArguments("--incognito");



//        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
//        System.out.println(chromePath);
//        System.setProperty("WebDriver.chrome.driver", chromePath);
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver(option);
        Thread.sleep(1000);

        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);



    }

    @Test
    public void test_list() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("irbid");
        Thread.sleep(3000);

        WebElement list = driver.findElement(By.xpath("//ul[@role=\"listbox\"]"));
        List<WebElement> allsug = list.findElements(By.tagName("span"));
        System.out.println(allsug.get(0).getText());

        for (int i=0 ; i < allsug.size();i++){
            System.out.println(allsug.get(i).getText());
        }

    }
}
