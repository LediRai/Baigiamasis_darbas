package Zuza;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;
import java.util.Objects;


public class ZuzaPrisijungimas extends Zuza.ZuzaDraiveriai {
    public ZuzaPrisijungimas(WebDriver driver) {
        super(driver);
    }

    private final static By prisijungti = By.xpath("/html/body/div/div[2]/div/div/div[4]/div/a");
    private final static By elPastas = By.cssSelector("#form-login > div:nth-child(3) > input");
    private final static By slaptazodis = By.cssSelector("#form-login > div:nth-child(4) > input");
    private final static By prisijungimoMygtukas = By.cssSelector("#form-login > button");
    private final static By atsijungti = By.cssSelector("body > main > div.user__container.container > div.user__main" +
            " > div > form > button");


    public static void prisijungimas(String prvardas, String prslaptazodis) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement zuzaPrisijungimas = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungti));
            if (Objects.equals(zuzaPrisijungimas.getAttribute("href"), "https://zuza.lt/profile/")) {
                zuzaPrisijungimas.click();
                WebElement zuzaAtsijungimas = wait.until(ExpectedConditions.visibilityOfElementLocated(atsijungti));
                zuzaAtsijungimas.click();
            }
            zuzaPrisijungimas = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungti));
            zuzaPrisijungimas.click();
            Thread.sleep(1000);

            WebElement zuzaElP = wait.until(ExpectedConditions.visibilityOfElementLocated(elPastas));
            zuzaElP.sendKeys(prvardas);
            Thread.sleep(1000);

            WebElement zuzaSlaptazodis = wait.until(ExpectedConditions.elementToBeClickable(slaptazodis));
            zuzaSlaptazodis.sendKeys(prslaptazodis);
            Thread.sleep(1000);

            WebElement mygtukas = wait.until(ExpectedConditions.elementToBeClickable(prisijungimoMygtukas));
            mygtukas.click();

            // tikrinama ar yra klaida suvedant ir pateikiant informacija, jei yra klaida daroma puslapio ekrano
            //nuotrauka kurioje matoma klaida .
            List<WebElement> errorCode = driver.findElements(By.className("error-custom"));
            if (errorCode.size() > 0) {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Path destinationPath = Path.of("screenshottest.png");
                try {
                    Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Klaidos nuotrauka issaugota: " + destinationPath.toAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Nepavyko issaugoti nuotraukos: " + e.getMessage());
                }
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("neveikia prisijungimo mygtukas");
        }
    }
}
