package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.android.Homepage;

public class US1002_NegativeLoginTest {
    Homepage homepage = new Homepage();

    @Then("it is verified that the user could not log in")
    public void itIsVerifiedThatTheUserCouldNotLogIn() {
        Assert.assertTrue(homepage.hataliLogin.isDisplayed(),
                "Error message should be displayed for failed login");
    }
}
