package com.applitools.eyes.selenium;

import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.fluent.Target;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class AndroidNativeAppTest
{

    public static DesiredCapabilities getDesiredCapabalities() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "6.0");
        dc.setCapability("deviceName", "Google Nexus 5");
        dc.setCapability("automationName", "uiautomator2");

        dc.setCapability("app", "https://applitools.bintray.com/Examples/app-debug.apk");

        dc.setCapability("appPackage", "com.applitoolstest");
        dc.setCapability("appActivity", "com.applitoolstest.ScrollActivity");
        dc.setCapability("newCommandTimeout", 600);
        return dc;
    }

    public static void main( String[] args) throws MalformedURLException, InterruptedException {
        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");

        Eyes eyes = new Eyes();
        eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));
        eyes.setLogHandler(new StdoutLogHandler(true));
//        eyes.setScrollToRegion(true);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(serverAddress, getDesiredCapabalities());
        try {
            eyes.open(driver, "Android Appium Demo", "Basic checkWindow");
            Thread.sleep(10000);

            MobileElement scrollableElement = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().scrollable(true)"));

            eyes.check("Main window with ignore", Target.region(scrollableElement).ignore(scrollableElement));

            eyes.close(false);
        } finally {
            eyes.abortIfNotClosed();
            driver.quit();
        }

    }
}
