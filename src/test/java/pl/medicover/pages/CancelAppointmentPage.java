package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelAppointmentPage {

    WebDriver driver;

    public CancelAppointmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "confirmCancelVisit")
    private WebElement confirmCancelVisit;

    @FindBy(name = "cancel")
    private WebElement cancelBtn;

    @FindBy(xpath = "//p[text()='Wizyta została odwołana.']")
    private WebElement title;

    public CancelAppointmentPage confirmCancelVisit() {
        confirmCancelVisit.click();
        return this;
    }

    public String getTitle() {
        return title.getText();
    }


}
