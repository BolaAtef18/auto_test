import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Cookiestest {

    WebDriver driver = null;

    @BeforeMethod
    public void BeforeTest() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("WebDriver.chrome.driver", chromePath);
        driver  = new ChromeDriver();
        Thread.sleep(5000);

        driver.navigate().to("http://magento-demo.lexiconn.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test

    public void Cookies() throws InterruptedException {

        WebElement languageSelect = driver.findElement(By.id("select-language"));
        Select select = new Select(languageSelect);
        Assert.assertEquals("English",select.getFirstSelectedOption().getText());

        Cookie StoreCookie = driver.manage().getCookieNamed("store");
        Assert.assertEquals(null, StoreCookie);

        select.selectByVisibleText("German");
        Thread.sleep(3000);

        StoreCookie = driver.manage().getCookieNamed("store");
        Assert.assertEquals("german", StoreCookie.getValue());
       System.out.println(StoreCookie.getValue());

       Set<Cookie>  cookies= driver.manage().getCookies();
       System.out.println("Number of Cookies: "+ cookies.size());
        Iterator<Cookie> itr = cookies.iterator();

        while (itr.hasNext())

        {
            Cookie cookie=itr.next();
            System.out.println(cookie.getValue());
            System.out.println(cookie.getDomain());
            System.out.println(cookie.getExpiry());
            System.out.println(cookie.getName());
            System.out.println(cookie.getPath());
        }

    }
}
