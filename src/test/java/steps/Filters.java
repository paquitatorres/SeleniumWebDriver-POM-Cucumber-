package steps;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HandtoolsCategory;
import pages.HomePage;
import pages.Menu;
import pages.Cart;
import org.testng.Assert;

public class Filters {


    private WebDriver driver;
    private Menu menu;
    private HomePage homePage;
    private HandtoolsCategory handtoolsCategory;

    public Filters() {
        this.driver   = DriverFactory.getDriver();
        this.menu     = new Menu(driver);
        this.homePage = new HomePage(driver);
        this.handtoolsCategory = new HandtoolsCategory(driver);
    }

    @When("selecciona la categoría Hand Tools")
    public void seleccionarCategoriaHandTools(){
        menu.selectCategory();
        menu.selectHandToolsInCategory();
    }

    @And("aplica el ordenamiento por precio de mayor a menor")
      public void ordenarProductos(){

     handtoolsCategory.sortPriceHighestToLowest();

    }

    @Then("los productos se muestran ordenados de mayor a menor precio")
     public void validarMayorAMenor(){
      handtoolsCategory.validateDescendingOrder();
    }


    @Then("todos los productos tienen precio menor o igual a {int}")
    public  void  verificarPrecioMaximo(){

    }

    @And("se muestra al menos un producto")
    public void muestraAlmenosUnproducto(){


    }



}
