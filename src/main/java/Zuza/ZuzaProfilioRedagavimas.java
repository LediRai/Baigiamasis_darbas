package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ZuzaProfilioRedagavimas extends ZuzaPrisijungimas {


    public final static By profilioRedagavimoMygtukas = By.cssSelector(".registered-user__btn.btn");
//    public final static By lytiesPasirinkimas = By.xpath("//*[@id=\"profile-update\"]/div[2]/div/div[2]/div/div");

    public ZuzaProfilioRedagavimas(WebDriver driver) {

        super(driver);
    }

    public static void profilioRedagavimas() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        try {

            WebElement paspaustiMygtuka = driver.findElement(profilioRedagavimoMygtukas);
            paspaustiMygtuka.click();
            Thread.sleep(50);

            WebElement lytiesLokacija = driver.findElement(By.xpath("//*[@id=\"profile-update\"]/div[2]/div/div[1]/button"));
            lytiesLokacija.click();
            Thread.sleep(1000);

            WebElement lytisVyras = driver.findElement(By.xpath("//*[@id=\"profile-update\"]/div[2]/div/div[2]/div/div/div[2]"));
            lytisVyras.click();
            Thread.sleep(1000);

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
            gimimoData.sendKeys("05");
            gimimoData.sendKeys(Keys.ARROW_LEFT);
            Thread.sleep(1000);
            gimimoData.sendKeys("02");
            gimimoData.sendKeys(Keys.ARROW_LEFT);
            Thread.sleep(1000);
            gimimoData.sendKeys(Keys.ARROW_LEFT);
            gimimoData.sendKeys("1990");
            gimimoData.submit();

            // vardo ivedimas
            WebElement ivestiVarda = driver.findElement(By.xpath("//*[@id=\"profile-update\"]/div[4]/input"));
            ivestiVarda.clear();
            ivestiVarda.sendKeys("Zuziukas");
            Thread.sleep(1000);

            //pavardes ivedimas
            WebElement ivestiPavarde = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profile-update\"]/div[5]/input")));
            ivestiPavarde.clear();
            ivestiPavarde.sendKeys("Zuzanas");
            Thread.sleep(1000);

            // telefono ivedimas
            WebElement ivestiTelefona = driver.findElement(By.xpath("//input[@name='phone']"));
            ivestiTelefona.sendKeys("+37065547965");
            Thread.sleep(1000);

            // pakeitimu saugojimas
            WebElement issaugotiPakeitimus = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form[id='profile-update'] button[type='submit']")));
            issaugotiPakeitimus.click();



        } catch (Exception s) {
            System.out.println("Paskyros redagavimas negalimas: " + s.getMessage());
        }

    }

    public static void slaptazodzioKeitimas(String esamasSlaptazodis, String naujasSlaptazodis) throws InterruptedException {

        try {

            WebElement dabartinioSlaptazodzioIvedimas = driver.findElement(By.xpath("//*[@id=\"password-update\"]/div[1]/input"));
            dabartinioSlaptazodzioIvedimas.sendKeys(esamasSlaptazodis);

            WebElement naujoSlaptazodzioIvedimas = driver.findElement(By.xpath("//*[@id=\"password-update\"]/div[2]/input"));
            naujoSlaptazodzioIvedimas.sendKeys(naujasSlaptazodis);

            WebElement naujoSlaptazodzioIvedimas2 = driver.findElement(By.xpath("//*[@id=\"password-update\"]/div[3]/input"));
            naujoSlaptazodzioIvedimas2.sendKeys(naujasSlaptazodis);

            WebElement slaptazodzioPakeitimoIssaugojimas = driver.findElement(By.cssSelector("form[id='password-update'] button[type='submit']"));
            slaptazodzioPakeitimoIssaugojimas.click();
            Thread.sleep(1000);

        } catch (Exception r) {
            System.out.println("Slaptazodzio keitimas nesekmingas: " + r.getMessage());
        }






    }
}




