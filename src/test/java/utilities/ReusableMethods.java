package utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ReusableMethods {

    public static void clickOnPage(String pageName) throws InterruptedException {
        Thread.sleep(4000);
        List<WebElement> pages = Driver.getAppiumDriver().findElements(By.className("android.widget.TextView"));
        for (WebElement page : pages) {
            if (page.getText().equals(pageName)) {
                page.click();
                break;
            } else {
                scrollWithUiScrollable(pageName);
                break;
            }
        }
    }

    public static void clickOnPage1(String pageName) throws InterruptedException {
        Thread.sleep(4000);
        List<WebElement> pages = Driver.getAppiumDriver().findElements(By.xpath("//android.widget.TextView[@text='" + pageName + "']"));
        if (!pages.isEmpty()) {
            pages.get(0).click();
        } else {
            scrollWithUiScrollable(pageName);
        }
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = Driver.getAppiumDriver();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
        driver.findElement(By.xpath("//*[@text='" + elementText + "']")).click();
    }

    public static void longPressOnElement(WebElement element) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);
        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(element), 0, 0));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.fromElement(element), 0, 0));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        Driver.getAppiumDriver().perform(Collections.singletonList(longPress));
    }

    public static void clickOnPageIOS(String text) {
        List<WebElement> pages = Driver.getIOSDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name='" + text + "']"));
        if (pages.get(0).isDisplayed()) {
            pages.get(0).click();
        } else {
            scrollAndClickOnIOS(text);
        }
    }

    public static void scrollAndClickOnIOS(String text) {
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("value", text);
        Driver.getIOSDriver().executeScript("mobile: scroll", scrollObject);
        Driver.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + text + "']")).click();
    }
}
