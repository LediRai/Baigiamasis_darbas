import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registracija extends Zuza.ZuzaDraiveriai {

    public Registracija (WebDriver driver) {
        super(driver);
    }

    private final static By prisijungtiMygtukas = By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/div[1]/a[1]");
    private final static By registruotisMygtukas = By.xpath("/html/body/main/div[1]/div/div[2]/div[1]/div[1]/button");
    private final static By ivestiElPasta = By.xpath("//*[@id=\"form-signup\"]/div[1]/input");
    private final static By ivestiSlaptazodi = By.xpath("//*[@id=\"pwd\"]");
    private final static By ivestiSlaptazodi2 = By.xpath("//*[@id=\"form-signup\"]/div[3]/input");
    private final static By sutiktiSuTaisyklemis = By.xpath("//*[@id=\"form-signup\"]/div[4]/label/span[1]");
    private final static By uzsiregistruoti = By.xpath("//*[@id=\"form-signup\"]/button");

    public static void slapukas() {
        WebElement slapukas = driver.findElement(By.cssSelector("body > footer > div.footer__cookies.cookies.js--cookies.active > div > button"));
        slapukas.click();
    }


    public static  void prisiregistruoti() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            WebElement ieiti = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungtiMygtukas));
            ieiti.click();
            Thread.sleep(2000);


            WebElement paspaustiRegistruotis = wait.until(ExpectedConditions.visibilityOfElementLocated(registruotisMygtukas));
            paspaustiRegistruotis.click();
            Thread.sleep(2000);


            WebElement ivestiElPasta1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ivestiElPasta));
            ivestiElPasta1.sendKeys("Nakciausias5098@gmail.com");
            Thread.sleep(2000);

            WebElement ivestiSlaptazodi1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ivestiSlaptazodi));
            ivestiSlaptazodi1.sendKeys("Grazuma8597");
            Thread.sleep(2000);


            WebElement ivestiSlaptazodi3 = wait.until(ExpectedConditions.visibilityOfElementLocated(ivestiSlaptazodi2));
            ivestiSlaptazodi3.sendKeys("Grazuma8597");
            Thread.sleep(2000);


            WebElement taisykles = wait.until(ExpectedConditions.visibilityOfElementLocated(sutiktiSuTaisyklemis));
            taisykles.click();
            Thread.sleep(2000);


            WebElement registruotisPaskutinisEtapas = wait.until(ExpectedConditions.visibilityOfElementLocated(uzsiregistruoti));
            registruotisPaskutinisEtapas.click();
            Thread.sleep(2000);


        } catch (Exception e) {
            System.out.println("Registracija nebuvo sėkminga" + e.getMessage());
        }



    }
}
