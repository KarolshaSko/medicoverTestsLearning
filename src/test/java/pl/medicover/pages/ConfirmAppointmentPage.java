package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmAppointmentPage {

    WebDriver driver;

    @FindBy(id = "bookAppointmentButton")
    private WebElement confirmBtn;

    @FindBy(xpath = "//a[@class='btn default' and text()='Anuluj']")
    private WebElement cancelBtn;

    public ConfirmAppointmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BookedAppointmentConfirmationPage confimAppointment() {
        confirmBtn.click();
        return new BookedAppointmentConfirmationPage(driver);
    }

    public VisitsPage cancelAppointment() {
        cancelBtn.click();
        return new VisitsPage(driver);
    }

}
