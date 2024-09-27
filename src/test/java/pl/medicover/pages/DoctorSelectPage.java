package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorSelectPage {

    WebDriver driver;

    @FindBy(xpath = "//button[@class='btn blue' and text()='Szukaj']")
    private WebElement searchBtn;

    public DoctorSelectPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public VisitsPage fillAdvancedSearchForm() {
        searchBtn.click();
        return new VisitsPage(driver);
    }
}
