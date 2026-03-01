package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static final ThreadLocal<AndroidDriver> androidDriverPool = new ThreadLocal<>();
    private static final ThreadLocal<IOSDriver> iosDriverPool = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(Driver.class);

    public static AndroidDriver getAppiumDriver() {
        if (androidDriverPool.get() == null) {
            String serverUrl = System.getenv("APPIUM_URL") != null
                    ? System.getenv("APPIUM_URL")
                    : "http://127.0.0.1:4723";
            URL appiumServerURL;
            try {
                appiumServerURL = new URL(serverUrl);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL: " + serverUrl, e);
            }

            UiAutomator2Options options = new UiAutomator2Options()
                    .setAutomationName(ConfigReader.getProperty("automationName"))
                    .setPlatformName(ConfigReader.getProperty("platformName"))
                    .setPlatformVersion(ConfigReader.getProperty("platformVersion"))
                    .setDeviceName(ConfigReader.getProperty("deviceName"))
                    .setApp(ConfigReader.getProperty("appPath"))
                    .setNoReset(false)
                    .setAutoGrantPermissions(true);

            androidDriverPool.set(new AndroidDriver(appiumServerURL, options));
            androidDriverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
            logger.info("Android driver started on: {}", serverUrl);
        }
        return androidDriverPool.get();
    }

    public static IOSDriver getIOSDriver() {
        if (iosDriverPool.get() == null) {
            String serverUrl = System.getenv("APPIUM_URL") != null
                    ? System.getenv("APPIUM_URL")
                    : "http://127.0.0.1:4723";
            URL appiumServerURL;
            try {
                appiumServerURL = new URL(serverUrl);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL: " + serverUrl, e);
            }

            XCUITestOptions options = new XCUITestOptions()
                    .setPlatformName(ConfigReader.getProperty("platformName"))
                    .setDeviceName(ConfigReader.getProperty("deviceName"))
                    .setBundleId(ConfigReader.getProperty("iosBundleId"));

            iosDriverPool.set(new IOSDriver(appiumServerURL, options));
            iosDriverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
            logger.info("iOS driver started on: {}", serverUrl);
        }
        return iosDriverPool.get();
    }

    public static void quitAppiumDriver() {
        if (androidDriverPool.get() != null) {
            androidDriverPool.get().quit();
            androidDriverPool.remove();
            logger.info("Android driver closed");
        }
        if (iosDriverPool.get() != null) {
            iosDriverPool.get().quit();
            iosDriverPool.remove();
            logger.info("iOS driver closed");
        }
    }
}
