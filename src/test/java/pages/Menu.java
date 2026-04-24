package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Menu {
        private WebDriver driver;
        private WebDriverWait wait;
        private By signinBtn = By.cssSelector("[data-test='nav-sign-in']");
        private By cartBtn = By.cssSelector("[data-test='nav-cart']");
        private By categoriesDropdown = By.cssSelector("[data-test='nav-categories']");
        private By handToolCategory= By.cssSelector("[data-test='nav-hand-tools']");

    public Menu(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signinBtn)).click();
    }


    public void goToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBtn)).click();
    }


    public void selectCategory(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesDropdown)).click();
    }

    public void selectHandToolsInCategory(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(handToolCategory)).click();
    }


    }

