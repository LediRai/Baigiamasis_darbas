package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ZuzaNepateiktasUzsakymas extends ZuzaDraiveriai {

    public final static By kontaktai = By.xpath("/html/body/div[1]/div[1]/div/nav/ul/li[7]/a");

    public final static By nepateiktasUzsakymas = By.xpath("/html/body/main/div[2]/div[2]/div[3]/div[1]/button[1]");

    public final static By vardas = By.xpath("//*[@id=\"js--form-contact-product\"]/div[1]/input");
    public final static By elPastas = By.xpath("//*[@id=\"js--form-contact-product\"]/div[2]/input");
    public final static By skelbimoID = By.xpath("//*[@id=\"js--form-contact-product\"]/div[3]/input");
    public final static By zinute = By.xpath("//*[@id=\"js--form-contact-product\"]/div[4]/input");
    public final static By pridetiDokumenta = By.xpath("//*[@id=\"js--form-contact-product\"]/div[5]/label");
    public final static By siuntimoMygtukas = By.xpath("//*[@id=\"js--form-contact-product\"]/button");

    static JavascriptExecutor jse = (JavascriptExecutor) driver;

    public ZuzaNepateiktasUzsakymas(WebDriver driver) {
        super(driver);

    }

    public static void klausimasDelNepateiktoUzsakymo() throws InterruptedException, AWTException  {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        WebElement kontaktuotiZuza = driver.findElement(kontaktai);
        wait.until(ExpectedConditions.visibilityOf(kontaktuotiZuza));
        kontaktuotiZuza.click();


        WebElement vardoIvedimas = driver.findElement(vardas);
        jse.executeScript("arguments[0].scrollIntoView();", vardoIvedimas);
        wait.until(ExpectedConditions.visibilityOf(vardoIvedimas));
        Thread.sleep(3000);
        vardoIvedimas.sendKeys("Zuzius Zuzauskas");

        try {

            WebElement elPastoIvedimas = driver.findElement(elPastas);
            jse.executeScript("arguments[0].scrollIntoView();", elPastoIvedimas);
            wait.until(ExpectedConditions.visibilityOf(vardoIvedimas));
            Thread.sleep(3000);
            elPastoIvedimas.sendKeys("zuziuszuzauskas@gmail.com");
        } catch (Exception e) {
            System.out.println("Pašto nepavyko į vesti: " + e.getMessage());

        }

        try {
            WebElement skelbimoIvedimas = driver.findElement(skelbimoID);
            wait.until(ExpectedConditions.visibilityOf(skelbimoIvedimas));
            Thread.sleep(3000);
            skelbimoIvedimas.sendKeys("A27360134034");
        } catch (Exception e) {
            System.out.println("Nepavyko įvesti skelbimo numerio: " + e.getMessage());
        }

        try {
            WebElement paliktiZinute = driver.findElement(zinute);
            wait.until(ExpectedConditions.visibilityOf(paliktiZinute));
            Thread.sleep(3000);
            paliktiZinute.sendKeys("Jei pirkčiau 5 vienetus, ar galėtumėte pritaikyti nuolaidą?");
        } catch (Exception e) {
            System.out.println("Nepavyko palikti žinutės: " + e.getMessage());
        }

        try {
            WebElement dokumentoPridėjimas = driver.findElement(pridetiDokumenta);
            dokumentoPridėjimas.click();
            Thread.sleep(2000);

            // failo suradimas kompiuteryje pateikiant direktoriją ir jo pridėjimas

            String filePath = "\"C:\\Users\\XPS 15\\Documents\\GitHub\\Baigiamasis_darbas\\PAVYZDYS.png\"";
            Transferable transferable = new StringSelection(filePath);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(transferable, null);


            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e){
            System.out.println("Dokumento pridėti nepavyko: " + e.getMessage());


       // formos išsiuntimas
        }
        try {
            WebElement siusti = driver.findElement(siuntimoMygtukas);
            wait.until(ExpectedConditions.visibilityOf(siusti));
            Thread.sleep(3000);
            siusti.click();

        } catch (Exception e) {
            System.out.println("Nepavyko pateikti formos: " + e.getMessage());
        }



    }
}
