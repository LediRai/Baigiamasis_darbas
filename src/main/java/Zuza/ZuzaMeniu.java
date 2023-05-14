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

        ArrayList<tikrinamasLinkas> virsus = new ArrayList<tikrinamasLinkas>();
        virsus.add(new tikrinamasLinkas("Apmokėjimas", "https://zuza.lt/pages/apmokejimas/"));
        virsus.add(new tikrinamasLinkas("Pristatymas", "https://zuza.lt/pages/pristatymas/"));
        virsus.add(new tikrinamasLinkas("Grąžinimas ir garantija", "https://zuza.lt/return-and-warranty/"));
        virsus.add(new tikrinamasLinkas("Apie Zuza.lt", "https://zuza.lt/pages/apie-zuzalt/"));
        virsus.add(new tikrinamasLinkas("Karjera", "https://zuza.lt/pages/karjera/"));
        virsus.add(new tikrinamasLinkas("KLIX Mokėjimas dalimis", "https://zuza.lt/pages/klix-mokejimas-dalimis/"));
        virsus.add(new tikrinamasLinkas("Kontaktai", "https://zuza.lt/kontaktai/"));

        ArrayList<tikrinamasLinkas> apacia = new ArrayList<tikrinamasLinkas>();
        apacia.add(new tikrinamasLinkas("Prekių pristatymas", "https://zuza.lt/pages/prekiu-pristatymas/"));
        apacia.add(new tikrinamasLinkas("Pirkimo sąlygos ir taisyklės", "https://zuza.lt/pages/pirkimo-salygos-ir-taisykles/"));
        apacia.add(new tikrinamasLinkas("Privatumo politika", "https://zuza.lt/pages/privatumo-politika/"));
        apacia.add(new tikrinamasLinkas("Atsiliepimai", "https://zuza.lt/pages/atsiliepimai/"));



        try{
            for (tikrinamasLinkas tikrinimas : virsus) {
                verifyNavigationLink(driver, tikrinimas.getLinkLabel(), tikrinimas.getLinkUrl());
            }
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);

            for (tikrinamasLinkas tikrinimas : apacia) {
                verifyNavigationLink(driver, tikrinimas.getLinkLabel(), tikrinimas.getLinkUrl());
            }
        }catch (Exception e) {
            System.out.println("neveikia");
        }


    }


    // apsirasomos klases
    static class tikrinamasLinkas {
        private String linkLabel;
        private String linkUrl;

        //konstruktorius
        public tikrinamasLinkas(String linkLabel, String linkUrl) {
            this.linkLabel = linkLabel;
            this.linkUrl = linkUrl;
        }

        public String getLinkLabel() {
            return linkLabel;
        }

        public String getLinkUrl() {
            return linkUrl;
        }
    }

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
                System.out.println("FAIL:" + linkText + "Navigation faild " + "Expected: " + expctedLink + "Actual: " + actualLinkURL);
            }
            Thread.sleep(2000);
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("neveikia");
        }
    }
}
