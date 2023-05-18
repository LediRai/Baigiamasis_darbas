package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ZuzaMeniu extends ZuzaDraiveriai {
    public ZuzaMeniu(WebDriver driver) {
        super(driver);
    }

    static JavascriptExecutor jse = (JavascriptExecutor) driver;

    public static void testuoju() {

        ArrayList<TikrinamaNuoroda> virsus = new ArrayList<TikrinamaNuoroda>();
        virsus.add(new TikrinamaNuoroda("Apmokėjimas", "https://zuza.lt/pages/apmokejimas/"));
        virsus.add(new TikrinamaNuoroda("Pristatymas", "https://zuza.lt/pages/pristatymas/"));
        virsus.add(new TikrinamaNuoroda("Grąžinimas ir garantija", "https://zuza.lt/" +
                "return-and-warranty/"));
        virsus.add(new TikrinamaNuoroda("Apie Zuza.lt", "https://zuza.lt/pages/apie-zuzalt/"));
        virsus.add(new TikrinamaNuoroda("Karjera", "https://zuza.lt/pages/karjera/"));
        virsus.add(new TikrinamaNuoroda("KLIX Mokėjimas dalimis", "https://zuza.lt/pages/" +
                "klix-mokejimas-dalimis/"));
        virsus.add(new TikrinamaNuoroda("Kontaktai", "https://zuza.lt/kontaktai/"));


        ArrayList<TikrinamaNuoroda> apacia = new ArrayList<TikrinamaNuoroda>();
        apacia.add(new TikrinamaNuoroda("Prekių pristatymas", "https://zuza.lt/pages/prekiu-" +
                "pristatymas/"));
        apacia.add(new TikrinamaNuoroda("Pirkimo sąlygos ir taisyklės", "https://zuza.lt/" +
                "pages/pirkimo-salygos-ir-taisykles/"));
        apacia.add(new TikrinamaNuoroda("Privatumo politika", "https://zuza.lt/pages/" +
                "privatumo-politika/"));
        apacia.add(new TikrinamaNuoroda("Atsiliepimai", "https://zuza.lt/pages/atsiliepimai/"));

        try {
            // Patikriname virsutines sekcijos nuorodas
            for (TikrinamaNuoroda nuoroda : virsus) {
                verifyNavigationLink(driver, nuoroda.getNuorodosTekstas(), nuoroda.getNuorodosUrl());
            }

            // Slinkame į puslapio apačią
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);

            // Patikriname apatinės sekcijos nuorodas
            for (TikrinamaNuoroda nuoroda : apacia) {
                verifyNavigationLink(driver, nuoroda.getNuorodosTekstas(), nuoroda.getNuorodosUrl());
            }
        } catch (Exception e) {
            System.out.println("neveikia");
        }
    }

    //kodas aprašo vidinę TikrinamaNuoroda klasę, kuri yra naudojama saugoti nuorodas ir jų teksto pavadinimus:
    // apsirasomos klases
    static class TikrinamaNuoroda {
        private String nuorodosTekstas;
        private String nuorodosUrl;

        //konstruktorius
        public TikrinamaNuoroda(String nuorodosTekstas, String nuorodosUrl) {
            this.nuorodosTekstas = nuorodosTekstas;
            this.nuorodosUrl = nuorodosUrl;
        }

        public String getNuorodosTekstas() {
            return nuorodosTekstas;
        }

        public String getNuorodosUrl() {
            return nuorodosUrl;
        }
    }

    //verifyNavigationLink metodas, kuris tikrina nuorodų perėjimus:
    public static void verifyNavigationLink(WebDriver driver, String linkText, String expctedLink) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
            Thread.sleep(2000);
            link.click();
            String actualLinkURL = driver.getCurrentUrl();
            if (actualLinkURL.equals((expctedLink))) {
                System.out.println();
                System.out.println(("PASS: " + linkText + " -> Navigation successfully"));
            } else {
                System.out.println("FAIL:" + linkText + "Navigation faild " + "Expected: " + expctedLink +
                        "Actual: " + actualLinkURL);
            }
            Thread.sleep(2000);
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("neveikia");
        }
    }
}
