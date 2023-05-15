package Zuza;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ZuzaProfilioRedagavimas extends ZuzaPrisijungimas {


    public final static By profilioPasiekimas = By.cssSelector(".tactic__circle");
    public final static By profilioRedagavimoMygtukas = By.cssSelector("body > main > div.user__container.container > div.user__main > div > a");
    static JavascriptExecutor jse = (JavascriptExecutor) driver;



    public ZuzaProfilioRedagavimas(WebDriver driver) {

        super(driver);
    }

    public static void profilioRedagavimas() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        try {

            WebElement profilis = driver.findElement(profilioPasiekimas);
            profilis.click();

            WebElement paspaustiMygtuka = driver.findElement(profilioRedagavimoMygtukas);
            paspaustiMygtuka.click();

            WebElement lytiesLokacija = driver.findElement(By.xpath("//*[@id=\"profile-update\"]/div[2]/div/div[1]/button"));
            lytiesLokacija.click();

            WebElement lytisVyras = driver.findElement(By.xpath("//*[@id=\"profile-update\"]/div[2]/div/div[2]/div/div/div[2]"));
            lytisVyras.click();


//            Select lytiesPasirinkimai = new Select(driver.findElement(lytiesPasirinkimas));
//            lytiesPasirinkimai.click();
//            String pasirinkimas = "Vyriškas";
//            lytiesPasirinkimai.selectByVisibleText("Vyriškas");
//            var selectedOptions = lytiesPasirinkimai.getAllSelectedOptions();
//            assertEquals(1, selectedOptions.size());
//            assertEquals(pasirinkimas, selectedOptions.get(0).getAttribute("value"));

            // gimimos datos ivedimas - data susiveda, bet ties pavarde ir telefonu metamos klaidos
            WebElement gimimoData = driver.findElement(By.xpath("//input[@placeholder='YYYY-MM-DD']"));
            gimimoData.click();
            jse.executeScript("arguments[0].value='1985-04-20';", gimimoData);


            // vardo ivedimas
            WebElement ivestiVarda = driver.findElement(By.xpath("//*[@id=\"profile-update\"]/div[4]/input"));
            ivestiVarda.clear();
            ivestiVarda.sendKeys("Varlius");
            Thread.sleep(1000);

            //pavardes ivedimas
            WebElement ivestiPavarde = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profile-update\"]/div[5]/input")));
            ivestiPavarde.clear();
            ivestiPavarde.sendKeys("Varliukas");
            Thread.sleep(1000);
            ivestiPavarde.submit();


            // telefono ivedimas
            WebElement ivestiTelefona = driver.findElement(By.xpath("//input[@name='phone']"));
            ivestiTelefona.sendKeys("+37065547965");
            Thread.sleep(2000);


            // pakeitimu saugojimas
            WebElement issaugotiPakeitimus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"profile-update\"]/button")));
            jse.executeScript("arguments[0].scrollIntoView();", issaugotiPakeitimus);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(issaugotiPakeitimus));
            issaugotiPakeitimus.click();
            Thread.sleep(3000);

        } catch (Exception s) {
            System.out.println("Paskyros redagavimas negalimas: " + s.getMessage());
        }
    }

    public static void slaptazodzioKeitimas(String esamasSlaptazodis, String naujasSlaptazodis) throws
            InterruptedException {

        try {

            WebElement dabartinioSlaptazodzioIvedimas = driver.findElement(By.xpath("//*[@id=\"password-update\"]/div[1]/input"));
            dabartinioSlaptazodzioIvedimas.sendKeys(esamasSlaptazodis);

            WebElement naujoSlaptazodzioIvedimas = driver.findElement(By.xpath("//*[@id=\"password-update\"]/div[2]/input"));
            naujoSlaptazodzioIvedimas.sendKeys(naujasSlaptazodis);

            WebElement naujoSlaptazodzioIvedimas2 = driver.findElement(By.xpath("//*[@id=\"password-update\"]/div[3]/input"));
            naujoSlaptazodzioIvedimas2.sendKeys(naujasSlaptazodis);

            WebElement slaptazodzioPakeitimoIssaugojimas = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/div/div[3]/form/button"));
            Thread.sleep(2000);
            slaptazodzioPakeitimoIssaugojimas.click();

        } catch (Exception r) {
            System.out.println("Slaptazodzio keitimas nesekmingas: " + r.getMessage());
        }
    }
}
