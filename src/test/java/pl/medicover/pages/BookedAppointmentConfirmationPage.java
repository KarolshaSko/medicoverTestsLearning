package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedAppointmentConfirmationPage {

    WebDriver driver;

    @FindBy(xpath = "//p[text()='Wizyta została umówiona!']")
    private WebElement title;

    public BookedAppointmentConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTitle() {
        return title.getText();
    }
}
