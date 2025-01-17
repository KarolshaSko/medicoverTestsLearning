package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

import java.util.List;
import java.util.Objects;

public class LoggedUserPage {

    WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage() {
    }

    @FindBy(xpath = "//h2[text()='Umów wizytę lub badanie']/../..")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@data-testid='button-appointment']")
    private WebElement searchBtn;

    @FindBy(xpath = "//button[text()='Badania']")
    private WebElement examinationTab;

    public Integer selectTab(String name) {
        SeleniumHelper.waitForElementToBeVisible(By.xpath("//div[text()='Wybierz specjalizację lub usługę']"), driver);
        List<WebElement> tabs = searchBox.findElements(By.xpath("//div[@role='tablist']/button"));
        Integer index = 1;
        for (WebElement tab : tabs) {
            if (Objects.equals(tab.getText(), name)) {
                tab.click();
                break;
            }
            index++;
        }
        return index;
    }

    public DoctorPreselectPage selectSpecialization(String tabName, String specializationName) {
        Integer index = selectTab(tabName);
        WebElement selectedTab = searchBox.findElement(By.xpath("//div[contains(concat(' ',normalize-space(@class),' '),' chakra-tabs__tab-panels ')]/div[" + index.toString() + "]"));
        WebElement medicalSpecialtyInput = selectedTab.findElement(By.xpath("//div[text()='Wybierz specjalizację lub usługę']/following-sibling::div/input"));
        SeleniumHelper.waitForElementToBeClickable(medicalSpecialtyInput, driver);
        medicalSpecialtyInput.sendKeys(specializationName, Keys.ENTER);
        searchBtn.click();
        return new DoctorPreselectPage(driver);
    }

}
