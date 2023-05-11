package Zuza;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ZuzaDraiveriai {
    protected static  WebDriver driver;

    public ZuzaDraiveriai(WebDriver driver) {
        ZuzaDraiveriai.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://zuza.lt/");
    }


//    public ZuzaDraiveriai(FirefoxDriver driver) {
//        ZuzaDraiveriai.driver = driver;
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();

        public static void zuzaPuslapis () {
            driver.get("https://zuza.lt/");
        }
    }
