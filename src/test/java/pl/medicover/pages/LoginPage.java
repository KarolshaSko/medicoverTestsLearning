package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "oidc-submit")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginWindowPage goToLogin() {
        loginBtn.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new LoginWindowPage(driver);
    }
}
