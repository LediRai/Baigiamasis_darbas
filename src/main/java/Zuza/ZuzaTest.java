package Zuza;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZuzaTest extends ZuzaDraiveriai {

            public ZuzaTest() {

            super(driver);
        }

    @BeforeClass
    public static void setUp() {
//       System.setProperty("Webdriver.chrome.driver", "/Users/Raimonda/Downloads/chromedriver/chromedriver");
       System.setProperty("webdriver.chrome.driver", "C:/Users/XPS 15/Downloads/chromedriver_win32/chromedriver.exe");
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
    public void D_prisijungimas(){
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

//   @Test
//   public void H_megstamiausiuPirkiniuKrepselis() throws InterruptedException {
//            ZuzaMegstamiausiuSarasas.MegstamiausiuSarasas();

//   }

//   @Test
//   public void I_naikinamasMegstamiausiuPirkiniuSarasas() throws InterruptedException {
//       ZuzaMegstamiausiuSarasas.MegstamiausiuSarasas();
//       ZuzaMegstamiausiuSarasas.MegstamiausiuSarasoNaikinimas();
//   }

    @Test
    public void J_redagavimasProfilio() throws InterruptedException {
        ZuzaPrisijungimas.prisijungimas("Nakciausias50987@gmail.com", "Murmaliai853");
        ZuzaProfilioRedagavimas.profilioRedagavimas();
        ZuzaProfilioRedagavimas.slaptazodzioKeitimas("Murmaliai853", "Grazuma8597");
    }

    @AfterClass
    public static void tearDown() {
//            driver.quit();
    }
}



