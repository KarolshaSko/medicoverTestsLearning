package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestResultsPage {

    WebDriver driver;

    @FindBy(id = "Criteria_StartDate")
    private WebElement datePicker;

    @FindBy(id = "Criteria_SpecializationId")
    private WebElement specializationSelect;

    @FindBy(xpath = "//button[@class='btn blue' and text()='Szukaj']")
    private WebElement searchBtn;

    @FindBy(xpath = "//table[@class='table table-mol ']//tr[1]//td//a[text()='Szczegóły']")
    private WebElement detailsBtn;

    @FindBy(xpath = "//table[@class='table table-mol ']//tr[1]//td[4]")
    private WebElement testName;

    @FindBy(xpath = "//table[@class='table table-mol ']//tr[1]//td[1]")
    private WebElement testPublicationDate;

    @FindBy(xpath = "//table[@class='table table-mol ']//tr[1]//td[2]")
    private WebElement testDoctorName;

    public TestResultsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public TestResultsPage setDate(String date) {
        datePicker.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        datePicker.sendKeys(date, Keys.ENTER);
        return  this;
    }

    public TestResultsPage setSpecialization(String name) {
        Select dropdown = new Select(driver.findElement(By.id("Criteria_SpecializationId")));
        dropdown.selectByVisibleText(name);
        return this;
    }

    public TestResultsPage confirmChosenCriteria() {
        searchBtn.click();
        return this;
    }

    public TestResultsDetailsPage goToTestReultDetails() {
        detailsBtn.click();
        return new TestResultsDetailsPage(driver);
    }

    public String getTestName() {
        return testName.getText();
    }

    public String getTestPublicationDate() {
        return testPublicationDate.getText();
    }

    public String getTestDoctorName() {
        return testDoctorName.getText();
    }

    public Integer getTestResultAmount() {
        return driver.findElements(By.xpath("//table[@class='table table-mol ']//tbody//tr")).size();
    }
}
