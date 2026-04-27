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

    }













