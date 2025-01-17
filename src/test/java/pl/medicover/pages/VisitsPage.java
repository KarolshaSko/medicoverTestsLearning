package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class VisitsPage {

    WebDriver driver;

    public VisitsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    final String visitData = "//div[contains(concat(' ',normalize-space(@class),' '),'chakra-container')]/div[contains(concat(' ',normalize-space(@class),' '),'chakra-stack')]/div[3]/div[2]/div[1]/div[last()]/div[1]";

    @FindBy(xpath = visitData + "/button")
    private WebElement visitBookBtn;

    @FindBy(xpath = visitData + "/div[1]/p[1]")
    private WebElement visitTime;

    @FindBy(xpath = visitData + "/p[1]")
    private WebElement visitSpecializationAndCity;

    @FindBy(xpath = visitData + "/p[2]")
    private WebElement visitFacility;

    @FindBy(xpath = "//a[@data-testid='link-showAll']")
    private WebElement showAllBtn;

    @FindBy(xpath = "//div[@class='react-datepicker__input-container']//input[@data-testid='input-date']")
    private WebElement datePicker;

    @FindBy(xpath = "//button[@data-testid='button-search']")
    private WebElement searchBoxBtn;

    public String getSpecialization() {
        return visitSpecializationAndCity.getText();
    }

    public VisitsPage showAllAppointments() {
        showAllBtn.click();
        return this;
    }

    public ConfirmAppointmentPage bookAppointment() {
        visitBookBtn.click();
        return new ConfirmAppointmentPage(driver);
    }

    public VisitsPage setDate(String day) {
        datePicker.click();
        List<WebElement> dates = driver.findElements(By.xpath("//div[@class='react-datepicker-popper']//div[contains(concat(' ',normalize-space(@class),' '),'react-datepicker__day react-datepicker__day--')]"));
        for (WebElement date : dates) {
            String testData = date.getText();
            if (Objects.equals(date.getText(), day)) {
                new Actions(driver).moveToElement(date).click().perform();
                break;
            }
        }
        return this;
    }

    public String getTime() {
        return visitTime.getText();
    }

    public String getFacility() {
        return visitFacility.getText();
    }
}
