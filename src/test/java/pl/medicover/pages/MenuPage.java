package pl.medicover.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    WebDriver driver;

    @FindBy(xpath = "//nav[@class='header navbar navbar-inverse mol-nav']//ul[@class='navbar-nav nav']/li[2]")
    private WebElement visitsDropdown;

    @FindBy(xpath = "//nav[@class='header navbar navbar-inverse mol-nav']//ul[@class='navbar-nav nav']/li[5]")
    private WebElement myHealthDropdown;

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public MyVisitsPage goToCancelAppointment() {
        Actions action = new Actions(driver);
        action.moveToElement(visitsDropdown).build().perform();
        driver.findElement(By.xpath("//ul[@class='navbar-nav nav']/li/ul/li/a[text()='Odwołaj wizytę']")).click();
        return new MyVisitsPage(driver);
    }

    public TestResultsPage goToTestResults() {
        Actions action = new Actions(driver);
        action.moveToElement(myHealthDropdown).build().perform();
        driver.findElement(By.xpath("//ul[@class='navbar-nav nav']/li/ul/li/a[text()='Wyniki badań']")).click();
        return new TestResultsPage(driver);
    }
}
