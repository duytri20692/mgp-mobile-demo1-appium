package com.mgp.mobile.demo1.pageobject;

import com.mgp.mobile.demo1.common.ElementHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ElementHelper {
    @FindBy(id = idPrefix + "usernameTextField")
    private WebElement emailTxt;
    @FindBy(id = idPrefix + "passwordTextField")
    private WebElement passTxt;
    @FindBy(id = idPrefix + "loginButton")
    private WebElement signInBtn;
    @FindBy(id = "android:id/button1")
    private WebElement alertOKBtn;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public LoginPage dismissAlert(){
        waitForPresence(driver,2, alertOKBtn);
        alertOKBtn.click();
        return this;
    }

    public LoginPage enterUserName(String username) {
        waitForPresence(driver,1, emailTxt);
        emailTxt.clear();
        emailTxt.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        waitForPresence(driver,1, passTxt);
        passTxt.clear();
        passTxt.sendKeys(password);
        return this;
    }

    public HomePage pressLoginBtn() {
        waitForPresence(driver,1, signInBtn);
        signInBtn.click();
        return new HomePage(driver);
    }

    public LoginPage waitForLoginPageDisplaying() {
        waitForPresence(driver,3, emailTxt);
        return this;
    }

    public HomePage loginWithUserAndPass(String loginUser, String loginPass) {
        enterUserName(loginUser);
        enterPassword(loginPass);
        pressLoginBtn();
        return new HomePage(driver);
    }
}
