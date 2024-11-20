import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLImageElement;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;

public class CheckAllBrokenLinks {
    WebDriver driver = null;
    private int invalidImageCount;

    @BeforeTest
    public void BeforeTest() throws InterruptedException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(1000);

        driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
        driver.manage().window().maximize();
        Thread.sleep(1000);

    }
    @Test
    public void testBrokenImages() throws IOException {
        invalidImageCount=0;
        List<WebElement> imageList = driver.findElements(By.tagName("img"));
        for (WebElement imgElement:imageList)
        {
            if (imgElement !=null)
            {
                VerifyImageActive(imgElement);
            }
        }
        System.out.println("Total no.of invaild Images are:" +invalidImageCount);

    }

    public void VerifyImageActive(WebElement imgElement) throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(imgElement.getAttribute("src"));
        try {
            CloseableHttpResponse response = client.execute(request);
            if (response.getCode()!=200){
                invalidImageCount++;

            }
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
