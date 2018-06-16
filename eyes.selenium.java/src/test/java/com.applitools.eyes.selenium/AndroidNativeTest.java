package com.applitools.eyes.selenium;

import com.applitools.eyes.LogHandler;
import com.applitools.eyes.StdoutLogHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import com.applitools.eyes.selenium.Eyes;

public class AndroidNativeTest {

    public static void main(String[] args) throws Exception {

        // Set desired capabilities.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("deviceName", "Custom Phone");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
//        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("clearSystemFiles", true);
        capabilities.setCapability("noReset", true);

        // Open the app.
//        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
        final String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
        final String url = "https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
        WebDriver driver = new AndroidDriver(new URL(url), capabilities);

        // Initialize the eyes SDK and set your private API key.
        Eyes eyes = new Eyes();
//        eyes.setScaleRatio(0.5);
        LogHandler logHandler = new StdoutLogHandler(true);
        eyes.setLogHandler(logHandler);
        eyes.setSaveDebugScreenshots(true);
//        eyes.setForceFullPageScreenshot(true);
        try {

            // Start the test.
            eyes.open(driver, "Contacts!", "My first Appium native Java test!");

//            driver.get("https://applitools.com");

            // Visual validation.
            eyes.checkWindow("Contact list!");

            // End the test.
            eyes.close();

        } finally {

            // Close the app.
            driver.quit();

            // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();

        }

    }

}
