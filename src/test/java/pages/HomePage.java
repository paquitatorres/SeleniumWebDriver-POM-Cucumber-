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

public class HomePage{
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBar = By.cssSelector("[data-test='search-query']");
    private By searchBtn = By.cssSelector("[data-test='search-submit']");;

    private By cardOfTool = By.cssSelector("[data-test^='product-']");
    private By addToCartBtn= By.id("btn-add-to-cart");;

    private By sortDropdown = By.cssSelector("[data-test='sort']");

    private By priceValue =  By.cssSelector("[data-test='product-price']");




    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void searchProduct(String product){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).sendKeys(product);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
    }


    public void selectProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(cardOfTool)).click();
    }


    public void addProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void sortPriceHighestToLowest() {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));

            Select select = new Select(dropdown);
            select.selectByVisibleText("Price (High - Low)");

            wait.until(ExpectedConditions.attributeToBe(sortDropdown, "value", "price,desc"));
        }



    public void validateDescendingOrder(){
        List<WebElement> preciosWeb = driver.findElements(priceValue);


        List<Double> precios = new ArrayList<>();

        for (WebElement precio : preciosWeb) {
            String texto = precio.getText(); // "$120.50"

            texto = texto.replace("$", "").trim(); // "120.50"

            double valor = Double.parseDouble(texto);
            precios.add(valor);
        }

        for (int i = 0; i < precios.size() - 1; i++) {
            if (precios.get(i) < precios.get(i + 1)) {
                throw new AssertionError("Los precios NO están en orden descendente");
            }
        }

    }





}







