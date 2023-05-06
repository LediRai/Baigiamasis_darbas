package SkonisIrKvapas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SkonirIrKvapasPrisijungimas extends SkonisIrKvapasBase {
    public SkonirIrKvapasPrisijungimas(WebDriver driver) {
        super(driver);
    }
    private final static By prisijungtiRegostruotis = By.xpath("//*[@id=\"app\"]/header/div[2]/div/div/div[4]/div[2]/div/p[1]/a");
    private final static By isjungtiPrenumerata = By.xpath("//*[@id=\"omnisend-form-62ff76408bb40ed4b93ea2eb-close-button\"]");
    private final static By vardas = By.cssSelector("#login-form > section > div:nth-child(2) > div.col-md-6.w-full > input");
    private final static By slaptazodis = By.cssSelector("#login-form > section > div:nth-child(3) > div.col-md-6.w-full > div > input");
    private final static By prisijungimoMygtukas = By.cssSelector("#submit-login");

public static void slapukas(){
    WebElement slapukas = driver.findElement(By.xpath("//*[@id=\"lgcookieslaw_accept\"]"));
    slapukas.click();
}

public  static void prisijungimas(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    try {
        WebElement skprisijungimas = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungtiRegostruotis));
        skprisijungimas.click();
        Thread.sleep(2000);
        System.out.println("pirmas uzejimas i prisijungima");

        WebElement prenumerata = wait.until(ExpectedConditions.elementToBeClickable(isjungtiPrenumerata));
        prenumerata.click();
        // Perkeliu peles rodykle i x=0 y=0 kordinates, kad neliktu aksesuarai mygtuko ir neliktu pasaliniu langu.
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).perform();
        Thread.sleep(2000);
        System.out.println("prenumeratos naikinimas");

        WebElement skVardas = wait.until(ExpectedConditions.visibilityOfElementLocated(vardas));
        skVardas.sendKeys("pumabera@gmail.com");
        Thread.sleep(2000);
        System.out.println("vardo suvedimas");

        WebElement skSlaptazodis = wait.until(ExpectedConditions.elementToBeClickable(slaptazodis));
        skSlaptazodis.sendKeys("baigiamasis");
        Thread.sleep(2000);
        System.out.println("slaptazodzio suvedimas");

        WebElement skPrisijungimoMygtukas = wait.until(ExpectedConditions.elementToBeClickable(prisijungimoMygtukas));
        skPrisijungimoMygtukas.click();
        Thread.sleep(2000);
        System.out.println("prisijungimas");

    }catch (Exception e) {
        System.out.println("neveikia");
    }

    }

}
