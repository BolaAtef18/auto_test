import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


    public class iframe {



        WebDriver driver = null;

        @BeforeTest
        public void BeforeTest() throws InterruptedException {
            String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
            System.out.println(chromePath);
            System.setProperty("WebDriver.chrome.driver", chromePath);
            driver  = new ChromeDriver();
            Thread.sleep(5000);

            driver.navigate().to("https://demo.guru99.com/test/guru99home/");
           // driver.navigate().to("https://jqueryui.com/droppable/");
            driver.manage().window().maximize();
            Thread.sleep(5000);



        }



        @Test
        public void VaildData() throws InterruptedException {
//
//            driver.switchTo().frame("a077aa5e");
//            driver.findElement(By.xpath("//img[@src=\"Jmeter720.png\"]")).click();
//            System.out.println("Switch to frame Done successfully");

//            driver.switchTo().frame(0);
//            WebElement drage = driver.findElement(By.id("draggable"));
//            WebElement drop  = driver.findElement(By.id("droppable"));
//
//            Actions action =new Actions(driver);
//            action.clickAndHold(drage).moveToElement(drop).release().build().perform();
//            System.out.println("Drag and Drop Done successfully using Switch to frame by index");

             WebElement count =  driver.findElement(By.tagName("iframe"));
             WebElement size = (WebElement) count.getSize();

            System.out.println(size);



        }

        @Test
        public void InVaildData() {

        }

        @AfterTest
        public void AfterTest() {
            driver.quit();

        }
    }

