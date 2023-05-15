package Zuza;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
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
    public static void setUpChrome() {
        System.setProperty("Webdriver.chrome.driver", "/Users/Raimonda/Downloads/chromedriver/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "C:/Users/XPS 15/Downloads/chromedriver_win32 (1)/" +
//                "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ZuzaDraiveriai.driver = new ChromeDriver(options);
        ZuzaDraiveriai.driver.manage().window().maximize();
//        Db_Conection.prisijungimasPrieDB();
//        Db_Conection.testasDB();
    }

//    @BeforeClass
//    public static void setUpFirefox() {
//        System.setProperty("Webdriver.chrome.driver", "/Users/Raimonda/Downloads/geckodriver");
//        //       System.setProperty("webdriver.chrome.driver", "C:/Users/XPS 15/Downloads/chromedriver_win32/chromedriver.exe");
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--disable-notifications");
//        ZuzaDraiveriai.driver = new FirefoxDriver(options);
//        ZuzaDraiveriai.driver.manage().window().maximize();
//    }

//    @Test
//    public void A_blogaRegistracija() {
//        ZuzaRegistracija.slapukas();
//        ZuzaRegistracija.prisiregistruoti("Geguteskukuoja@@gmail.com", "kukukukuku");
//    }
//
//    @Test
//    public void B_registracijosPasiekimas() {
//        ZuzaRegistracija.prisiregistruoti("Nakciausias5098@gmail.com", "Grazuma8597");
//    }
//
//    @Test
//    public void C_blogasPrisijungimas() {
//        ZuzaPrisijungimas.prisijungimas("pumabera@gmaiil.com", "baigiamasis");
//    }
//
//    @Test
//    public void D_prisijungimas() {
//        ZuzaPrisijungimas.prisijungimas("Nakciausias5098@gmail.com", "Grazuma8597");
//    }

//        @Test
//    public void E_redagavimasProfilio() throws InterruptedException {
//       // ZuzaPrisijungimas.prisijungimas("Nakciausias50987@gmail.com", "Murmaliai853");
//        ZuzaProfilioRedagavimas.profilioRedagavimas();
//        ZuzaProfilioRedagavimas.slaptazodzioKeitimas("Grazuma8597", "Murmaliai853");
//    }

//    @Test
//    public void F_paieska() {
//        PaieskosLaukas.zuzaPaieska();
//    }

//    @Test
//    public void G_megstamiausiuPirkiniuKrepselis() throws InterruptedException {
//        ZuzaMegstamiausiuSarasas.MegstamiausiuSarasas();
//    }

//    @Test
//    public void H_naikinamasMegstamiausiuPirkiniuSarasas() throws InterruptedException {
////        ZuzaMegstamiausiuSarasas.MegstamiausiuSarasas();
//        ZuzaMegstamiausiuSarasas.MegstamiausiuSarasoNaikinimas();
//    }

//    @Test
//    public void I_pirkiniai() {
//        PirkiniuKrepselis.zuzaPirkiniai();
//    }
//
//    @Test
//    public void J_prekesGrazinimas() throws InterruptedException {
//        ZuzaPrekesGrazinimas.prekesGrazinimas();
//        ZuzaPrekesGrazinimas.puslapioPaveikslelis();
//    }
//
//    @Test
//    public void K_klausimasDelNepateiktoUzsakymo() throws InterruptedException, AWTException {
//        ZuzaNepateiktasUzsakymas.klausimasDelNepateiktoUzsakymo();
//    }
//
//    @Test
//    public void L_meniuTest(){
//        ZuzaMeniu.testuoju();
//    }
//    @Test
//    public void M_naikinamaPaskyra() {
//        ZuzaRegistracija.paskyrosNaikinimas("Grazuma8597");
//    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}



