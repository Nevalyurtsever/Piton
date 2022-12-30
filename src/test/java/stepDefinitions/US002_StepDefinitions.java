package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class US002_StepDefinitions extends StepDefinitionsBase{
    @Given("User clicks create event button")
    public void user_clicks_create_event_button() {
        dashboardPage.createEventButton.click();
    }

    @Then("User sees {string} title")
    public void user_sees_title(String expectedCreateEventTitle) {
        Driver.verifyElementDisplayed(createNewEventPage.createEventTitle);
        String actualCreateEventTitle = createNewEventPage.createEventTitle.getText();
        Assert.assertEquals("Actual title is not equal to expected.", expectedCreateEventTitle, actualCreateEventTitle);
    }

    @Then("User sees create new event button")
    public void user_sees_create_new_event_button() {
        Driver.verifyElementDisplayed(createNewEventPage.createNewEventButton);
    }

    @When("User clicks create new event button")
    public void user_clicks_create_new_event_button() {
        createNewEventPage.createNewEventButton.click();
    }

    @Then("User sees create event form validation errors")
    public void user_sees_create_event_form_validation_errors() {
        Driver.waitForVisibility(createNewEventPage.eventNameValidationError, Duration.ofSeconds(10));

        String expectedEventNameError = "Event name field is required";
        verifyElementAndMessage(createNewEventPage.eventNameValidationError, expectedEventNameError);

        String expectedEventDateError = "Please choose a valid date";
        verifyElementAndMessage(createNewEventPage.eventDateValidationError, expectedEventDateError);

        String expectedNameError = "Participant name is required";
        verifyElementAndMessage(createNewEventPage.firstNameValidationError, expectedNameError);

        String expectedLastNameError = "Participant last name is required";
        verifyElementAndMessage(createNewEventPage.lastNameValidationError, expectedLastNameError);

        String expectedContactError = "Please enter email or phone number";
        verifyElementAndMessage(createNewEventPage.contactValidationError, expectedContactError);
    }

    @When("User clicks add participant button")
    public void user_clicks_add_participant_button() {
        createNewEventPage.addParticipantButton.click();
    }

    @Then("user sees new firstname, lastname and contact inputs for new participant")
    public void user_sees_new_firstname_lastname_and_contact_inputs_for_new_participant() {
        Driver.verifyElementDisplayed(createNewEventPage.firstNameInput2);
        Driver.verifyElementDisplayed(createNewEventPage.lastNameInput2);
        Driver.verifyElementDisplayed(createNewEventPage.contactInput2);
    }

    @When("User deletes all participants")
    public void user_deletes_all_participants() {
        List<WebElement> deleteButtons = createNewEventPage.deleteParticipantButtons;
        for (WebElement e : deleteButtons) {
            e.click();
        }
    }
    @Then("User sees participant error message")
    public void user_sees_participant_error_message() {
        String expectedErrorMessage = "Please add participant!";
        verifyElementAndMessage(createNewEventPage.participantError, expectedErrorMessage);
    }

    @And("User enters event name {string}")
    public void user_enters_event_name(String eventName) {
        createNewEventPage.eventNameInput.sendKeys(eventName);
    }
    @And("User enters event date {string}")
    public void user_enters_event_date(String eventDate) {
        createNewEventPage.eventDateInput.sendKeys(eventDate);
    }
    @Given("User enters participant {string} {string} {string}")
    public void user_enters_participant(String firstName, String lastName, String contact) {
        createNewEventPage.firstNameInput.sendKeys(firstName);
        createNewEventPage.lastNameInput.sendKeys(lastName);
        createNewEventPage.contactInput.sendKeys(contact);
    }

    @Given("User enters second participant {string} {string} {string}")
    public void user_enters_second_participant(String firstName, String lastName, String contact) {
        createNewEventPage.firstNameInput2.sendKeys(firstName);
        createNewEventPage.lastNameInput2.sendKeys(lastName);
        createNewEventPage.contactInput2.sendKeys(contact);
    }

    @Given("User selects event date from date-picker")
    public void user_selects_event_date_from_date_picker() {
        createNewEventPage.eventDatePicker.click();
        createNewEventPage.randomDateFromDatePicker.click();
    }

    @Then("User sees {string} message and redirects dashboard page with {string}")
    public void user_sees_message_and_redirects_dashboard_page_with(String successfulMessage, String expectedEventName) {
        Driver.wait(3);
        verifyElementAndMessage(dashboardPage.successfulMessage, successfulMessage);
        List<String> eventNameList = Driver.getElementsTextList(dashboardPage.eventNameElementList);
        Assert.assertTrue(eventNameList.contains(expectedEventName));
    }

    @And("User clicks edit event button")
    public void user_clicks_edit_event_button() {
        dashboardPage.editEventButton.click();
    }

    @Given("User enters event description {string}")
    public void user_enters_event_description(String description) {
        createNewEventPage.eventDescriptionInput.sendKeys(description);
    }
    @Then("User sees event name {string} description {string} date {string} firstname {string} lastname {string} contact {string}")
    public void user_sees_event_name_event_description_event_date_firstname_lastname_contact(String eventName, String description,
                                                                                             String date, String firstName,
                                                                                             String lastName, String contact) {
        verifyFormInputText(editEventPage.eventNameInput, eventName);
        verifyFormInputText(editEventPage.eventDescriptionInput, description);
        verifyFormInputText(editEventPage.eventDateInput, date);
        verifyFormInputText(editEventPage.firstName, firstName);
        verifyFormInputText(editEventPage.lastName, lastName);
        verifyFormInputText(editEventPage.contact, contact);

    }

    private void verifyFormInputText(WebElement element, String expectedText) {
        String elementText = element.getAttribute("value");
        Assert.assertEquals("Actual text is not equal to expected.", expectedText, elementText);
    }

    @Given("User updates event name {string}")
    public void user_updates_event_name(String newEventName) {
        editEventPage.eventNameInput.clear();
        editEventPage.eventNameInput.sendKeys(newEventName);
    }


    @When("User clicks update event button")
    public void user_clicks_update_event_button() {
        editEventPage.updateEventButton.click();
    }


}
