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
public class UspesnaPrijavaTest {
    public static String baseUrl="http://localhost/Projekat1/JobFair/login.php";
    public static WebDriver driver;
    public UspesnaPrijavaTest() {
    }

    @Test
    public void uspesnoPrijavljenChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Perovic\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.id("loginUsername")).sendKeys("aleksa");
            driver.findElement(By.id("loginPassword")).sendKeys("Sifra1234$");
            driver.findElement(By.name("loginButton")).click();
            String tekst = driver.findElement(By.id("glavniKont")).getText();
            String poruka = "JobFair 2019";
            Assert.assertTrue(tekst.contains(poruka));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void uspesnoPrijavljenFirefox(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Perovic\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.id("loginUsername")).sendKeys("aleksa");
            driver.findElement(By.id("loginPassword")).sendKeys("Sifra1234$");
            driver.findElement(By.name("loginButton")).click();
            String tekst = driver.findElement(By.id("glavniKont")).getText();
            String poruka = "JobFair 2019";
            Assert.assertTrue(tekst.contains(poruka));
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
