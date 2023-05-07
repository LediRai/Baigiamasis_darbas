package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class PirkiniuKrepselis extends ZuzaDraiveriai {
    public PirkiniuKrepselis(WebDriver driver) {
        super(driver);
    }

    public static void zuzaPirkiniai() {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String[] paieska = { "salmas", "Kompiuteris", "Televizorius", "virykle", "pinigine"};

        // prekiu paieskos ciklas per masyvo elementus
        for (String i : paieska) {

            driver.get("https://zuza.lt/");
            WebElement ieskoti = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div[2]/form/input"));
            wait.until(ExpectedConditions.elementToBeClickable(ieskoti));
            ieskoti.clear();
            ieskoti.sendKeys(i);
            ieskoti.submit();
            try {
                Thread.sleep(5000);
                List<WebElement> pirkti = driver.findElements(By.className("card__wrapper"));
                jse.executeScript("arguments[0].scrollIntoView();", pirkti.get(0));
                wait.until(ExpectedConditions.elementToBeClickable(pirkti.get(0)));
                pirkti.get(0).click();
                Thread.sleep(1000);

                WebElement pridetiIKrepseli = driver.findElement(By.xpath("(//button[contains(text(),'PRIDĖTI Į KREPŠELĮ')])[1]"));
                // Naudoju JSexecutor kad pascrolintu langa iki elemento
                jse.executeScript("arguments[0].scrollIntoView();", pridetiIKrepseli);
                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(pridetiIKrepseli));
                pridetiIKrepseli.click();
                Thread.sleep(3000);


                WebElement testiApsipirkima = driver.findElement(By.xpath("//a[contains(text(),'tęsti apsipirkimą')]"));
                wait.until(ExpectedConditions.elementToBeClickable(testiApsipirkima));
                testiApsipirkima.click();
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println("Testas nepavyksta: " + e.getMessage());
            }

        }
    }


}
