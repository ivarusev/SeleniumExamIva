import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VoucherDelete {
    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "E:\\programs\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void userRegistration() {
        driver.findElement(By.cssSelector(".list-inline .dropdown")).click();
        driver.findElement(By.cssSelector(".dropdown-menu-right :nth-of-type(2)")).click();

        driver.findElement(By.cssSelector(".well a.btn-primary")).click();

        WebElement inputFirstName = driver.findElement(By.id("input-firstname"));
        inputFirstName.sendKeys("NqkvoIme");

        WebElement inputLastName = driver.findElement(By.id("input-lastname"));
        inputLastName.sendKeys("NqkvoLastName");

        String randomEmail = RandomStringUtils.randomAlphanumeric(7) + "@blabla.com";

        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys(randomEmail);

        WebElement inputPhone = driver.findElement(By.id("input-telephone"));
        inputPhone.sendKeys("0899965988");

        WebElement inputCustomerPassword = driver.findElement(By.id("input-password"));
        inputCustomerPassword.sendKeys("parola123!");

        WebElement inputCustomerPasswordConfirm = driver.findElement(By.id("input-confirm"));
        inputCustomerPasswordConfirm.sendKeys("parola123!");

        WebElement checkboxButton = driver.findElement(By.cssSelector(".pull-right > input:first-of-type"));
        checkboxButton.click();

        WebElement saveCustomerButton = driver.findElement(By.cssSelector("div.pull-right > input.btn-primary"));
        saveCustomerButton.click();

        driver.findElement(By.cssSelector(".list-group a:nth-of-type(4)")).click();

        driver.findElement(By.cssSelector(".buttons .pull-right")).click();

        WebElement inputFirstNameAddress = driver.findElement(By.id("input-firstname"));
        inputFirstNameAddress.sendKeys("Ivan");

        WebElement inputLastNameAddress = driver.findElement(By.id("input-lastname"));
        inputLastNameAddress.sendKeys("Popov");

        WebElement inputAddress = driver.findElement(By.id("input-address-1"));
        inputAddress.sendKeys("Lyulqk 16");

        WebElement inputAddressCity = driver.findElement(By.id("input-city"));
        inputAddressCity.sendKeys("Varna");

        WebElement inputAddressPostcode = driver.findElement(By.id("input-postcode"));
        inputAddressPostcode.sendKeys("9000");

        Select countySelectDropdown = new Select(driver.findElement(By.id("input-country")));
        countySelectDropdown.selectByValue("33");

        Select regionSelectDropdown = new Select(driver.findElement(By.id("input-zone")));
        regionSelectDropdown.selectByValue("501");

        driver.findElement(By.cssSelector(".buttons .pull-right")).click();

        WebElement alertSuccessAddressAdd = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(alertSuccessAddressAdd.getText().contains("Your address has been successfully added"));
    }
}
