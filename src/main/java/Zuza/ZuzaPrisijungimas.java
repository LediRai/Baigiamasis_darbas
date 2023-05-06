package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ZuzaPrisijungimas extends Zuza.ZuzaDraiveriai {
    public ZuzaPrisijungimas(WebDriver driver) {
        super(driver);
    }

    private final static By prisijungti = By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/div[1]/a[1]");
    private final static By elPastas = By.cssSelector("#form-login > div:nth-child(3) > input");
    private final static By slaptazodis = By.cssSelector("#form-login > div:nth-child(4) > input");
    private final static By prisijungimoMygtukas = By.cssSelector("#form-login > button");

    public static void slapukas() {
        WebElement slapukas = driver.findElement(By.cssSelector("body > footer > div.footer__cookies.cookies.js--cookies.active > div > button"));
        slapukas.click();
    }

    public static void prisijungimas(String prvardas, String prslaptazodis) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement skprisijungimas = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungti));
            skprisijungimas.click();
            Thread.sleep(2000);

            WebElement skVardas = wait.until(ExpectedConditions.visibilityOfElementLocated(elPastas));
            //skVardas.sendKeys("pumabera@gmail.com");
            skVardas.sendKeys(prvardas);
            Thread.sleep(2000);

            WebElement skSlaptazodis = wait.until(ExpectedConditions.elementToBeClickable(slaptazodis));
            //skSlaptazodis.sendKeys("baigiamasis");
            skSlaptazodis.sendKeys(prslaptazodis);
            Thread.sleep(2000);

            WebElement mygtukas = wait.until(ExpectedConditions.elementToBeClickable(prisijungimoMygtukas));
           mygtukas.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("neveikia prisijungimo mygtukas");
        }
    }
}
