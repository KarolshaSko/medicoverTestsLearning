package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.medicover.utils.SeleniumHelper;

public class MenuPage {

    WebDriver driver;

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "menu-button-:rk:")
    private WebElement visitsDropdown;

    @FindBy(xpath = "//nav[@class='header navbar navbar-inverse mol-nav']//ul[@class='navbar-nav nav']/li[5]")
    private WebElement myHealthDropdown;

    public MyVisitsPage selectFromVisitsDropdown(String name) {
        SeleniumHelper.waitForElementToBePresent(By.id("menu-button-:rk:"), driver);
        Actions action = new Actions(driver);
        action.moveToElement(visitsDropdown).build().perform();
        driver.findElement(By.xpath("//div[@id='menu-list-:rk:']//button[text()='" + name + "']")).click();
        action.moveToLocation(0, 0).build().perform();
        return new MyVisitsPage(driver);
    }

    public TestResultsPage goToTestResults() {
        Actions action = new Actions(driver);
        action.moveToElement(myHealthDropdown).build().perform();
        driver.findElement(By.xpath("//ul[@class='navbar-nav nav']/li/ul/li/a[text()='Wyniki badań']")).click();
        return new TestResultsPage(driver);
    }
}
