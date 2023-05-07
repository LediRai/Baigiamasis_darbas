package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class ZuzaPrisijungimas extends Zuza.ZuzaDraiveriai {
    public ZuzaPrisijungimas(WebDriver driver) {
        super(driver);
    }

    private final static By prisijungti = By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/div[1]/a[1]");
    private final static By elPastas = By.cssSelector("#form-login > div:nth-child(3) > input");
    private final static By slaptazodis = By.cssSelector("#form-login > div:nth-child(4) > input");
    private final static By prisijungimoMygtukas = By.cssSelector("#form-login > button");
    private final static By atsijungti =By.cssSelector("body > main > div.user__container.container > div.user__main > div > form > button");


    public static void prisijungimas(String prvardas, String prslaptazodis) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement zuzaPrisijungimas = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungti));
            System.out.println(zuzaPrisijungimas.getAttribute("href"));
            if (Objects.equals(zuzaPrisijungimas.getAttribute("href"), "https://zuza.lt/profile/")){
                zuzaPrisijungimas.click();
                WebElement zuzaAtsijungimas = wait.until(ExpectedConditions.visibilityOfElementLocated(atsijungti));
                zuzaAtsijungimas.click();

                // Atsijungimo aprasymas

            }

            zuzaPrisijungimas.click();
            Thread.sleep(2000);

            WebElement zuzaElP = wait.until(ExpectedConditions.visibilityOfElementLocated(elPastas));
            //skVardas.sendKeys("pumabera@gmail.com");
            zuzaElP.sendKeys(prvardas);
            Thread.sleep(2000);

            WebElement zuzaSlaptazodis = wait.until(ExpectedConditions.elementToBeClickable(slaptazodis));
            //skSlaptazodis.sendKeys("baigiamasis");
            zuzaSlaptazodis.sendKeys(prslaptazodis);
            Thread.sleep(2000);

            WebElement mygtukas = wait.until(ExpectedConditions.elementToBeClickable(prisijungimoMygtukas));
           mygtukas.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("neveikia prisijungimo mygtukas");
        }
    }
}
