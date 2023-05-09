package Zuza;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class PaieskosLaukas extends ZuzaDraiveriai {
    public PaieskosLaukas(WebDriver driver) {
        super(driver);
    }

    public static void zuzaPaieska() {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

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

            } catch (Exception e) {
                System.out.println("Testas nepavyksta: " + e.getMessage());
            }
        }
    }
}

