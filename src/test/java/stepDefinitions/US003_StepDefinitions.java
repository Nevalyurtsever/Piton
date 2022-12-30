package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;

public class US003_StepDefinitions extends StepDefinitionsBase{

    private static final String dashboardPageUrl = ConfigReader.getProperty("dashboardPage");
    @Given("User is on the dashboard page")
    public void user_is_on_the_dashboard_page() {
        Driver.getDriver().get(dashboardPageUrl);
    }

    @Then("User sees message {string}")
    public void user_sees_message(String expectedMessage) {
        verifyElementAndMessage(dashboardPage.eventNotFoundMessage, expectedMessage);
    }

    @Then("User sees event edit page")
    public void user_sees_event_edit_page() {
        String editEventTitle = "Edit Event:";
        Driver.verifyElementDisplayed(editEventPage.editEventTitle);
        Assert.assertTrue(editEventPage.editEventTitle.getText().contains(editEventTitle));
    }

    @And("User clicks delete button")
    public void user_clicks_delete_button() {
        dashboardPage.deleteEventButton.click();
    }

    @And("User clicks participants button")
    public void user_clicks_participants_button() {
        dashboardPage.participantsButton.click();
    }


    @Then("User sees participants")
    public void user_sees_participants() {
       List<String> firstNameList = Driver.getElementsTextList(dashboardPage.participantFirstNameElements);
       List<String> lastNameList = Driver.getElementsTextList(dashboardPage.participantLastNameElements);
       List<String> contactList = Driver.getElementsTextList(dashboardPage.participantContactElements);
       Assert.assertEquals(firstNameList, List.of("Piton 10","Neval"));
       Assert.assertEquals(lastNameList, List.of("Event 10","Yurtsever"));
       Assert.assertEquals(contactList, List.of("piton10@gmail.com", "contact@gmail.com"));
    }



}
