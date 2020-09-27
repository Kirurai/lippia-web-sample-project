package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class VerifySteps extends PageSteps {
    @Given("el cliente se encuentra en la página (.*)")
    public void elClienteSeEncuentraEnLaPáginaHome(String pantalla) {
        Injector._page(HomePage.class).go();
        Injector._page(HomePage.class).verifyScreen(pantalla);
    }

    @Then("el cliente verifica que fue redireccionado a la pantalla de (.*)")
    public void elClienteVerificaQueFueRedireccionadoALaPantallaDeLogin(String pantalla) {
        switch (pantalla){
            case "Login":
                Injector._page(SignInPage.class).verifyScreen();
                break;
            case "My Account":
                Injector._page(MyAccountPage.class).verifyScreen();
                break;
            case "T-Shirts":
                Injector._page(TShirtsPage.class).verifyScreen(pantalla);
                break;
            case "Producto":                                                //Item específico
                Injector._page(ProductPage.class).verifyScreen("Faded Short Sleeve T-shirts");
                break;
            case "Order":
            case "Order Confirmation":
                Injector._page(OrderPage.class).verifyScreen(pantalla);
                break;

        }

    }
    @Then("El cliente verifica que aparece el Pop Up de (.*)")
    public void elClienteVerificaQueApareceElPopUpDeAgregadoAlCarrito(String popUp) {
        switch (popUp){
            case "agregado al carrito":
                Injector._page(TShirtsPage.class).verifyScreen(popUp);
        }
    }
}
