package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class SignInPage extends BasePage {

    private final String INPUT_EMAIL_LOGIN_ID = "email";
    private final String INPUT_EMAIL_REGISTER_ID = "email_create";
    private final String INPUT_PASSWORD_ID = "passwd";
    private final String BTN_SIGNIN_LOGIN_ID = "SubmitLogin";
    private final String BTN_CREATE_ACCOUNT_ID = "SubmitCreate";
    private final String H1_TITLE_CSS_SELECTOR = "#center_column > h1";
    private final String SLIDER_HOME_ID = "slider_row";

    public SignInPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }
    public void go() {
        navigateToCompleteURL();
    }

    public void verifyScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_CSS_SELECTOR)).getText(), "AUTHENTICATION");
    }

    public void clickButton(String btn){
        switch (btn){
            case "Create an account":
                createAnAccountBtn();
                break;
            case "Sign In del Login":
                loginBtn();
                break;
        }
    }

    public void loginBtn(){
        clickElement(By.id(BTN_SIGNIN_LOGIN_ID));
    }
    public void createAnAccountBtn(){
        clickElement(By.id(BTN_CREATE_ACCOUNT_ID));
    }

    public void completeLoginInfo(String email, String pw){
        enterEmail(email);
        enterPassword(pw);
    }
    public void enterEmail(String email){
        completeField(By.id(INPUT_EMAIL_LOGIN_ID), email);
        completeField(By.id(INPUT_EMAIL_REGISTER_ID), email);

    }
    public void enterPassword(String pw){
        completeField(By.id(INPUT_PASSWORD_ID), pw);
    }





    }
