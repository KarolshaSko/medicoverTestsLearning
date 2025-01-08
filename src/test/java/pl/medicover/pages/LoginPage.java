package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.models.User;

import java.util.ArrayList;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "cmpwrapper")
    private WebElement cmpWrapper;

    @FindBy(id = "usernameInput")
    private WebElement userNameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage acceptCookie(){
        SearchContext wrapper = cmpWrapper.getShadowRoot();
        WebElement button = wrapper.findElement(By.cssSelector("span#cmpwelcomebtnyes a"));
        button.click();
        return this;
    }

    public LoggedUserPage loginUser(User user) {
        userNameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        loginBtn.click();
        return new LoggedUserPage(driver);
    }
}
