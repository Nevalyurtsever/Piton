package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='mat-error-0']")
    public WebElement usernameValidationError;

    @FindBy(xpath = "//*[@id='mat-error-1']")
    public WebElement passwordValidationError;
}
