package Zuza;

import org.openqa.selenium.By;
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

    public static void testuoju() {

        ArrayList<VerificationLink> link = new ArrayList<VerificationLink>();
        link.add(new VerificationLink("Apmokėjimas", "https://zuza.lt/pages/apmokejimas/"));
        link.add(new VerificationLink("Pristatymas", "https://zuza.lt/pages/pristatymas/"));
        link.add(new VerificationLink("Grąžinimas ir garantija", "https://zuza.lt/return-and-warranty/"));
        link.add(new VerificationLink("Apie Zuza.lt", "https://zuza.lt/pages/apie-zuzalt/"));
        link.add(new VerificationLink("Karjera", "https://zuza.lt/pages/karjera/"));
        link.add(new VerificationLink("KLIX Mokėjimas dalimis", "https://zuza.lt/pages/klix-mokejimas-dalimis/"));
        link.add(new VerificationLink("Kontaktai", "https://zuza.lt/kontaktai/"));
        link.add(new VerificationLink("Prekių pristatymas", "https://zuza.lt/pages/prekiu-pristatymas/"));
        link.add(new VerificationLink("Pirkimo sąlygos ir taisyklės", "hhttps://zuza.lt/pages/pirkimo-salygos-ir-taisykles/"));
        link.add(new VerificationLink("Privatumo politika", "https://zuza.lt/pages/privatumo-politika/"));
        link.add(new VerificationLink("Atsiliepimai", "https://zuza.lt/pages/atsiliepimai/"));


        // Access and use array elements
        for (VerificationLink print : link) {
            verifyNavigationLink(driver, print.getLinkLabel(), print.getLinkUrl());
            // System.out.println("Name: " + print.getLinkLabel() + ", url: " + print.getLinkUrl());
        }
    }

    // apsirasomos klases
    static class VerificationLink {
        private String linkLabel;
        private String linkUrl;

        //konstruktorius
        public VerificationLink(String linkLabel, String linkUrl) {
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
