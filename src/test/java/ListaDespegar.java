import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListaDespegar {
    private WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.despegar.com.ar/");

        List<WebElement> lista = driver.findElements(By.xpath("//label[@class='button-circle-label']"));

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getText() != "Ofertas") {
                System.out.println(lista.get(i).getText());
                Thread.sleep(500);
                Assert.assertTrue(lista.get(i).isDisplayed());
            }
        }

        driver.quit();
    }
}
