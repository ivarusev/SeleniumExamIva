import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Task2 {
    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "E:\\programs\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg/admin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void userLogin() {
        driver.findElement(By.id("input-username")).sendKeys("admin8");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.cssSelector(".btn")).click();
    }
    public void findingthevoucher() {
        driver.findElement(By.cssSelector("#menu :nth-child(5)")).click();
        driver.findElement(By.cssSelector("#collapse4 :nth-child(4) > a")).click();
    }
}
