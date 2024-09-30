package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

public class DoctorPreselectPage {

    WebDriver driver;

    private static final String searchBtnXpath = "//div[text()='Pobranie krwi i innych materiałów']/parent::div//button[text()='Umów']";

    @FindBy(xpath = searchBtnXpath)
    private WebElement searchBtn;

    public DoctorPreselectPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public VisitsPage scheduleFacilityConsulation() {
        SeleniumHelper.waitForElementToBeVisible(By.xpath(searchBtnXpath),driver);
        searchBtn.click();
        return new VisitsPage(driver);
    }
}
