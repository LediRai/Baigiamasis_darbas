package Zuza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SKFiltrai extends ZuzaDraiveriai {
    public SKFiltrai(WebDriver driver) {
        super(driver);
    }
    //private final static By arbata = By.xpath("//*[@id=\"app\"]/header/div[2]/nav/div/ul[2]/li[1]/a");
    private final static By pasirinkimai = By.cssSelector("form-checkbox");
    private final static By produktuSkaicius = By.cssSelector("#js-product-list > div");


    public static void arbata(){
        WebElement arbata = driver.findElement(By.xpath("//*[@id=\"app\"]/header/div[2]/nav/div/ul[2]/li[1]/a"));
        arbata.click();
    }

    List<WebElement> pasirinkimuSarasas = driver.findElements(pasirinkimai);
    List<WebElement> produktuKiekis=driver.findElements(produktuSkaicius);

}
