package pl.medicover.tests;

import org.testng.annotations.Test;
import pl.medicover.models.User;
import pl.medicover.pages.StartPage;

public class SearchDoctorTest extends BaseTest {
    @Test
    public void searchDoctorTest() {

        User user = new User();

        new StartPage(driver).acceptCoockie()
                .goToMedicoverOnline()
                .goToLogin()
                .loginUser(user)
                .clickPopup();
    }
}
