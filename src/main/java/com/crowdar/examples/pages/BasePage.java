package com.crowdar.examples.pages;

import com.crowdar.core.pageObjects.PageBaseWeb;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage extends PageBaseWeb {

    public BasePage(RemoteWebDriver driver) {
        super(driver);
        BASE_URL = "http://automationpractice.com/";
    }


}
