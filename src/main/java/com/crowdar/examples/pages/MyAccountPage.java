package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class MyAccountPage extends BasePage {
    private final String H1_TITLE_CSS_SELECTOR = "#center_column > h1";
    private final String BTN_T_SHIRTS_CSS_SELECTOR = "#block_top_menu > ul > li:nth-child(3) ";

    public MyAccountPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void verifyScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(H1_TITLE_CSS_SELECTOR)).getText(), "MY ACCOUNT");
    }

    public void clickButton(String btn){
        switch (btn){
            case "T-Shirts desde My Account":
                TShirtsBtn();
                break;
        }
    }
    public void TShirtsBtn(){
        clickElement(By.cssSelector(BTN_T_SHIRTS_CSS_SELECTOR));
    }

}
