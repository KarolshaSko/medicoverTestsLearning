package pl.medicover.pages;

import org.openqa.selenium.By;
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

    public BookedAppointmentConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public String getTitle() {
        return title.getText();
    }

//    public String getAppointmentDetails(String facilityName, String specialtyName) {
//        return driver.findElement("//div[@class='col-lg-12' and text()='"+ facilityName +"']").getText();
//        return driver.findElement("//div[@class='col-lg-12' and text()='"+ specialtyName +"']").getText();
//
//    }
}
