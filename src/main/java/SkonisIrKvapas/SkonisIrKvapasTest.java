package SkonisIrKvapas;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SkonisIrKvapasTest extends SkonisIrKvapasBase {

        public SkonisIrKvapasTest() {
            super(driver);
        }


    @BeforeClass
    public static void setUp() {
        System.setProperty("Webdriver.chrome.driver", "/Users/Raimonda/Downloads/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        SkonisIrKvapasBase.driver = new ChromeDriver(options);
        SkonisIrKvapasBase.driver.manage().window().maximize();
    }

    @Test
    public  void prisijungimoTestas(){
        SkonisIrKvapasBase.skSvetaine();
        SkonirIrKvapasPrisijungimas.slapukas();
        SkonirIrKvapasPrisijungimas.prisijungimas();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}


