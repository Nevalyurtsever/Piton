package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditEventPage {
    public EditEventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[@class='section-title']")
    public WebElement editEventTitle;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement eventNameInput;

    @FindBy(xpath = "//input[@id='description']")
    public WebElement eventDescriptionInput;

    @FindBy(xpath = "//input[@formcontrolname='date']")
    public WebElement eventDateInput;

    @FindBy(xpath = "//input[@placeholder='Enter first name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Enter last name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Enter email or phone']")
    public WebElement contact;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']")
    public WebElement updateEventButton;
}
