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

    @Test
    public void A_registracijosPasiekimas(){
            ZuzaRegistracija.slapukas();
            ZuzaRegistracija.prisiregistruoti();
    }

    @Test
    public void B_blogasPrisijungimas(){
        ZuzaDraiveriai.zuzaPuslapis();
        ZuzaPrisijungimas.prisijungimas("pumabera@gmaiil.com", "baigiamasis");
    }

    @Test
    public void C_prisijungimas(){
        ZuzaDraiveriai.zuzaPuslapis();
        ZuzaPrisijungimas.prisijungimas("Nakciausias5098@gmail.com", "Grazuma8597");
    }

//    @Test
//    public void D_paieska(){
//        PaieskosLaukas.zuzaPaieska();
//    }
//
//    @Test
//    public void E_pirkiniai(){
//        PirkiniuKrepselis.zuzaPirkiniai();
//    }

    @Test
    public void F_naikinamaPaskyra(){
            ZuzaRegistracija.paskyrosNaikinimas();
    }

    @AfterClass
    public static void tearDown() {

            driver.quit();
    }
}


