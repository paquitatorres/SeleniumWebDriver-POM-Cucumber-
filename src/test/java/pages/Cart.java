package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.HashMap;
import java.util.Map;

import java.time.Duration;

public class Cart {


    private WebDriver driver;
    private WebDriverWait wait;


    private By firstCheckoutBtn = By.cssSelector("[data-test='proceed-1']");
    private By userLogin = By.id("email");
    private By passLogin = By.id("password");
    private By toSingInBtn = By.cssSelector("[data-test='login-submit']");
    private By toBillingAddressBtn = By.cssSelector("[data-test='proceed-2']");
    private By addressInputTxt = By.id("street");
    private By completeFormState = By.id("state");
    private By completeFormPostalCode = By.id("postal_code");
    private By completeFormHouseNumber = By.id("house_number");
    private By adressBtn = By.cssSelector("[data-test='proceed-3']");
    private By selectPayment = By.cssSelector("[data-test='payment-method']"); //
    private By confirmBtn = By.cssSelector("[data-test='finish']");
    private By messagePay = By.cssSelector("[data-test='payment-success-message']");

    public Cart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void firstStepCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(firstCheckoutBtn)).click();
    }

    public void secondStepCheckout(String email, String pass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLogin)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passLogin)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(toSingInBtn)).click();
    }

    public void thirdStepCheckout() {
      wait.until(ExpectedConditions.elementToBeClickable(toBillingAddressBtn)).click();
    }

    public void completeForm(String state, String postalCode, String houseNumber) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        WebElement field = fluentWait.until(driver -> {
            WebElement el = driver.findElement(addressInputTxt);
            if (!el.getAttribute("value").isEmpty()) {
                return el;
            }
            return null;
        });
      wait.until(ExpectedConditions.visibilityOfElementLocated(completeFormState)).sendKeys(state);
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeFormPostalCode)).sendKeys(postalCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(completeFormHouseNumber)).sendKeys(houseNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(adressBtn)).click();
    }


    public void selectPayMethod(String metodoPago) {
        // Mapeo de texto visible ...  value del option
        Map<String, String> paymentOptions = new HashMap<>();
        paymentOptions.put("Bank Transfer", "bank-transfer");
        paymentOptions.put("Cash on Delivery", "cash-on-delivery");
        paymentOptions.put("Credit Card", "credit-card");
        paymentOptions.put("Buy Now Pay Later", "buy-now-pay-later");
        paymentOptions.put("Gift Card", "gift-card");

        String value = paymentOptions.get(metodoPago);
        if (value == null) {
            throw new IllegalArgumentException("Método de pago no reconocido: " + metodoPago);
        }

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(selectPayment));
        new Select(dropdown).selectByValue(value);

        System.out.println("Método de pago seleccionado: " + metodoPago + " (value=" + value + ")");
    }


    public void finaliseCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
    }


    public String getPayMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messagePay)).getText();
    }




}

