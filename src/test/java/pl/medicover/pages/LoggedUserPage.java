package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

public class LoggedUserPage {

    WebDriver driver;

    @FindBy(xpath = "//button[text()='Rozumiem']")
    private WebElement popupBtn;

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
        SeleniumHelper.waitForElementToBeClickable(popupBtn,driver);
        popupBtn.click();
        return this;
    }

    public DoctorPreselectPage selectDoctor(String name) {
        medicalSpecialtySelect.sendKeys(name, Keys.ENTER);
        searchBtn.click();
        return new DoctorPreselectPage(driver);
    }

}
