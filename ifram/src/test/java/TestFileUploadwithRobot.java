import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class TestFileUploadwithRobot {

    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(1000);

        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void FileUploadWithRobot() throws InterruptedException, AWTException {

        String imageName = "Screenshot 2024-10-19 111837.png";
        String imagePath = System.getProperty("user.dir")+"\\Uploads\\"+imageName;
        Thread.sleep(3000);

        WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/form"));
        uploadButton.click();


        Thread.sleep(3000);
        Robot robot = new Robot();
        Thread.sleep(3000);

        StringSelection selection= new StringSelection(imagePath);
        System.out.println(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection,null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);


//        WebElement fileupload = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
//        fileupload.click();
//        Thread.sleep(3000);
//        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
//        System.out.println(uploadedFiles.getText());
//        Thread.sleep(3000);
//        Assert.assertEquals(imageName,uploadedFiles.getText());

    }
}
