import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testAlert {
    WebDriver driver = null;

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void AlarttoJS() throws InterruptedException {

        WebElement btnAlert =driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        btnAlert.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertText= alert.getText();
        Assert.assertEquals("I am a JS Alert",alertText);
        alert.accept();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void AlarttoPromptJS() throws InterruptedException {

        WebElement btnAlert =driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        btnAlert.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("TEST");
        alert.accept();
        WebElement MSN = driver.findElement(By.id("result"));
        Assert.assertEquals("You entered: TEST",MSN.getText());
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void AlarttoConfirmJS() throws InterruptedException {

        WebElement btnAlert =driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        btnAlert.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement MSN = driver.findElement(By.xpath("//*[@id=\"result\"]"));
        Assert.assertEquals("You clicked: Ok",MSN.getText());

        Thread.sleep(3000);
        btnAlert.click();
        Thread.sleep(3000);
        alert.dismiss();
        Assert.assertEquals("You clicked: Cancel",MSN.getText());
        Thread.sleep(3000);



    }

    @AfterMethod
    public void After(){
        driver.quit();
    }
}
