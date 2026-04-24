package steps;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.Menu;
import pages.Cart;
import org.testng.Assert;

public class E2ESteps {

    private HomePage homePage;
    private Menu menu;
    private Cart cart;

    @Given("el usuario está en la página principal")
    public void gotoHome() {
        DriverFactory.getDriver().get("https://practicesoftwaretesting.com/");
        homePage = new HomePage(DriverFactory.getDriver());
        menu = new Menu(DriverFactory.getDriver());
        cart = new Cart(DriverFactory.getDriver());
    }

    @When("busca el producto {string}")
            public void buscarProducto(String producto){
            homePage.searchProduct(producto);
            }

    @And("selecciona el primer resultado")
            public void seleccionarProducto(){
            homePage.selectProduct();
    }

    @Then("se muestra la página de detalle del producto")
            public void estarEnDetalles(){
        // Validación opcional: verificar URL o título de página
    }


    @When("agrega el producto al carrito")
            public void agregarProducto(){
            homePage.addProduct();
            }

    @Then("navega al carrito de compras")
    public void navegarAlCarrito() {
            menu.goToCart();
    }

    @And("procede al checkout")
    public void procederAlCheckout() {
            cart.firstStepCheckout();
    }


    @And("ha iniciado sesión con credenciales válidas {string} y {string}")
    public void procederLogInCheckout(String correo, String pass) {
        cart.secondStepCheckout(correo, pass);
            }

    @Then("se muestra el formulario de datos de envío")
    public void seMuestraFormularioEnvio() {
        cart.thirdStepCheckout();
    }

    @When("completa los datos de envío con información válida {string},{string} y {string}")
    public void completarDatosEnvio(String state, String postalCode , String numberHouse) {
        cart.completeForm( state, postalCode, numberHouse);
    }

    @And("selecciona el método de pago {string}")
    public void seleccionarMetodoPago(String metodoPago) {
        cart.selectPayMethod(metodoPago);
    }

    @And("confirma el pedido")
    public void confirmarPedido() {
        cart.finaliseCheckout();
    }

    @Then("visualiza el mensaje {string}")
    public void visualizarMensaje(String mensajeEsperado) {
        String mensajeActual = cart.getPayMessage();
        Assert.assertTrue(mensajeActual.contains(mensajeEsperado),
                "Mensaje incorrecto. Actual: " + mensajeActual);
    }



}