package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.models.User;

import java.util.ArrayList;

public class LoginWindowPage {

    WebDriver driver;

    @FindBy(id = "UserName")
    private WebElement userNameInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(id = "loginBtn")
    private WebElement loginBtn;

    @FindBy(xpath = "//h3[text()='Aktualizacja danych kontaktowych']")
    private WebElement updateDataTitle;

    @FindBy(xpath = "//div[@class='pull-right']/button[text()='Zapisz']")
    private WebElement saveBtn;

    public LoginWindowPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage loginUser(User user) {
        userNameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginBtn.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        try {
            updateDataTitle.isDisplayed();
            saveBtn.click();
            return new LoggedUserPage(driver);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return new LoggedUserPage(driver);
        }
    }


}
