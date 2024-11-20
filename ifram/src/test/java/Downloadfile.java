import com.github.dockerjava.api.model.Capability;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.DrbgParameters;
import java.util.HashMap;

public class Downloadfile {
    WebDriver driver = null;
    public static String downloadPath= System.getProperty("user.dir")+"\\Download";



    public static ChromeOptions chromeOption(){

        ChromeOptions options = new ChromeOptions();
        HashMap<String,Object> chromeprefs = new HashMap<String,Object>();
        chromeprefs.put("profile.default_content_settings.popups", 0);
        chromeprefs.put("download.default_directory", downloadPath);
        chromeprefs.put("plugins.always_open_pdf_externally", true);
        System.out.println(downloadPath);
        options.setExperimentalOption("prefs",chromeprefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        return options;


    }

    @BeforeTest
    public void BeforeTest() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver(chromeOption());
        Thread.sleep(1000);

        driver.navigate().to("https://the-internet.herokuapp.com/download");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void testDownloadfile() throws InterruptedException {
        driver.findElement(By.linkText("Uploadfile.txt")).click();
        Thread.sleep(3000);

    }
}
