package Zuza;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZuzaTest extends Zuza.ZuzaDraiveriai {


        public ZuzaTest() {

            super(driver);
        }


    @BeforeClass
    public static void setUp() {
        System.setProperty("Webdriver.chrome.driver", "/Users/Raimonda/Downloads/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        Zuza.ZuzaDraiveriai.driver = new ChromeDriver(options);
        Zuza.ZuzaDraiveriai.driver.manage().window().maximize();
    }

//    @Test
//    public void registracijosPasiekimas(){
//            //papildyti
//    }

    @Test
    public void A_blogasPrisijungimas(){
        System.out.println("pirmas Testas");
        Zuza.ZuzaDraiveriai ZuzaDraiveriai;
        ZuzaDraiveriai.zuzaPuslapis();
        //ZuzaPrisijungimas.slapukas();
        ZuzaPrisijungimas.prisijungimas("pumabera@gmaiil.com", "baigiamasis");
    }

    @Test
    public void B_prisijungimas(){
        System.out.println("antras Testas");
        ZuzaDraiveriai.zuzaPuslapis();
        ZuzaPrisijungimas.prisijungimas("pumabera@gmail.com", "baigiamasis");
    }

    @AfterClass
    public static void tearDown() {

            driver.quit();
    }
}


