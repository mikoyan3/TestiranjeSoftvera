package PretragaKonkursa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
public class NeuspesnaPretragaTest {
    public static String baseUrl="http://localhost/Projekat1/JobFair/login.php";
    public static WebDriver driver;
    public NeuspesnaPretragaTest() {
    }
    @Test
    public void neuspesnaPretragaChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Perovic\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.id("loginUsername")).sendKeys("aleksa");
            driver.findElement(By.id("loginPassword")).sendKeys("Sifra1234$");
            driver.findElement(By.name("loginButton")).click();
            if(driver.findElement(By.linkText("Konkursi")).isDisplayed()){
                driver.findElement(By.linkText("Konkursi")).click();
                String search = driver.findElement(By.tagName("body")).getText();
                Assert.assertTrue(search.contains("Odaberi ili praksu ili posao ili oba") || search.contains("Ne postoji rezultat"));
                if(driver!=null){
                    Thread.sleep(500);
                    driver.quit();
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void neuspesnaPretragaFirefox(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Perovic\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.id("loginUsername")).sendKeys("aleksa");
            driver.findElement(By.id("loginPassword")).sendKeys("Sifra1234$");
            driver.findElement(By.name("loginButton")).click();
            if(driver.findElement(By.linkText("Konkursi")).isDisplayed()){
                driver.findElement(By.linkText("Konkursi")).click();
                String search = driver.findElement(By.tagName("body")).getText();
                Assert.assertTrue(search.contains("Odaberi ili praksu ili posao ili oba") || search.contains("Ne postoji rezultat"));
                if(driver!=null){
                    Thread.sleep(500);
                    driver.quit();
                }
            }
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
