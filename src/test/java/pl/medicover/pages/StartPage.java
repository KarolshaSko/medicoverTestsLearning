package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class StartPage {

    WebDriver driver;

    @FindBy(id = "cmpwrapper")
    private WebElement cmpWrapper;

    @FindBy(xpath = "//li[@class='last']//span[text()='Medicover OnLine']")
    private WebElement medicoverOnlineBtn;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public StartPage acceptCoockie() {
        SearchContext wrapper = cmpWrapper.getShadowRoot();
        WebElement button = wrapper.findElement(By.cssSelector("span#cmpbntyestxt"));
        button.click();
        return this;
    }

    public LoginPage goToMedicoverOnline() {
        medicoverOnlineBtn.click();
        driver.close();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return new LoginPage(driver);
    }

}
