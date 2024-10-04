package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestResultsDetailsPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='row result-row']//div[@class='col-xs-5 col-sm-5 col-md-5']")
    private WebElement testName;

    @FindBy(xpath = "//dd[text()='Data publikacji wyników:']/following-sibling::dt[1]")
    private WebElement publicationDate;

    @FindBy(xpath = "//dd[text()='Lekarz:']//following-sibling::dt")
    private WebElement doctorName;

    public TestResultsDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public String getTestName() {
        return testName.getText();
    }

    public String getTestPublicationDate() {
        return publicationDate.getText();
    }

    public String getTestDoctorName() {
        return doctorName.getText();
    }
}
