import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUploadFile {
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
        Thread.sleep(1000);
    }

    @Test
    public void FileUpload(){

        String imageName = "Screenshot 2024-10-19 111837.png";
        String imagePath = System.getProperty("user.dir")+"/Uploads/"+imageName;

        WebElement fileupload = driver.findElement(By.id("file-upload"));
        fileupload.sendKeys(imagePath);
        WebElement filesubmit = driver.findElement(By.id("file-submit"));
        filesubmit.click();

        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        System.out.println(uploadedFiles.getText());
        Assert.assertEquals(imageName,uploadedFiles.getText());



    }
}
