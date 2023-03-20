package com.mgp.mobile.demo1.common;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Hooks extends BasePage{
    @Before
    public static void setupDriver() throws MalformedURLException {
        File appDir = new File(System.getProperty("user.dir") + "/apps");
        File app = new File(appDir, "EriBank.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @After
    public static void quitDriver() throws Exception{
//        driver.quit();
    }
}
