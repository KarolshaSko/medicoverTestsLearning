package pl.medicover.pages;

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
}
