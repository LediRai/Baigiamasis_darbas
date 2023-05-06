package Zuza;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ZuzaDraiveriai {
    protected static WebDriver driver;

    public ZuzaDraiveriai(WebDriver driver) {     // konstruktoriu, jis turi buti toks pats kaip klases pavadinimas
        ZuzaDraiveriai.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://zuza.lt/");
    }
    public static void zuzaPuslapis() {
        driver.get("https://zuza.lt/");
    }
}
