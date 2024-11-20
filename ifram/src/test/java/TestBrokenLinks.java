import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TestBrokenLinks {
    WebDriver driver = null;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(1000);

        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    public void TestBL(){

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links are : "+ links.size());

        for (int i=0; i<links.size();i++){
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            VerifyLink(url);

        }

    }

    public void VerifyLink(String urlLink){

        try {
            URL link = new URL(urlLink);
            HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
            httpconn.setConnectTimeout(2000);
            httpconn.connect();
            if (httpconn.getResponseCode() == 200) {
                System.out.println(urlLink+" - "+httpconn.getResponseMessage());
            }
            if (httpconn.getResponseCode() == 404) {
                System.out.println(urlLink+" - "+httpconn.getResponseMessage());
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
