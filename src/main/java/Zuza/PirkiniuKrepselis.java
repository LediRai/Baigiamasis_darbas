package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.List;

public class PirkiniuKrepselis extends ZuzaDraiveriai {

    public DbConnection db;

    public PirkiniuKrepselis(WebDriver driver) {
        super(driver);
        db = new DbConnection();
    }

    private final static By produktoPavadinimas = By.className("basket-item__name");
    private final static By skelbimoID = By.cssSelector("span:nth-child(2)");
    private final static By likutis = By.className("basket-item__quantity-result");
    private final static By kaina = By.className("basket-item__price");
    private final static By paveiksliukas = By.className("basket-item__img");

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static JavascriptExecutor jse = (JavascriptExecutor) driver;

    public static void zuzaPirkiniai() throws SQLException {

        String[] paieska = {"ledinis sviestuvas", "molinis puodas", "badmintono rakete","patalyne","nuotrauku remelis"};
        //"A27368416674", "A22595987182","A27363951782"

        // prekiu paieskos ciklas per masyvo elementus
        for (String i : paieska) {
            driver.get("https://zuza.lt/");
            WebElement ieskoti = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/" +
                    "div[2]/form/input"));
            wait.until(ExpectedConditions.elementToBeClickable(ieskoti));
            ieskoti.clear();
            ieskoti.sendKeys(i);
            ieskoti.submit();
//            Ciklas, kuris vykdo prekių pridėjimą į krepšelį ir tęsia apsipirkimą.
            try {
                Thread.sleep(1000);
                List<WebElement> pirkti = driver.findElements(By.className("card__wrapper"));
                jse.executeScript("arguments[0].scrollIntoView();", pirkti.get(0));
                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(pirkti.get(0)));
                pirkti.get(0).click();
                Thread.sleep(1000);

                WebElement pridetiIKrepseli = driver.findElement(By.xpath("(//button[contains(text()," +
                        "'PRIDĖTI Į KREPŠELĮ')])[1]"));
                // Naudoju JSexecutor kad pascrolintu langa iki elemento
                jse.executeScript("arguments[0].scrollIntoView();", pridetiIKrepseli);
                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(pridetiIKrepseli));
                pridetiIKrepseli.click();
                Thread.sleep(1000);

                WebElement testiApsipirkima = driver.findElement(By.xpath("//a[contains(text(),'tęsti" +
                        " apsipirkimą')]"));
                wait.until(ExpectedConditions.elementToBeClickable(testiApsipirkima));
                testiApsipirkima.click();
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Testas nepavyksta: " + e.getMessage());
            }
        }

        // tikrinama kas yra sudeta i pirkiniu krepseli
        try {
            WebElement prekiuSarasas = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/" +
                    "div[4]/div[1]/a[3]"));
            // paslenkamas puslapis i virsu kad butu matomas elementas ir ji paspaudziam
            jse.executeScript("arguments[0].scrollIntoView();", prekiuSarasas);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(prekiuSarasas));
            prekiuSarasas.click();
            Thread.sleep(1000);
        } catch (Exception n) {
            System.out.println("neveikia");
        }

        // atspausdinama informacija esanti prekiu krepselio liste
        List<WebElement> krepselioSarasas = driver.findElements(By.xpath("//div[@class='basket__" +
                "product-box']//form"));
        System.out.println(krepselioSarasas.size());

        String sql = "INSERT INTO pirkiniuKrepselis(produkto_pavadinimas, skelbimo_ID, kaina, " +
                "prekiu_likutis_sandelyje,paveiksliukas) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = DbConnection.prisijungimasPrieDB(sql);
        DbConnection.testasDB();

        try {
            for (WebElement preke : krepselioSarasas) {

                String prekesPavadinimas = preke.findElement(produktoPavadinimas).getText();
                String prekesKaina = preke.findElement(kaina).getText();
                String idSkelbimo = preke.findElement(skelbimoID).getText();
                String prekiuLikutis = preke.findElement(likutis).getText();
                int kainaInt = Integer.parseInt(prekesKaina.replaceAll("\\D+", ""));
                WebElement paveiksliukoVieta = preke.findElement(paveiksliukas);
                String styleAttribute = paveiksliukoVieta.getAttribute("src");

                assert pstmt != null;
                pstmt.setString(1, prekesPavadinimas);
                pstmt.setString(2, idSkelbimo);
                pstmt.setInt(3, kainaInt);
                pstmt.setString(4, prekiuLikutis);
                pstmt.setString(5, styleAttribute);

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // koreguojamas prekiu kiekis
        List<WebElement> produktuSarasas = driver.findElements(By.xpath("//div[@class='basket__" +
                "product-box']//form"));
        try {
            for (int i = 0; i < produktuSarasas.size(); i++) {
                if (i == 0 || i == 2) {
                    WebElement pliusoMygtukas = produktuSarasas.get(i).findElement(By.cssSelector("body > main >" +
                            " div.basket__container.container > div.basket__product-box > form > div.basket-item__" +
                            "count > div.counter.basket-item__counter > button.counter__mark.active.js--plus"));
                    pliusoMygtukas.click();
                    Thread.sleep(2000);
                }
            }
        } catch (Exception n) {
            System.out.println("Neveikia prekiu kiekio redagavimas");
        }

        // spaudziamas naikinimo mygtukas
        List<WebElement> produktuSarasas2 = driver.findElements(By.cssSelector("div.basket__product-box form"));
        try {
            for (WebElement product : produktuSarasas2) {
                WebElement addButton = product.findElement(By.cssSelector("body > main > div.basket__container." +
                        "container > div.basket__product-box > form:nth-child(1) > button > svg > use"));
                addButton.click();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Pirkiniu krepselis neatsidaro" + e.getMessage());
        }
    }
}