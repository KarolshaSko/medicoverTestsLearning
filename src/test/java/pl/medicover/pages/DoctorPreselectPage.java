package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

public class DoctorPreselectPage {

    WebDriver driver;

    public DoctorPreselectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    private static final String searchBtnXpath = "//p[text()='Punkt Pobrań']/../..//button[text()='Umów']";
//
//    @FindBy(xpath = searchBtnXpath)
//    private WebElement searchBtn;

    public VisitsPage selectAppointmentType(String name) {
        String searchBtnXpath = "//p[text()='" + name + "']/../..//button[text()='Umów']";
        SeleniumHelper.waitForElementToBeVisible(By.xpath(searchBtnXpath), driver);
        WebElement searchBtn = driver.findElement(By.xpath(searchBtnXpath));
        searchBtn.click();
        return new VisitsPage(driver);
    }
}
