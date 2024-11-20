import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Datatable {
    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test
    public void testtable(){

        WebElement webTable = driver.findElement(By.id("table1"));

        List<WebElement> rows = webTable.findElements(By.tagName("tr"));
        Assert.assertEquals(5, rows.size());

        for (WebElement row : rows)
        {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols)
            {
                System.out.println(col.getText() + "\t");
            }
            System.out.println();
        }
    }
}

