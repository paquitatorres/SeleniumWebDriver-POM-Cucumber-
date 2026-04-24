package steps;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.Menu;



public class LoginSteps {
    private LoginPage loginPage;
    private Menu menu;

    @Given("el usuario está en la página de inicio de sesión")
    public void abrirLogin() {
        DriverFactory.getDriver().get("https://practicesoftwaretesting.com/");
        menu = new Menu(DriverFactory.getDriver());
        menu.goToSignIn();
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("el usuario ingresa el correo {string}")
    public void ingresarCorreo(String correo) {
        loginPage.setUsername(correo);
    }

    @And("ingresa la contraseña {string}")
    public void ingresarContrasena(String password) {
        loginPage.setPassword(password);
    }

    @And("hace clic en el botón 'Iniciar sesión'")
    public void hacerClicLogin() {
        loginPage.clickLogin();
    }

    @Then("debe visualizar su nombre de usuario {string} en el perfil")
    public void verificarNombrePerfil(String nombreEsperado) {
        String nombreActual = loginPage.getProfileName();
        Assert.assertEquals(nombreActual, nombreEsperado,
                "El nombre de usuario no coincide");
    }

    @Then("debe mostrarse el mensaje de error {string}")
    public void verificarMensajeError(String mensajeEsperado) {
        String mensajeActual = loginPage.getErrorMessage();
        Assert.assertTrue(mensajeActual.contains(mensajeEsperado),
                "Mensaje de error incorrecto. Actual: " + mensajeActual);
    }
}
