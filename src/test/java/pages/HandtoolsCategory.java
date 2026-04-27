package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HandtoolsCategory {

    private WebDriver driver;
    private WebDriverWait wait;

    private By sortDropdown = By.cssSelector("[data-test='sort']");

    private By priceValues =  By.cssSelector("[data-test='product-price']");


    public HandtoolsCategory(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void sortPriceHighestToLowest() {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(priceValues));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));


        WebElement firstPriceBeforeSort = driver.findElement(priceValues);

        Select select = new Select(dropdown);
        select.selectByValue("price,desc");

        wait.until(ExpectedConditions.attributeToBe(sortDropdown, "value", "price,desc"));
        wait.until(ExpectedConditions.stalenessOf(firstPriceBeforeSort));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(priceValues));
    }

    public void validateDescendingOrder(){

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(priceValues));
        List<WebElement> preciosWeb = driver.findElements(priceValues);

        List<Double> precios = new ArrayList<>();



        for (WebElement precio : preciosWeb) {
            String texto = precio.getText();
            texto = texto.replace("$", "").trim();
            double valor = Double.parseDouble(texto);
            precios.add(valor);
        }

        if (precios.isEmpty()) {
            throw new AssertionError("No se encontraron precios para validar");
        }

        for (int i = 0; i < precios.size() - 1; i++) {
            if (precios.get(i) < precios.get(i + 1)) {
                throw new AssertionError("Los precios NO están en orden descendente");
            }

        }
    }



}







