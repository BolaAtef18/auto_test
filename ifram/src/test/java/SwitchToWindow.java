import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class SwitchToWindow {

    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(3000);

        driver.navigate().to("https://demo.guru99.com/popup.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);



    }

    @Test
    public void switchtochildwindow() throws InterruptedException {
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> ids =driver.getWindowHandles();
        Iterator <String> it = ids.iterator();
        String ParentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);

        driver.findElement(By.name("emailid")).sendKeys("test1@yopmail.com");
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(3000);

        System.out.println("Switch To Child Window Done successfully");



    }
    @AfterTest
    public void AfterTest() {
        driver.quit();

    }
}
