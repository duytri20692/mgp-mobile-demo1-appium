package com.mgp.mobile.demo1.pageobject;

import com.mgp.mobile.demo1.common.ElementHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ElementHelper {
    @FindBy(id = idPrefix + "makePaymentButton")
    private WebElement makeAPaymentBtn;
    @FindBy(id = idPrefix + "logoutButton")
    private WebElement logoutBtn;
    @FindBy(xpath = "//*[contains(@text,'Your balance is')]")
    private WebElement currentAmountLbl;

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public PaymentPage pressMakeAPaymentButton() {
        waitForPresence(driver,1, makeAPaymentBtn);
        makeAPaymentBtn.click();
        return new PaymentPage(driver);
    }

    public LoginPage pressLogoutButton() {
        waitForPresence(driver,1, logoutBtn);
        logoutBtn.click();
        return new LoginPage(driver);
    }

    public String getCurrentAmount(){
        String currentAmount = currentAmountLbl.getText();
        currentAmount = currentAmount.replace("Your balance is: ", "").replace("$","").trim();
        return currentAmount;
    }

    public void waitForHomePageDisplaying() {
        waitForPresence(driver,3, makeAPaymentBtn);
    }
}
