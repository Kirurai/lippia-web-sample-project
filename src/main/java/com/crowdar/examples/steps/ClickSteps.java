package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.core.annotation.Order;

public class ClickSteps extends PageSteps {
    @When("el cliente hace click en el botón (.*)")
    @And("")//("el cliente hace click en (.*)")
    public void elClienteHaceClickEnElBotónSignIn(String btn)  {
        switch (btn){
            case "Sign In del Login":
                Injector._page(SignInPage.class).clickButton(btn);
                break;
            case "Sign In del Home":
                Injector._page(HomePage.class).clickButton(btn);
                break;
            case "T-Shirts desde My Account":
                Injector._page(MyAccountPage.class).clickButton(btn);
                break;
            case "Add To Cart":
                Injector._page(TShirtsPage.class).clickButton(btn);
                break;
            case "Agregar Cantidad":
            case "Proceed to checkout desde la página del producto":
                Injector._page(ProductPage.class).clickButton(btn);
                break;
            case "Add To Cart desde la página del producto":
                Injector._page(ProductPage.class).clickButton("Add To Cart");
                break;
            case "Proceed To Checkout de Summary":
            case "Proceed To Checkout de Address":
            case "Proceed To Checkout de Shipping":
            case "Pay by bank wire":
            case "Terms of service":
            case "I Confirm My Order":
                Injector._page(OrderPage.class).clickButton(btn);
                break;

        }

    }


    @When("el cliente ingresa (.*) en (.*)")
    public void elClienteIngresaEnCantidad(String totalDeProductosQueDesea, String campo) {
        switch (campo){
            case "cantidad":
                Injector._page(ProductPage.class).setField(campo, totalDeProductosQueDesea);
        }
    }
}
