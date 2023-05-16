package Zuza;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ZuzaDraiveriai {
    protected static WebDriver driver;
   // protected static WebDriver firefoxDriver;

    public ZuzaDraiveriai(WebDriver driver ) {

        ZuzaDraiveriai.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://zuza.lt/");

//        fireFoxDriver.get("https://zuza.lt/");
//        ZuzaDraiveriai.fireFoxDriver = fireFoxDriver;
//
//        fireFoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        fireFoxDriver.manage().window().maximize();
    }
//    public ZuzaDraiveriai(WebDriver driver, WebDriver firefoxDriver){
//        ZuzaDraiveriai.chromeDriver = driver;
//        ZuzaDraiveriai.firefoxDriver = firefoxDriver;
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        firefoxDriver.manage().window().maximize();
//        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//}

        public static void zuzaPuslapis () {
            driver.get("https://zuza.lt/");
//            fireFoxDriver.get("https://zuza.lt/");

        }}


