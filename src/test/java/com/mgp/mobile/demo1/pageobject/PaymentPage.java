package com.mgp.mobile.demo1.pageobject;

import com.mgp.mobile.demo1.common.ElementHelper;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends ElementHelper {
    @FindBy(id = idPrefix + "phoneTextField")
    private WebElement phoneTxt;
    @FindBy(id = idPrefix + "nameTextField")
    private WebElement nameTxt;
    @FindBy(id = idPrefix + "amount")
    private WebElement amountSeekBar;
    @FindBy(id = idPrefix + "countryTextField")
    private WebElement countryTxt;
    @FindBy(id = idPrefix + "countryButton")
    private WebElement countryBtn;
    @FindBy(id = idPrefix + "sendPaymentButton")
    private WebElement sendPaymentBtn;
    @FindBy(id = idPrefix + "cancelButton")
    private WebElement cancelBtn;
    @FindBy(id = "android:id/button1")
    private WebElement confirmYesBtn;
    @FindBy(id = "android:id/button2")
    private WebElement confirmNoBtn;

    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    public void inputPhone(String phone) {
        waitForPresence(driver, 1, phoneTxt);
        phoneTxt.clear();
        phoneTxt.sendKeys(phone);
    }

    public void inputName(String name) {
        waitForPresence(driver, 1, nameTxt);
        nameTxt.clear();
        nameTxt.sendKeys(name);
    }

    public void inputCountry(String country) {
        waitForPresence(driver, 1, countryTxt);
        countryTxt.clear();
        countryTxt.sendKeys(country);
    }

    public void seekBarAmount(int percent) {
        // get start co-ordinate of seekbar
        int startX = amountSeekBar.getLocation().getX();
        //Get width of seekbar
        int endX = amountSeekBar.getSize().getWidth();
        //get location of seekbar vertically
        int y = amountSeekBar.getLocation().getY();
        int endMovedX =(int)(startX + endX*percent/100);
        PointOption pointStart = PointOption.point(startX, y);
        PointOption pointEnd = PointOption.point(endMovedX, y);

        // Select till which position you want to move the seekbar
        TouchAction action = new TouchAction(driver);
        action.press(pointStart).moveTo(pointEnd).release().perform();
    }

    public void pressCountryButton() {
        waitForPresence(driver, 1, countryBtn);
        countryBtn.click();
    }

    public void pressSendPaymentButton() {
        waitForPresence(driver, 1, sendPaymentBtn);
        sendPaymentBtn.click();
    }

    public HomePage pressYesButtonOnConfirmSendPaymentPopup() {
        waitForPresence(driver, 1, confirmYesBtn);
        confirmYesBtn.click();
        return new HomePage(driver);
    }

    public HomePage pressCancelButton() {
        waitForPresence(driver, 1, cancelBtn);
        cancelBtn.click();
        return new HomePage(driver);
    }

    public void waitForPaymentPageDisplaying() {
        waitForPresence(driver, 3, phoneTxt);
    }
}
