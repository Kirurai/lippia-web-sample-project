package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.SignInPage;
import io.cucumber.java.en.*;

public class LoginSteps extends PageSteps {

    @When("el cliente ingresa su email: (.*)")
    public void elClienteIngresaSuEmail(String email) {
        Injector._page(SignInPage.class).enterEmail(email);
    }

    @And("el cliente ingresa su password: (.*)")
    public void elClienteIngresaSuPassword(String pw) {
        Injector._page(SignInPage.class).enterPassword(pw);
    }
}
