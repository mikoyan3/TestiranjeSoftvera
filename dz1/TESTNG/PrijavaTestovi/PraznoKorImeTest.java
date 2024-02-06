package PrijavaTestovi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Perovic
 */
public class PraznoKorImeTest {
    public static String baseUrl="http://localhost/Projekat1/JobFair/login.php";
    public static WebDriver driver;
    public PraznoKorImeTest() {
    }

    @Test
    public void PraznoKorImeTestChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Perovic\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try{
            WebElement username = driver.findElement(By.id("loginUsername"));
            driver.findElement(By.id("loginPassword")).sendKeys("Test123!");
            driver.findElement(By.name("loginButton")).click();
            String isRequired = username.getAttribute("required");
            String tekst = username.getAttribute("value");
            Assert.assertTrue(isRequired.equals("true") && tekst.equals(""));
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void PraznoKorImeTestFirefox(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Perovic\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try{
            WebElement username = driver.findElement(By.id("loginUsername"));
            driver.findElement(By.id("loginPassword")).sendKeys("Test123!");
            driver.findElement(By.name("loginButton")).click();
            String isRequired = username.getAttribute("required");
            String tekst = username.getAttribute("value");
            Assert.assertTrue(isRequired.equals("true") && tekst.equals(""));
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        if(driver!=null){
            Thread.sleep(500);
            driver.quit();
        }
    }
}
