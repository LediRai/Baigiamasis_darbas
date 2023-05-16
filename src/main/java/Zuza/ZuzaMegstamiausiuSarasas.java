package Zuza;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ZuzaMegstamiausiuSarasas extends ZuzaDraiveriai {
    static String[] sarasas = {"gitara", "sijonas", "batai"};
    private final static By paieska = By.cssSelector(".search__input");


    public ZuzaMegstamiausiuSarasas(WebDriver driver) {
        super(driver);
    }
    public static void MegstamiausiuSarasas() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (String i : sarasas) {
            WebElement searchBox = driver.findElement(paieska);
            searchBox.sendKeys(i);
            searchBox.submit();

            try {
                Thread.sleep(3000);
                WebElement pridetiMegstamiausiaPreke = driver.findElement(By.cssSelector(".card__overlay"));
                wait.until(ExpectedConditions.elementToBeClickable(pridetiMegstamiausiaPreke));
                pridetiMegstamiausiaPreke.click(); //pirma preke pasirenkama
                Thread.sleep(1000);
                WebElement paspaustiSirdute = driver.findElement(By.cssSelector(".item-act__text"));
                wait.until(ExpectedConditions.elementToBeClickable(paspaustiSirdute));
                paspaustiSirdute.click(); //pirma preke pasirenkama
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Negalima prideti prekes prie megstamiausiu: " + e.getMessage());
            }

            driver.navigate().back();
            driver.navigate().back();
            Thread.sleep(3000);
        }
    }


    public static void MegstamiausiuSarasoNaikinimas() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.navigate().to("https://zuza.lt/favorites/");

        try {
            List<WebElement> trintiPirkinius = driver.findElements(By.className("product-item__icon"));
            Thread.sleep(3000);
            trintiPirkinius.get(0).click();
            Thread.sleep(3000);
            trintiPirkinius.get(1).click();
            Thread.sleep(3000);
            trintiPirkinius.get(2).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Megstamiausiu ikona nera matoma");
        }
    }
}







