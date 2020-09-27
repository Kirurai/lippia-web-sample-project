package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class OrderPage extends BasePage {
    private final String SPAN_NAVIGATION_PAGE_CSS_SELECTOR = "#columns > div.breadcrumb.clearfix > span.navigation_page";
    private final String BTN_PROCEED_TO_CHECKOUT_TO_ADDRESS_CSS_SELECTOR = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium";
    private final String BTN_PROCEED_TO_CHECKOUT_TO_SHIPPING_CSS_SELECTOR = "#center_column > form > p > button";
    private final String BTN_PROCEED_TO_CHECKOUT_TO_PAYMENT_CSS_SELECTOR = "#form > p > button";
    private final String BTN_PAY_BY_BANK_WIRE_CSS_SELECTOR = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a";
    private final String BTN_CONFIRM_MY_ORDER_CSS_SELECTOR = "#cart_navigation > button";
    private final String CHECKBOX_TERMS_OF_SERVICE_CSS_SELECTOR = "#uniform-cgv"; //Se seleccionó el div, no el input


    public OrderPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }
    public void go() {
        navigateToCompleteURL();
    }

    public void verifyScreen(String pantalla){
        switch (pantalla){
            case "Order":
                Assert.assertEquals(getWebElement(By.cssSelector(SPAN_NAVIGATION_PAGE_CSS_SELECTOR)).getText(), "Your shopping cart");
                break;
        }
    }

    public void clickButton(String btn){
        switch (btn) {
            case "Proceed To Checkout de Summary": toAddressBtn(); break;
            case "Proceed To Checkout de Address": toShippingBtn(); break;
            case "Terms of service": checkTOS(); break;
            case "Proceed To Checkout de Shipping": toPaymentBtn(); break;
            case "Pay by bank wire": PayByBanckWireBtn(); break;
            case "I Confirm My Order": ConfirmOrderBtn(); break;
        }
    }
    public void toAddressBtn(){
        clickElement(By.cssSelector(BTN_PROCEED_TO_CHECKOUT_TO_ADDRESS_CSS_SELECTOR));
    }
    public void toShippingBtn(){
        clickElement(By.cssSelector(BTN_PROCEED_TO_CHECKOUT_TO_SHIPPING_CSS_SELECTOR));
    }
    public void checkTOS(){
        //waitAndCheckElementPresent(By.id(INPUT_TERMS_OF_SERVICE_ID));
        //setCheckbox(INPUT_TERMS_OF_SERVICE_ID, true);
        clickElement(By.cssSelector(CHECKBOX_TERMS_OF_SERVICE_CSS_SELECTOR));
    }
    public void toPaymentBtn(){
        clickElement(By.cssSelector(BTN_PROCEED_TO_CHECKOUT_TO_PAYMENT_CSS_SELECTOR));
    }
    public void PayByBanckWireBtn(){
        clickElement(By.cssSelector(BTN_PAY_BY_BANK_WIRE_CSS_SELECTOR));
    }
    public void ConfirmOrderBtn(){
        clickElement(By.cssSelector(BTN_CONFIRM_MY_ORDER_CSS_SELECTOR));
    }
}
