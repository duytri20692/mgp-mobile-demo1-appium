package com.mgp.mobile.demo1.stepdefinitions;

import com.mgp.mobile.demo1.pageobject.HomePage;
import com.mgp.mobile.demo1.common.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomeSteps extends BasePage {
    HomePage homePage = new HomePage(driver);

    @And("User should able to see EriBank homepage")
    public void userShouldAbleToSeeEriBankHomepage() {
        homePage.waitForHomePageDisplaying();
    }

    @When("User press on the Make Payment button")
    public void userPressOnTheMakePaymentButton() {
        homePage.pressMakeAPaymentButton();
    }

    @And("User should see the current payment amount value is <{double}>")
    public void userShouldSeeTheCurrentPaymentAmountValueIs(double currentAmount) {
        Assert.assertEquals(currentAmount, Double.parseDouble(homePage.getCurrentAmount()));
    }
}
