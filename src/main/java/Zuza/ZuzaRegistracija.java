package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ZuzaRegistracija extends ZuzaDraiveriai {


    public ZuzaRegistracija(WebDriver driver) {
        super(driver);
    }

    private final static By prisijungtiMygtukas = By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/div[1]/a[1]");
    private final static By registruotisMygtukas = By.xpath("/html/body/main/div[1]/div/div[2]/div[1]/div[1]/button");
    private final static By ivestiElPasta = By.xpath("//*[@id=\"form-signup\"]/div[1]/input");
    private final static By ivestiSlaptazodi = By.xpath("//*[@id=\"pwd\"]");
    private final static By ivestiSlaptazodi2 = By.xpath("//*[@id=\"form-signup\"]/div[3]/input");
    private final static By sutiktiSuTaisyklemis = By.xpath("//*[@id=\"form-signup\"]/div[4]/label/span[1]");
    private final static By uzsiregistruoti = By.xpath("//*[@id=\"form-signup\"]/button");
    private final static By profylioMygtukas = By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/div[1]/a[1]");
    private final static By naikinimasSlaptaz = By.xpath("/html/body/main/div[2]/div[2]/div/form/div/input");
    private final static By redaguotiProfili = By.xpath("/html/body/main/div[2]/div[2]/div/a");
    private final static By mygtukasSalinti = By.xpath("/html/body/main/div[2]/div[2]/div/form/button");


    public static void slapukas() {
        WebElement slapukas = driver.findElement(By.cssSelector("body > footer > div.footer__cookies.cookies.js--cookies.active > div > button"));
        slapukas.click();
    }


    public static void prisiregistruoti(String elPastas, String slaptazodis) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement chatWidget = driver.findElement(By.id("chat-widget-container"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].remove()", chatWidget);


        try {

            WebElement ieiti = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungtiMygtukas));
            ieiti.click();
            Thread.sleep(2000);

            WebElement paspaustiRegistruotis = wait.until(ExpectedConditions.visibilityOfElementLocated(registruotisMygtukas));
            paspaustiRegistruotis.click();
            Thread.sleep(2000);

            WebElement ivestiElPasta1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ivestiElPasta));
            ivestiElPasta1.sendKeys(elPastas);
            Thread.sleep(2000);

            WebElement ivestiSlaptazodi1 = wait.until(ExpectedConditions.visibilityOfElementLocated(ivestiSlaptazodi));
            ivestiSlaptazodi1.sendKeys(slaptazodis);
            Thread.sleep(2000);

            WebElement ivestiSlaptazodi3 = wait.until(ExpectedConditions.visibilityOfElementLocated(ivestiSlaptazodi2));
            ivestiSlaptazodi3.sendKeys(slaptazodis);
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


    public static void paskyrosNaikinimas(){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try {

            WebElement ieiti = wait.until(ExpectedConditions.visibilityOfElementLocated(profylioMygtukas));
            ieiti.click();
            Thread.sleep(2000);

            WebElement profilis = wait.until(ExpectedConditions.visibilityOfElementLocated(redaguotiProfili));
            profilis.click();
            Thread.sleep(2000);

            WebElement panaikinimoSlaptazodis = wait.until(ExpectedConditions.visibilityOfElementLocated(naikinimasSlaptaz));
            panaikinimoSlaptazodis.sendKeys("Grazuma8597");
            Thread.sleep(2000);

            WebElement panaikintiMygtukas = wait.until(ExpectedConditions.visibilityOfElementLocated(mygtukasSalinti));
            jse.executeScript("arguments[0].scrollIntoView();", panaikintiMygtukas);
            Thread.sleep(1000);
            panaikintiMygtukas.click();
            Thread.sleep(2000);

        } catch (Exception n){
            System.out.println("paskyra nepanaikinta" + n.getMessage());
        }
    }

}
