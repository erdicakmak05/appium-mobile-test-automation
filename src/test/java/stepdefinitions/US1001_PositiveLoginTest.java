package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.android.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US1001_PositiveLoginTest {

    Homepage homepage = new Homepage();


    @Given("user opens the trendyol application")
    public void userOpensTheTrendyolApplication() {
        Driver.getAppiumDriver();
        homepage.cinsiyetSecimi.click();
    }
    @Given("user clicks on the my account tab")
    public void userClicksOnTheMyAccountTab() {
        homepage.hesabimTab.click();
        homepage.cancelEmailSelectButton.click();
    }

    @Then("user enters {string} as email")
    public void userEntersAsEmail(String mail) {
        homepage.emailTextbox.sendKeys(ConfigReader.getProperty(mail));
    }

    @And("user enters {string} as password")
    public void userEntersAsPassword(String password) {
        homepage.passwordTextbox.sendKeys(ConfigReader.getProperty(password));
    }


    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        homepage.girisYapButton.click();
        Driver.getAppiumDriver().navigate().back();
        //homepage.touchScreen.click();
    }

    @And("it is verified that the user has successfully logged in")
    public void itIsVerifiedThatTheUserHasSuccessfullyLoggedIn() {
        String actualNameSurname = homepage.nameSurnameText.getText();
        String expectedNameSurname = ConfigReader.getProperty("UserNameSurname");
        Assert.assertEquals(expectedNameSurname,actualNameSurname);
    }

    @And("user closes the application")
    public void userClosesTheApplication() {
        // Driver cleanup handled by Hooks @After
    }
}
