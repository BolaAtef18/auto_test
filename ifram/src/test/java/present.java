import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class present {

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
    public void testIsElementPresent() {
        if (isElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[5]"))) {
            WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
            if (!check1.isSelected()) {
                check1.click();
            }

        }else {
            Assert.fail("Checkbox 1 doesn't exist");
        }
    }

    private boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }

    }
}
