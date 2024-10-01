package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedAppointmentConfirmationPage {

    WebDriver driver;

    @FindBy(xpath = "//h2[@class='margin-bottom-20']")
    private WebElement title;

    @FindBy(xpath = "//div[@class='col-lg-12 visit-date']")
    private WebElement timeAndDate;

    @FindBy(xpath = "//div[@class='visit-content']//div[@class='col-lg-12'][1]")
    private WebElement specialtyName;

    @FindBy(xpath = "//div[@class='visit-content']//div[@class='col-lg-12'][2]")
    private WebElement facilityName;

    public BookedAppointmentConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTitle() {
        return title.getText();
    }

    public String getTime() {
        String time = timeAndDate.getText().split(" ",0)[1];
        return time;
    }

    public String getDate() {
        String date = timeAndDate.getText().split(" ",0)[0];
        return date;
    }

    public String getFacilityName() {
        return facilityName.getText();
    }

    public String getSpecialization() {
        return specialtyName.getText();
    }
}
