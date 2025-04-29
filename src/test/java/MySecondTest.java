import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class MySecondTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // ✅ Set the correct path to your chromedriver
        System.setProperty("webdriver.chrome.driver", "/Users/hifriend/Downloads/chromedriver-mac-arm64-3/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(38));
        driver.get("https://www.instagram.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginToTheApplication() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("noor.ghafoori2004@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Kabul@12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait a little to allow page to load
        Thread.sleep(5000);

        // Check if "Home" text appears after login
        WebElement homeIcon = driver.findElement(By.xpath("//div[contains(text(),'Home')]"));
        String actualResult = homeIcon.getText();
        String expectedResult = "Home";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}