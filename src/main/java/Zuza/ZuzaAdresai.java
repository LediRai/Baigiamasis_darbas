package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ZuzaAdresai extends ZuzaDraiveriai {

    public ZuzaAdresai(WebDriver driver) {
        super(driver);
    }

    private final static By prisijungti = By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/div[1]/a[1]");

    private final static By pristatymoAdresasai = By.cssSelector("body > main > div.user__container.container > " +
            "div.user__aside > nav > ul > li:nth-child(3) > a > span");
    private final static By naujasAdresas = By.cssSelector("body > main > div.user__container.container > " +
            "div.user__main > div > div > a");
    private final static By fVardas = By.cssSelector("#deliveries-update > div:nth-child(4) > input");
    private final static By fPavarde = By.cssSelector("#deliveries-update > div:nth-child(5) > input");
    private final static By fPastas = By.cssSelector("#deliveries-update > div:nth-child(6) > input");
    private final static By fTelNr = By.cssSelector("#deliveries-update > div:nth-child(7) > input");
    private final static By fMiestas = By.cssSelector("#deliveries-update > div:nth-child(8) > div:nth-child(2) > input");
    private final static By fAdresas = By.cssSelector("#deliveries-update > div:nth-child(8) > div." +
            "user-delivery__box.form-profile__box.form-group.js--person-address > input");
    private final static By fPastoKodas = By.cssSelector("#deliveries-update > div:nth-child(8) > " +
            "div.user-delivery__box--code.form-profile__box.form-group.js--person-address > input");
    private final static By fMygtukas = By.cssSelector("#deliveries-update > button");

    // fizinio asmens adresas
    public static void pridetiNaujaAdresaF() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement zuzaPrisijungimas = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungti));
            zuzaPrisijungimas.click();

            WebElement adresuSarasas = wait.until(ExpectedConditions.elementToBeClickable(pristatymoAdresasai));
            adresuSarasas.click();

            WebElement naujasAdresasF = wait.until(ExpectedConditions.elementToBeClickable(naujasAdresas));
            naujasAdresasF.click();

            WebElement vardasF = wait.until(ExpectedConditions.visibilityOfElementLocated(fVardas));
            vardasF.sendKeys("Vardenis");

            WebElement pavardeF = wait.until(ExpectedConditions.visibilityOfElementLocated(fPavarde));
            pavardeF.sendKeys("Pavardenis");

            WebElement pastasF = wait.until(ExpectedConditions.visibilityOfElementLocated(fPastas));
            pastasF.sendKeys("pumabera@gmail.com");

            WebElement telnrF = wait.until(ExpectedConditions.visibilityOfElementLocated(fTelNr));
            telnrF.sendKeys("+37061111111");

            WebElement miestasF = wait.until(ExpectedConditions.visibilityOfElementLocated(fMiestas));
            miestasF.sendKeys("Kaunas");

            WebElement adresasF = wait.until(ExpectedConditions.visibilityOfElementLocated(fAdresas));
            adresasF.sendKeys("kiemu g 123");

            WebElement pastoKodasF = wait.until(ExpectedConditions.visibilityOfElementLocated(fPastoKodas));
            pastoKodasF.sendKeys("41820");
            Thread.sleep(2000);

            WebElement irasymoMygtukas = wait.until(ExpectedConditions.elementToBeClickable(fMygtukas));
            jse.executeScript("arguments[0].scrollIntoView();", irasymoMygtukas);
            Thread.sleep(1000);
            irasymoMygtukas.click();

        } catch (Exception e) {
            System.out.println("neveikia prisijungimo mygtukas");
        }
    }
}