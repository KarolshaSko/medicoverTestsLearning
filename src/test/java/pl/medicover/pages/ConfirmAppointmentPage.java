package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

public class ConfirmAppointmentPage {

    WebDriver driver;

    public ConfirmAppointmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private final String confirmBtnXpath = "//button[@data-testid='button-book']";

    @FindBy(xpath = "//button[@data-testid='button-cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//input[@name='informationDispatcher-0']/following-sibling::span[1]")
    private WebElement infoCheckbox;

    @FindBy(xpath = "//p[text()='LEKARZ / SPECJALISTA']/../div/div/p")
    private WebElement specialization;

    @FindBy(xpath = "//p[text()='PLACÓWKA']/../div/div/p")
    private WebElement facilityName;

    @FindBy(xpath = "//p[text()='TERMIN']/../div/div/p")
    private WebElement timeAndDate;

    public BookedAppointmentConfirmationPage confimAppointment() {
        infoCheckbox.click();
        SeleniumHelper.waitForElementToBeVisible(By.xpath(confirmBtnXpath), driver);
        driver.findElement(By.xpath(confirmBtnXpath)).click();
        return new BookedAppointmentConfirmationPage(driver);
    }

    public VisitsPage cancelAppointment() {
        cancelBtn.click();
        return new VisitsPage(driver);
    }

    public String getSpecialization() {
        return specialization.getText();
    }

    public String getFacilityName() {
        return facilityName.getText();
    }

    public String getTimeAndDate() {
        return timeAndDate.getText();
    }

}
