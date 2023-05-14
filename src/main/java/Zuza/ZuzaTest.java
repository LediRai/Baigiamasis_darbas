package Zuza;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.awt.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZuzaTest extends ZuzaDraiveriai {

    public ZuzaTest() {

        super(driver);
    }

    @BeforeClass
    public static void setUp() {
//       System.setProperty("Webdriver.chrome.driver", "/Users/Raimonda/Downloads/chromedriver/chromedriver");
        System.setProperty("webdriver.chrome.driver", "C:/Users/XPS 15/Downloads/chromedriver_win32 (1)/" +
                "chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "C:/Users/XPS 15/Downloads/geckodriver-v0.33.0-win32/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ZuzaDraiveriai.driver = new ChromeDriver(options);
        ZuzaDraiveriai.driver.manage().window().maximize();


    }
//    @Test
//    public void A_registracijosPasiekimas(){
//            ZuzaRegistracija.slapukas();
//            ZuzaRegistracija.prisiregistruoti("Nakciausias5098@gmail.com", "Grazuma8597");
//    }
//
//    @Test
//    public void B_blogaRegistracija(){
//        ZuzaRegistracija.prisiregistruoti("Geguteskukuoja@@gmail.com", "kukukukuku");
//

    //
//    @Test
//    public void C_blogasPrisijungimas(){
//        ZuzaDraiveriai.zuzaPuslapis();
//        ZuzaPrisijungimas.prisijungimas("pumabera@gmaiil.com", "baigiamasis");
//    }
//
    @Test
    public void D_prisijungimas() {
        ZuzaDraiveriai.zuzaPuslapis();
        ZuzaPrisijungimas.prisijungimas("Nakciausias50987@gmail.com", "Grazuma8597");
    }


//    @Test
//    public void F_paieska(){
//        PaieskosLaukas.zuzaPaieska();
//    }
//
//    @Test
//    public void E_pirkiniai(){
//        PirkiniuKrepselis.zuzaPirkiniai();
//    }

//    @Test
//    public void G_naikinamaPaskyra(){
//            ZuzaRegistracija.paskyrosNaikinimas();
//    }

//    @Test
//    public void H_megstamiausiuPirkiniuKrepselis() throws InterruptedException {
//        ZuzaMegstamiausiuSarasas.MegstamiausiuSarasas();
//
//  }

//   @Test
//   public void I_naikinamasMegstamiausiuPirkiniuSarasas() throws InterruptedException {
//       ZuzaMegstamiausiuSarasas.MegstamiausiuSarasas();
//       ZuzaMegstamiausiuSarasas.MegstamiausiuSarasoNaikinimas();
//   }

//    @Test
//    public void J_redagavimasProfilio() throws InterruptedException {
//        ZuzaPrisijungimas.prisijungimas("Nakciausias50987@gmail.com", "Murmaliai853");
//        ZuzaProfilioRedagavimas.profilioRedagavimas();
//        ZuzaProfilioRedagavimas.slaptazodzioKeitimas("Murmaliai853", "Grazuma8597");
//    }

//    @Test
//    public void K_prekesGrazinimas() throws InterruptedException {
//        ZuzaPrekesGrazinimas.prekesGrazinimas();
//        ZuzaPrekesGrazinimas.puslapioPaveikslelis();
//    }

//        @Test
//        public void I_klausimasDelNepateiktoUzsakymo () throws InterruptedException, AWTException {
//
//            ZuzaNepateiktasUzsakymas.klausimasDelNepateiktoUzsakymo();
//        }


        @AfterClass
        public static void tearDown () {
//            driver.quit();
        }
    }





