package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

public class MyVisitsPage {

    WebDriver driver;

    public MyVisitsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//table[@data-testid='planned-visits']//button[@data-testid='row-menu']")
    private WebElement visitItemMenu;

    public CancelAppointmentPage manageYourVisit(String option) {
        visitItemMenu.click();
        driver.findElement(By.xpath("//table[@data-testid='planned-visits']//button[@data-testid='row-menu']/following-sibling::div/div/button[text()='" + option + "']")).click();
        return new CancelAppointmentPage(driver);
    }


    private void waitForLoadingToFinish() {
        SeleniumHelper.waitForElementToBeVisible(By.xpath("//div[@class='blockUI blockMsg blockElement']"), driver);
        SeleniumHelper.waitForElementToNotBePresent(By.xpath("//div[@class='blockUI blockMsg blockElement']"), driver);
        SeleniumHelper.waitForElementToBeVisible(By.xpath("//div[@class='blockUI blockOverlay']"), driver);
        SeleniumHelper.waitForElementToNotBePresent(By.xpath("//div[@class='blockUI blockOverlay']"), driver);
    }

    public WebElement getLinkElementFromDropdown(String specialization, String menuOption) {
        waitForLoadingToFinish();
        WebElement dropdown = driver.findElement(By.xpath("//app-appointments-manager-visit-list//app-appointments-manager-visit//div[text()=' " + specialization + " '][1]/parent::div/following-sibling::div//button/parent::div"));
        WebElement cancelBtn = dropdown.findElement(By.xpath("//button"));
        SeleniumHelper.waitForElementToBeClickable(cancelBtn, driver);
        cancelBtn.click();
        return dropdown.findElement(By.xpath("//a[text()='" + menuOption + "'"));
    }

    public MyVisitsPage cancelAppointment(String specialization) {
        getLinkElementFromDropdown(specialization, " Odwołaj");
        return this;
    }


}
