package SkonisIrKvapas;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SkonisIrKvapasBase {
    protected static WebDriver driver;

    public SkonisIrKvapasBase(WebDriver driver) {     // konstruktoriu, jis turi buti toks pats kaip klases pavadinimas
        SkonisIrKvapasBase.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.skonis-kvapas.lt/");
    }
    public static void skSvetaine() {
        driver.get("https://www.skonis-kvapas.lt/");;
    }
}
