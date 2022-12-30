package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//strong[normalize-space()='Welcome Automation Test User']")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//span[text()='Events']")
    public WebElement eventsTitle;

    @FindBy(xpath = "//body/app-root[1]/app-dashboard[1]/div[1]/mat-card[2]/mat-card-title[1]/button[1]")
    public WebElement createEventButton;

    @FindBy(xpath = "//*[@class='mat-simple-snackbar ng-star-inserted']//span")
    public WebElement successfulMessage;

    @FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted']")
    public List<WebElement> eventNameElementList;

    @FindBy(xpath = "//td[@class='mat-cell cdk-cell cdk-column-date mat-column-date ng-star-inserted']")
    public List<WebElement> eventDateElementList;

    @FindBy(xpath = "//button[@title='Edit Event']")
    public WebElement editEventButton;

    @FindBy(xpath = "//button[@title='Delete Event']")
    public WebElement deleteEventButton;

    @FindBy(xpath = "//button[@title='Participants']")
    public WebElement participantsButton;

    @FindBy(xpath = "//*[text() = ' No registered event has been found!! ']")
    public WebElement eventNotFoundMessage;

    @FindBy(xpath = "//table[@class='participant-table']//tr//td[2]")
    public List<WebElement> participantFirstNameElements;

    @FindBy(xpath = "//table[@class='participant-table']//tr//td[3]")
    public List<WebElement> participantLastNameElements;

    @FindBy(xpath = "//table[@class='participant-table']//tr//td[4]")
    public List<WebElement> participantContactElements;
}
