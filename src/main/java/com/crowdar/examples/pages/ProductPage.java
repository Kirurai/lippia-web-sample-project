package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ProductPage extends BasePage {
    private final String H1_TITLE_CSS_SELECTOR = "#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1";
    private final String H1_ORDER_CONFIRMATION_CSS_SELECTOR = "#center_column > h1";
    private final String BTN_AGREGAR_CANTIDAD_CSS_SELECTOR = "#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up";
    private final String BTN_DISMINUIR_CANTIDAD_CSS_SELECTOR = "#quantity_wanted_p > a.btn.btn-default.button-minus.product_quantity_down";
    private final String INPUT_CANTIDAD_TOTAL_ID = "quantity_wanted";
    private final String BTN_ADD_TO_CART_CSS_SELECTOR = "#add_to_cart > button";
    private final String BTN_PROCEED_TO_CHECKOUT_CSS_SELECTOR = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a";
    private final String POP_UP_PROCEED_TO_CHECKOUT_ID = "layer_cart";



    public ProductPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void verifyScreen(String pantalla){
        switch (pantalla){
            case "Producto": //Si quiero que escale puedo compararlo con una lista de todos los productos... cómo se haría?
                Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_CSS_SELECTOR)).getText(), "Faded Short Sleeve T-shirts");
                break;
            case "Proceed To Checkout":
                Assert.assertTrue(isElementVisible(By.id(POP_UP_PROCEED_TO_CHECKOUT_ID)));
                break;
            case "Order Confirmation":
                Assert.assertEquals(getWebElement(By.cssSelector(H1_ORDER_CONFIRMATION_CSS_SELECTOR)).getText(), "ORDER CONFIRMATION");
                break;

        }
    }

    public void clickButton(String btn){
        switch (btn) {
            case "Add To Cart":
                addToCartBtn();
                break;
            case "Proceed to checkout desde la página del producto":
                proceedToCheckoutBtn();
                break;
        }
    }
    public void addToCartBtn(){
        clickElement(By.cssSelector(BTN_ADD_TO_CART_CSS_SELECTOR));
    }
    public void proceedToCheckoutBtn(){
        clickElement(By.cssSelector(BTN_PROCEED_TO_CHECKOUT_CSS_SELECTOR));
    }
    public void setField(String campo, String totalDeProductosQueDesea){
        switch (campo){
            case "cantidad":
                completeField(By.id(INPUT_CANTIDAD_TOTAL_ID), totalDeProductosQueDesea);
        }
    }
}
