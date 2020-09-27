package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class TShirtsPage extends BasePage {
    private final String H1_TITLE_CSS_SELECTOR = "#center_column > h1 > span.cat-name";
    private final String BTN_T_SHIRTS_CSS_SELECTOR = "#block_top_menu > ul > li:nth-child(3) > a";
    private final String BTN_ADD_TO_CART_CSS_SELECTOR = "#center_column > ul > li > div > div.right-block > h5 > a";
    private final String BTN_PROCEED_TO_CHECKOUT_CSS_SELECTOR ="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span";
    private final String DIV_POP_UP_AGREGAR_CARRITO_CSS_SELECTOR = "#layer_cart > div.clearfix";

    public TShirtsPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void verifyScreen(String pantalla){
        switch (pantalla){
            case "T-Shirts":
                Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_CSS_SELECTOR)).getText(), "T-SHIRTS ");
                break;
            case "agregado al carrito":
                Assert.assertTrue(isElementVisible(By.cssSelector(DIV_POP_UP_AGREGAR_CARRITO_CSS_SELECTOR)));
                break;


        }

    }

    public void clickButton(String btn){
        switch (btn){
            case "Add To Cart":
                addToCartBtn();
                break;
            case "Proceed to checkout":
                proceedToCheckout();
                break;
        }
    }
    public void addToCartBtn(){

        clickElement(By.cssSelector(BTN_ADD_TO_CART_CSS_SELECTOR));
    }
    public void proceedToCheckout(){
        clickElement(By.id(DIV_POP_UP_AGREGAR_CARRITO_CSS_SELECTOR));
    }

}
