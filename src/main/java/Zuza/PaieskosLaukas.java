package Zuza;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaieskosLaukas extends ZuzaDraiveriai {

    public PaieskosLaukas(WebDriver driver) {
        super(driver);
    }

    public static void zuzaPaieska() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String[] paieska = { "salmas", "laikrodis", "krosnis", "veidrodis", "pinigine"};

        // prekiu paieskos ciklas per masyvo elementus
        for (String i : paieska) {
            try {
                driver.get("https://zuza.lt/");
                WebElement ieskoti = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[2]/form/input"));
                wait.until(ExpectedConditions.elementToBeClickable(ieskoti));
                ieskoti.clear();
                ieskoti.sendKeys(i);
                ieskoti.submit();

                WebElement iskomosPrekesMatomumas = driver.findElement(By.className("card-box__heading"));
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", iskomosPrekesMatomumas);
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Testas nepavyksta: " + e.getMessage());
            }
        }
    }
}

