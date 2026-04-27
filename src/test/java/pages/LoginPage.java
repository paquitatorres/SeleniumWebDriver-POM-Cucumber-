package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By username = By.id("email");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("[data-test='login-submit']");
    private By messageError = By.xpath("//div[@class='help-block']");
    private By profileName = By.cssSelector("[data-test='nav-menu']");


    public LoginPage(WebDriver driver) {
       this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
    }

    public void setPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }


    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageError)).getText();
    }

    public String getProfileName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileName)).getText();
    }

}

