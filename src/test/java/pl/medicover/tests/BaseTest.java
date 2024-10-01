package pl.medicover.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.medicover.models.User;
import pl.medicover.pages.LoggedUserPage;
import pl.medicover.pages.StartPage;
import pl.medicover.utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LoggedUserPage loggedUserPage;
    User user = new User();

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.medicover.pl/");

        loggedUserPage = new StartPage(driver).acceptCoockie()
                .goToMedicoverOnline()
                .goToLogin()
                .loginUser(user)
                .clickPopup();
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }
}
