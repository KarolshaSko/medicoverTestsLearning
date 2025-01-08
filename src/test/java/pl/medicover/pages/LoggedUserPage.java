package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

public class LoggedUserPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@data-testid='multiselect-spec']//div[@id='react-select-6-placeholder']/following-sibling::div/input")
    private WebElement medicalSpecialtyInput;

    @FindBy(xpath = "//button[@data-testid='button-appointment']")
    private WebElement searchBtn;

    @FindBy(xpath = "//button[text()='Badania']")
    private WebElement examinationTab;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage() {
    }

    public LoggedUserPage selectTab(String name){
        WebElement tab = driver.findElement(By.xpath("//button[text()='"+ name + "']"));
        tab.click();
        return this;
    }

    public DoctorPreselectPage selectSpecialization(String name) {
        medicalSpecialtyInput.sendKeys(name, Keys.ENTER);
        searchBtn.click();
        return new DoctorPreselectPage(driver);
    }

}
