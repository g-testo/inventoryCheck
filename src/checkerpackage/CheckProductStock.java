package checkerpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckProductStock {
    public String baseUrl = "https://epson.com/Clearance-Center/Home-Entertainment/Home-Cinema-5040UBe-WirelessHD-3LCD-Projector-with-4K-Enhancement-and-HDR---Refurbished/p/V11H714020-N";
//    public String baseUrl = "https://epson.com/Clearance-Center/Home-Entertainment/PowerLite-Home-Cinema-5040UB-3LCD-Projector-with-4K-Enhancement-and-HDR---Refurbished/p/V11H713020-N";
    
    private String chromeDriverPath = "/Users/mbp16/selenium-java-3.141.59/chromedriver";
    
    public WebDriver driver;     
    
    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Test()
    public void checkIfProductIsOOS() {
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement soldOutEl = driver.findElement(By.cssSelector(".promo-bug"));
        Assert.assertNotEquals(soldOutEl.getText(), "OUT OF STOCK");
   }
    @AfterTest
    public void terminateBrowser(){
    	driver.close();
    }
}
