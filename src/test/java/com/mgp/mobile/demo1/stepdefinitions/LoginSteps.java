package com.mgp.mobile.demo1.stepdefinitions;

import com.mgp.mobile.demo1.pageobject.LoginPage;
import com.mgp.mobile.demo1.common.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps extends BasePage {
    LoginPage loginPage = new LoginPage(driver);

    @Given("User open the EriBank application and go to the Sign in page")
    public void userOpenTheEriBankApplicationAndGoToTheSignInPage() {
        loginPage.waitForLoginPageDisplaying();
    }

    @And("User Login to the app with valid Username and Password")
    public void userLoginToTheAppWithValidUsernameAndPassword() {
        loginPage.dismissAlert();
        loginPage.loginWithUserAndPass(loginUser,loginPass);
    }
}
