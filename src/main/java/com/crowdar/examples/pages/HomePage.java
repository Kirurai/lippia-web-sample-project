package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    private final String BTN_SIGNIN_CSS_SELECTOR = "#header > div.nav > div > div > nav > div.header_user_info > a";
    private final String SLIDER_HOME_ID = "slider_row"; // ?

    private final String H1_TITLE_CSS_SELECTOR = "#center_column > h1";

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }


    public void go() {
        navigateToCompleteURL();
    }

    public void verifyScreen(String pantalla){
        switch (pantalla){
            case "Home":
                verifyHome();
                break;
        }
    }

    public void verifyHome(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.id(SLIDER_HOME_ID)), "El elemento no es visible");
    }

    public void clickButton(String btn){
        switch (btn){
            case "Sign In del Home":
                SignInBtn();
                break;
        }
    }
    public void SignInBtn(){
        clickElement(By.cssSelector(BTN_SIGNIN_CSS_SELECTOR));
    }

}
