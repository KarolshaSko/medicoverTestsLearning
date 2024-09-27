package pl.medicover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VisitsPage {

    WebDriver driver;

    public VisitsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
}
