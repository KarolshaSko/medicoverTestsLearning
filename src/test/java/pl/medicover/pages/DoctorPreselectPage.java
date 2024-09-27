package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.medicover.utils.SeleniumHelper;

import java.time.Duration;

public class DoctorPreselectPage {

    WebDriver driver;

    private static final String searchBtnXpath = "//div[text()='Wizyta w placówce']/parent::div//button[text()='Umów']";

    @FindBy(xpath = searchBtnXpath)
    private WebElement searchBtn;

    public DoctorPreselectPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public DoctorSelectPage scheduleFacilityConsulation() {
        SeleniumHelper.waitForElementToBeVisible(By.xpath(searchBtnXpath),driver);
        searchBtn.click();
        return new DoctorSelectPage(driver);
    }
}
