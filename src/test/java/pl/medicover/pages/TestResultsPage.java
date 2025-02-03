package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestResultsPage {

    WebDriver driver;

    public TestResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "Criteria_StartDate")
    private WebElement datePicker;

    @FindBy(id = "react-select-5-placeholder")
    private WebElement specializationSelect;

    @FindBy(xpath = "//tr[@data-testid='row-0']//button[@data-testid='row-menu'][1]")
    private WebElement testResultItemMenu;

    @FindBy(xpath = "//tr[@data-testid='row-0']/td[4]/div/ul/li/p")
    private WebElement testName;

    @FindBy(xpath = "//tr[@data-testid='row-0']/td/div/p")
    private WebElement testPublicationDate;

    @FindBy(xpath = "//tr[@data-testid='row-0']/td[2]//p")
    private WebElement testDoctorName;

    public TestResultsPage setDate(String date) {
        datePicker.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        datePicker.sendKeys(date, Keys.ENTER);
        return this;
    }

    public TestResultsPage setSpecialization(String name) {
        Select dropdown = new Select(driver.findElement(By.id("Criteria_SpecializationId")));
        dropdown.selectByVisibleText(name);
        return this;
    }

    public TestResultsDetailsPage goToTestResultDetails() {
        testResultItemMenu.click();
        driver.findElement(By.xpath("//tr[@data-testid='row-0']//button[@data-testid='row-menu-undefined']")).click();
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
