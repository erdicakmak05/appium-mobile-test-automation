package pages.android;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class Homepage {

    public Homepage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(10)), this);
    }

    @FindBy(id = "trendyol.com:id/buttonSelectGenderMan")
    public WebElement cinsiyetSecimi;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Hesabım']")
    public WebElement hesabimTab;

    @FindBy(id = "trendyol.com:id/editTextEmail")
    public WebElement emailTextbox;

    @FindBy(id = "trendyol.com:id/editTextPassword")
    public WebElement passwordTextbox;

    @FindBy(id = "trendyol.com:id/buttonLogin")
    public WebElement girisYapButton;

    @FindBy(id = "com.google.android.gms:id/cancel")
    public WebElement cancelEmailSelectButton;

    @FindBy(className = "android.view.ViewGroup")
    public WebElement touchScreen;

    @FindBy(id = "trendyol.com:id/textViewWelcoming")
    public WebElement nameSurnameText;

    @FindBy(id = "trendyol.com:id/snackbar_text")
    public WebElement hataliLogin;
}
