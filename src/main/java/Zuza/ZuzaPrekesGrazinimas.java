package Zuza;

import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;

public class ZuzaPrekesGrazinimas extends ZuzaDraiveriai {

    public ZuzaPrekesGrazinimas(WebDriver driver) {
        super(driver);
    }

    public final static By grąžinimas = By.xpath("/html/body/div[1]/div[1]/div/nav/ul/li[3]/a");
    public final static By vardas = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[2]/input");
    public final static By pavarde = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[3]/input");
    public final static By elPastas = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[4]/input");
    public final static By saskaita = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[5]/input");
    public final static By usakymoNumeris = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[6]/input");
    public final static By uzsakymoData = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[7]/input");
    public final static By prekesPavadinimas = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[8]" +
            "/input");
    public final static By prekesKodas = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[9]/input");
    public final static By kiekis = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[10]/input");
    public final static By grazinimoPriezastis = By.xpath("//*[@id=\"return-and-warranty-form\"]/div" +
            "[11]/label[4]/span[2]");
    public final static By pakuotesStatusas = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[12]" +
            "/label[2]/span[2]");
    public final static By zinute = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[13]/textarea");
    public final static By sutiktiSuTaisyklem = By.xpath("//*[@id=\"return-and-warranty-form\"]/div[14]");
    public final static By pateiktiForma = By.xpath("/html/body/main/div[2]/div[2]/form/div[14]/button");

    static JavascriptExecutor jse = (JavascriptExecutor) driver;


    public static void prekesGrazinimas() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
            WebElement grazinimoIrGarantijosMygtukas = driver.findElement(grąžinimas);
            grazinimoIrGarantijosMygtukas.click();

            WebElement vardoSuvedimas = driver.findElement(vardas);
            wait.until(ExpectedConditions.visibilityOf(vardoSuvedimas));
            vardoSuvedimas.sendKeys("Zuzius");

            WebElement pavardesSuvedimas = driver.findElement(pavarde);
            wait.until(ExpectedConditions.visibilityOf(pavardesSuvedimas));
            pavardesSuvedimas.sendKeys("Zuziauskas");

            WebElement elPastoSuvedimas = driver.findElement(elPastas);
            wait.until(ExpectedConditions.visibilityOf(elPastoSuvedimas));
            elPastoSuvedimas.sendKeys("zuziukas@gmail.com");

            WebElement saskaitosSuvedimas = driver.findElement(saskaita);
            wait.until(ExpectedConditions.visibilityOf(saskaitosSuvedimas));
            saskaitosSuvedimas.sendKeys("LT002525333344445555");

            WebElement uzsakymoNumerioSuvedimas = driver.findElement(usakymoNumeris);
            wait.until(ExpectedConditions.visibilityOf(uzsakymoNumerioSuvedimas));
            uzsakymoNumerioSuvedimas.sendKeys("101100");

            WebElement datosSuvedimas = driver.findElement(uzsakymoData);
            wait.until(ExpectedConditions.visibilityOf(datosSuvedimas));
            jse.executeScript("arguments[0].value='02/02/2023';", datosSuvedimas);

            WebElement prekesPavadinimoSuvedimas = driver.findElement(prekesPavadinimas);
            wait.until(ExpectedConditions.visibilityOf(prekesPavadinimoSuvedimas));
            prekesPavadinimoSuvedimas.sendKeys("LED lempa");

            WebElement prekesKodoSuvedimas = driver.findElement(prekesKodas);
            wait.until(ExpectedConditions.visibilityOf(prekesKodoSuvedimas));
            Thread.sleep(2000);
            prekesKodoSuvedimas.sendKeys("A27360265126");
            prekesKodoSuvedimas.sendKeys(Keys.ENTER);

            WebElement kiekioSuvedimas = driver.findElement(kiekis);
            wait.until(ExpectedConditions.visibilityOf(kiekioSuvedimas));
            kiekioSuvedimas.sendKeys("2");
            kiekioSuvedimas.submit();

            try {
                WebElement priezastiesPateikimas = driver.findElement(grazinimoPriezastis);
                jse.executeScript("arguments[0].scrollIntoView();", priezastiesPateikimas);
                wait.until(ExpectedConditions.elementToBeClickable(priezastiesPateikimas));
                Thread.sleep(1000);
                priezastiesPateikimas.click();
            } catch (Exception e) {
                System.out.println("Grazinimo priezastis nepasirinkta: " + e.getMessage());
            }

            WebElement pakuote = driver.findElement(pakuotesStatusas);
            wait.until(ExpectedConditions.elementToBeClickable(pakuote));
            pakuote.click();

            WebElement zinutesIvestis = driver.findElement(zinute);
            wait.until(ExpectedConditions.elementToBeClickable(zinutesIvestis));
            zinutesIvestis.sendKeys("Laba diena, norėčiau grąžinti prekę dėl aukščiau nurodytos " +
                    "priežasties.");
            Thread.sleep(3000);
            zinutesIvestis.submit();

            try {
                WebElement pritarimasTaisyklems = driver.findElement(sutiktiSuTaisyklem);
                jse.executeScript("arguments[0].scrollIntoView();", pritarimasTaisyklems);
                wait.until(ExpectedConditions.visibilityOf(pritarimasTaisyklems));
                Thread.sleep(3000);
                pritarimasTaisyklems.click();
            } catch (Exception e) {
                System.out.println("Pritarimo taisyklems mygtukas nepaspaustas: " + e.getMessage());
            }

            try {
                WebElement formosPateikimas = driver.findElement(pateiktiForma);
                jse.executeScript("arguments[0].scrollIntoView();", formosPateikimas);
                wait.until(ExpectedConditions.elementToBeClickable(formosPateikimas));
                Thread.sleep(3000);
                formosPateikimas.click();
            } catch (Exception e) {
                System.out.println("Formos pateikimas negalimas: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Forma pateikta neteisingai" + e.getMessage());
        }
    }

    public static void puslapioPaveikslelis() throws InterruptedException {

        //paeiti į puslapio vidury
        jse.executeScript("window.scrollTo(0, 200)");
        Thread.sleep(3000);
        WebElement vieta = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/form/div[5]"));
        jse.executeScript("arguments[0].scrollIntoView();", vieta);
        Thread.sleep(3000);

        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
            BufferedImage screenshotImage = ImageIO.read(screenshotFile);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = dateFormat.format(new Date());
            String directoryPath = "C://Users//XPS 15//Documents//GitHub//Baigiamasis_darbas//";
            String fileName = directoryPath + "screenshot_" + timestamp + ".png";

            try (OutputStream out = new FileOutputStream(fileName)) {
                ImageIO.write(screenshotImage, "png", out);
                System.out.println("Screenshot saved: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (WebDriverException e) {
            e.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}