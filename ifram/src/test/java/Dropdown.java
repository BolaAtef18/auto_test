import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown {

    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void pressOnDDL(){

        WebElement optionList = driver.findElement(By.id("dropdown"));
        Select selectoption = new Select(optionList);
        Assert.assertFalse(selectoption.isMultiple());
        Assert.assertEquals(3,selectoption.getOptions().size());
        selectoption.selectByVisibleText("Option 1");

        Assert.assertEquals("Option 1", selectoption.getFirstSelectedOption().getText());

    }
}
