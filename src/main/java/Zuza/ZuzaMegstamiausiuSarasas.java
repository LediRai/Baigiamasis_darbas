package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class ZuzaMegstamiausiuSarasas extends ZuzaDraiveriai {

    static String[] sarasas = {"gitara", "sijonas", "batai"};
    private final static By paieska = By.cssSelector(".search__input");

    private final static By MegstamiausiuProduktuLokacija = By.xpath("//a[@class='header-content__item header-content__item--4 tactic js--favorite-link']");
    //"/html/body/div[1]/div[2]/div/div/div[4]/div[1]/a[2]");
    ;

    //a[@class='header-content__item header-content__item--4 tactic js--favorite-link']
    public ZuzaMegstamiausiuSarasas(WebDriver driver) {
        super(driver);
    }

    public static void MegstamiausiuSarasas() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (String i : sarasas) {
            WebElement searchBox = driver.findElement(paieska);
            searchBox.sendKeys(i);
            searchBox.submit();


            //live chat
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body")));

            try {
                Thread.sleep(3000);
                List<WebElement> pridetiMegstamiausiaPreke = driver.findElements(By.cssSelector(".card__overlay"));
                wait.until(ExpectedConditions.elementToBeClickable(pridetiMegstamiausiaPreke.get(0)));
                pridetiMegstamiausiaPreke.get(0).click(); //pirma preke pasirenkama
                Thread.sleep(1000);


                List<WebElement> paspaustiSirdute = driver.findElements(By.cssSelector(".item-act__text"));
                wait.until(ExpectedConditions.elementToBeClickable(paspaustiSirdute.get(0)));
                paspaustiSirdute.get(0).click(); //pirma preke pasirenkama
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
//        WebElement searchBox2 = driver.findElement(paieska);
//        searchBox2.sendKeys("knyga"); //svetaines "apgavimas", nes kitaip nesimato "megstamiausi"
//        searchBox2.submit();

        try {
            WebElement pasiektiLokacija = wait.until(ExpectedConditions.elementToBeClickable(MegstamiausiuProduktuLokacija));
            pasiektiLokacija.click();

            List<WebElement> trintiPirkinius = driver.findElements(By.className("product-item__icon"));
            trintiPirkinius.get(0).click();
            trintiPirkinius.get(1).click();
            trintiPirkinius.get(2).click();
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Megstamiausiu ikona nera matoma");
        }

    }
}
