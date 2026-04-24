package steps;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.Menu;
import pages.Cart;
import org.testng.Assert;

public class Filters {


    private WebDriver driver;
    private Menu menu;
    private HomePage homePage;

    @When("selecciona la categoría Hand Tools")
    public void seleccionarCategoriaHandTools(){
    menu.selectCategory();
    menu.selectHandToolsInCategory();
    Assert.assertEquals("https://practicesoftwaretesting.com/category/hand-tools", driver.getCurrentUrl());

    }

    @And("aplica el ordenamiento por precio de mayor a menor")
      public void ordenarProductos(){
     homePage.sortPriceHighestToLowest();

    }

    @Then("los productos se muestran ordenados de mayor a menor precio")
     public void validarMayorAMenor(){
      homePage.validateDescendingOrder();
    }


    @Then("todos los productos tienen precio menor o igual a {int}")
    public  void  verificarPrecioMaximo(){

    }

    @And("se muestra al menos un producto")
    public void muestraAlmenosUnproducto(){


    }



}
