package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class US001_StepDefinitions extends StepDefinitionsBase{

    private static final String homePageUrl = ConfigReader.getProperty("homePage");
    private static final String username = ConfigReader.getProperty("username");
    private static final String password = ConfigReader.getProperty("password");

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        Driver.getDriver().get(homePageUrl);
    }

    @Then("User sees username input")
    public void user_sees_username_input() {
        Driver.verifyElementDisplayed(homePage.usernameInput);
    }

    @Then("User sees password input")
    public void user_sees_password_input() {
        Driver.verifyElementDisplayed(homePage.passwordInput);
    }

    @Then("User sees login button")
    public void user_sees_login_button() {
        Driver.verifyElementDisplayed(homePage.loginButton);
    }

    @Given("User enters valid username")
    public void user_enters_valid_username() {
        homePage.usernameInput.sendKeys(username);
    }

    @Given("User enters valid password")
    public void user_enters_valid_password() {
        homePage.passwordInput.sendKeys(password);
    }

    @Given("User clicks login button")
    public void user_clicks_login_button() {
       homePage.loginButton.click();
    }

    @Then("User sees title {string} instead of login form")
    public void user_sees_title_instead_of_login_form(String expectedTitle) {
        String actualTitle = dashboardPage.eventsTitle.getText();
        Assert.assertEquals("Actual title is not equal to expected title", expectedTitle, actualTitle);
    }

    @Then("User sees validation errors")
    public void user_sees_validation_errors() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOf(homePage.usernameValidationError));
        ReusableMethods.takeScreenshot();

        String userNameExpectedErrorMessage = "Username field is required";
        verifyElementAndMessage(homePage.usernameValidationError, userNameExpectedErrorMessage);

        String passwordExpectedErrorMessage = "Password field is required";
        verifyElementAndMessage(homePage.passwordValidationError, passwordExpectedErrorMessage);
    }

    @Then("User sees dashboard page and welcome message")
    public void user_sees_dashboard_page_and_welcome_message() {
        ReusableMethods.takeScreenshot();
        Driver.verifyElementDisplayed(dashboardPage.welcomeMessage);
        String expectedWelcomeMessage = "Welcome Automation Test User";
        String actualWelcomeMessage = dashboardPage.welcomeMessage.getText();
        Assert.assertEquals("Actual Welcome message is not equal to expected", expectedWelcomeMessage, actualWelcomeMessage);
    }

    @After
    public void afterScenario(){
        ReusableMethods.takeScreenshot();
        Driver.closeDriver();
    }

}
