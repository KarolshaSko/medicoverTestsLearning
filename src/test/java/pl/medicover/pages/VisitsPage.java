package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

public class VisitsPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@class='btn blue' and text()='Szukaj']")
    private WebElement searchBtn;

    @FindBy(xpath = "//app-visit-list//app-slot[1]//div[@class='specialization']")
    private WebElement visitSlotSpecialization;

    @FindBy(xpath = "//app-visit-list//app-slot[1]//button[text()=' Umów ']")
    private WebElement visitSlotBookBtn;

    @FindBy(xpath = "//label[text()='Data wizyty od ']/parent::div//input")
    private WebElement datePicker;

    public VisitsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        waitForLoadingToFinish();
    }

    public String getSpecialization(String text) {
//        SeleniumHelper.waitForTextToBePresent(visitSlotSpecialization, text, driver);
        return visitSlotSpecialization.getText();
    }

    public ConfirmAppointmentPage bookAppointment() {
        visitSlotBookBtn.click();
        return new ConfirmAppointmentPage(driver);
    }

    private void waitForLoadingToFinish() {
        SeleniumHelper.waitForElementToBeVisible(By.xpath("//div[@class='blockUI blockOverlay']") ,driver);
        SeleniumHelper.waitForElementToNotBePresent(By.xpath("//div[@class='blockUI blockOverlay']") ,driver);
    }

    public VisitsPage setDate(String date) {
        datePicker.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        datePicker.sendKeys(date, Keys.ENTER);
        waitForLoadingToFinish();
        searchBtn.click();
        return  this;
    }
}
