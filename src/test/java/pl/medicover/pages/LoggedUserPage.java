package pl.medicover.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    WebDriver driver;

    @FindBy(xpath = "//button[text()='Rozumiem']")
    private WebElement popupBtn;

    @FindBy(xpath = "//nav[@class='header navbar navbar-inverse mol-nav']//ul[@class='navbar-nav nav']/li[2]")
    private WebElement visitsDropdown;

    @FindBy(xpath = "//div[@class='ng-input']/input")
    private WebElement medicalSpecialtySelect;

    @FindBy(xpath = "//button[@class='btn blue search-button' and text()=' Szukaj ']")
    private WebElement searchBtn;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage() {
    }

    public LoggedUserPage clickPopup() {
        popupBtn.click();
        return this;
    }

    public DoctorPreselectPage selectDoctor(String name) {
        medicalSpecialtySelect.sendKeys(name, Keys.ENTER);
        searchBtn.click();
        return new DoctorPreselectPage(driver);
    }
}
