package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CreateNewEventPage {

    public CreateNewEventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[@class='section-title']")
    public WebElement createEventTitle;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement eventNameInput;

    @FindBy(xpath = "//*[@id ='mat-error-2']")
    public WebElement eventNameValidationError;

    @FindBy(xpath = "//input[@id='description']")
    public WebElement eventDescriptionInput;

    @FindBy(xpath = "//input[@formcontrolname='date']")
    public WebElement eventDateInput;

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    public WebElement eventDatePicker;

    @FindBy(xpath = "//td[@aria-label='30 December 2022']")
    public WebElement randomDateFromDatePicker;

    @FindBy(xpath = "//*[@id ='mat-error-3']")
    public WebElement eventDateValidationError;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-flat-button mat-button-base']")
    public WebElement addParticipantButton;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-icon-button mat-button-base mat-warn']")
    public List<WebElement> deleteParticipantButtons;

    @FindBy(xpath = "//p[text()='Please add participant!']")
    public WebElement participantError;

    @FindBy(xpath = "//input[@id='mat-input-5']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//*[@id ='mat-error-4']")
    public WebElement firstNameValidationError;

    @FindBy(xpath = "//input[@id='mat-input-6']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//*[@id ='mat-error-5']")
    public WebElement lastNameValidationError;

    @FindBy(xpath = "//input[@id='mat-input-7']")
    public WebElement contactInput;

    @FindBy(xpath = "//*[@id ='mat-error-6']")
    public WebElement contactValidationError;

    @FindBy(xpath = "//input[@id='mat-input-8']")
    public WebElement firstNameInput2;

    @FindBy(xpath = "//input[@id='mat-input-9']")
    public WebElement lastNameInput2;

    @FindBy(xpath = "//input[@id='mat-input-10']")
    public WebElement contactInput2;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']")
    public WebElement createNewEventButton;


}
