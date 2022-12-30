package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CreateNewEventPage;
import pages.DashboardPage;
import pages.EditEventPage;
import pages.HomePage;
import utilities.Driver;


public abstract class StepDefinitionsBase {
    HomePage homePage = new HomePage();
    DashboardPage dashboardPage = new DashboardPage();
    CreateNewEventPage createNewEventPage = new CreateNewEventPage();
    EditEventPage editEventPage = new EditEventPage();
    void verifyElementAndMessage(WebElement element, String expectedMessage) {
        Driver.verifyElementDisplayed(element);
        String actualMessage = element.getText();
        Assert.assertEquals("Actual error message is not equal to expected.", expectedMessage, actualMessage);
    }

}
