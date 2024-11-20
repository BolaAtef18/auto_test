import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkBox {

    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void testCheckbox(){
        WebElement check1 =driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        check1.click();

        WebElement check2 =driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        if (check2.isSelected()){
            check2.click();
        }


    }
}
