package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestResultsDetailsPage {

    WebDriver driver;

    public TestResultsDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//p[text()='DATA PUBLIKACJI WYNIKU']/following-sibling::p")
    private WebElement publicationDate;

    @FindBy(xpath = "//p[text()='Lekarz / Specjalista']/following-sibling::p")
    private WebElement doctorName;

    public Boolean assertTextExist(String name) {
        return !driver.findElements(By.xpath("//p[text()='" + name + "']")).isEmpty();
    }

    public String getTestPublicationDate() {
        return publicationDate.getText();
    }

    public String getTestDoctorName() {
        return doctorName.getText();
    }
}
