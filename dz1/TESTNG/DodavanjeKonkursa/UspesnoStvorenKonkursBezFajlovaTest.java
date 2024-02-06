/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package DodavanjeKonkursa;

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
public class UspesnoStvorenKonkursBezFajlovaTest {
    public static String baseUrl="http://localhost/Projekat1/JobFair/login.php";
    public static WebDriver driver;
    public UspesnoStvorenKonkursBezFajlovaTest() {
    }
    
    @Test
    public void UspesnoStvorenKonkursBFChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Perovic\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.id("loginUsername")).sendKeys("nordeus");
            driver.findElement(By.id("loginPassword")).sendKeys("Nord0123!");
            driver.findElement(By.name("loginButton")).click();
            if(driver.findElement(By.linkText("Konkursi")).isDisplayed()){
                driver.findElement(By.linkText("Konkursi")).click();
                driver.findElement(By.linkText("DODAJ NOVI KONKURS")).click();
                driver.findElement(By.id("nazivKon")).sendKeys("Konkurs46");
                driver.findElement(By.id("rokKon")).sendKeys("31-12-2021");
                driver.findElement(By.id("tekstKon")).sendKeys("Dobro dosli");
                driver.findElement(By.id("noviKonDugme")).click();
                Assert.assertEquals(driver.findElement(By.id("poruka")).getText(), "Uspesno prijavljen konkurs");
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
    public void UspesnoStvorenKonkursBFFirefox(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Perovic\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.id("loginUsername")).sendKeys("nordeus");
            driver.findElement(By.id("loginPassword")).sendKeys("Nord0123!");
            driver.findElement(By.name("loginButton")).click();
            if(driver.findElement(By.linkText("Konkursi")).isDisplayed()){
                driver.findElement(By.linkText("Konkursi")).click();
                driver.findElement(By.linkText("DODAJ NOVI KONKURS")).click();
                driver.findElement(By.id("nazivKon")).sendKeys("Konkurs47");
                driver.findElement(By.id("rokKon")).sendKeys("2021-12-31");
                driver.findElement(By.id("tekstKon")).sendKeys("Dobro dosli");
                driver.findElement(By.id("noviKonDugme")).click();
                Assert.assertEquals(driver.findElement(By.id("poruka")).getText(), "Uspesno prijavljen konkurs");
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
    }
}
