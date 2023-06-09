package Zuza;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ZuzaRegistracija extends ZuzaDraiveriai {

    public ZuzaRegistracija(WebDriver driver) {
        super(driver);
    }

    private final static By prisijungtiMygtukas = By.xpath("/html/body/div[1]/div[2]/div/div/" +
            "div[4]/div[1]/a[1]");
    private final static By registruotisMygtukas = By.xpath("/html/body/main/div[1]/div/div[2]" +
            "/div[1]/div[1]/button");
    private final static By ivestiElPasta = By.xpath("//*[@id=\"form-signup\"]/div[1]/input");
    private final static By ivestiSlaptazodi = By.xpath("//*[@id=\"pwd\"]");
    private final static By ivestiSlaptazodi2 = By.xpath("//*[@id=\"form-signup\"]/div[3]/input");
    private final static By sutiktiSuTaisyklemis = By.xpath("//*[@id=\"form-signup\"]/div[4]/label" +
            "/span[1]");
    private final static By uzsiregistruoti = By.xpath("//*[@id=\"form-signup\"]/button");
    private final static By profylioMygtukas = By.xpath("/html/body/div[1]/div[2]/div/div/div[4]/" +
            "div[1]/a[1]");
    private final static By naikinimasSlaptaz = By.xpath("/html/body/main/div[2]/div[2]/div/form/" +
            "div/input");
    private final static By redaguotiProfili = By.xpath("/html/body/main/div[2]/div[2]/div/a");
    private final static By mygtukasSalinti = By.xpath("/html/body/main/div[2]/div[2]/div/form/" +
            "button");

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static JavascriptExecutor jse = (JavascriptExecutor) driver;


    public static void slapukas() {
        WebElement slapukas = driver.findElement(By.xpath("/html/body/footer/div[4]/div/button"));
        slapukas.click();
    }


    public static void prisiregistruoti(String elPastas, String slaptazodis) {

        WebElement chatWidget = driver.findElement(By.id("chat-widget-container"));
        jse.executeScript("arguments[0].remove()", chatWidget);

        try {
            WebElement ieiti = wait.until(ExpectedConditions.visibilityOfElementLocated(prisijungtiMygtukas));
            ieiti.click();
            Thread.sleep(2000);

            WebElement paspaustiRegistruotis = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (registruotisMygtukas));
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

            WebElement registruotisPaskutinisEtapas = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (uzsiregistruoti));
            registruotisPaskutinisEtapas.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Registracija nebuvo sėkminga" + e.getMessage());
        }
    }


    public static void paveiksliukas() {

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


    public static void paskyrosNaikinimas(String slaptazodis) {
        try {
            WebElement ieiti = wait.until(ExpectedConditions.visibilityOfElementLocated(profylioMygtukas));
            ieiti.click();
            Thread.sleep(2000);

            WebElement profilis = wait.until(ExpectedConditions.visibilityOfElementLocated(redaguotiProfili));
            profilis.click();
            Thread.sleep(2000);

            WebElement panaikinimoSlaptazodis = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (naikinimasSlaptaz));
            panaikinimoSlaptazodis.sendKeys(slaptazodis);
            Thread.sleep(2000);

            WebElement panaikintiMygtukas = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (mygtukasSalinti));
            jse.executeScript("arguments[0].scrollIntoView();", panaikintiMygtukas);
            Thread.sleep(1000);
            panaikintiMygtukas.click();
            Thread.sleep(2000);
        } catch (Exception n) {
            System.out.println("paskyra nepanaikinta" + n.getMessage());
        }
    }
}
