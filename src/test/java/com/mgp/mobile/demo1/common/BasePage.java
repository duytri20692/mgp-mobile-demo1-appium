package com.mgp.mobile.demo1.common;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    public static AndroidDriver driver;
    private static final String configPathFile = "src\\test\\resources\\testData\\Config.properties";
    protected static String loginUser = ReadPropertiesFileHelper.readPropertiesFile(configPathFile,"loginUser");
    protected static String loginPass = ReadPropertiesFileHelper.readPropertiesFile(configPathFile,"loginPass");
}
