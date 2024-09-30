package pl.medicover.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.medicover.models.User;
import pl.medicover.pages.StartPage;
import pl.medicover.pages.VisitsPage;

public class ManageAppointmentsTest extends BaseTest {

    User user = new User();

    @Test
    public void searchDoctorTest() {


        VisitsPage visitsPage = new StartPage(driver).acceptCoockie()
                .goToMedicoverOnline()
                .goToLogin()
                .loginUser(user)
                .clickPopup()
                .selectDoctor("Pobranie krwi i innych materiałów")
                .scheduleFacilityConsulation();

        Assert.assertTrue(visitsPage.getSpecialization("Punkt Pobrań - dorośli").contains("Punkt Pobrań - dorośli"));
    }

    @Test
    public void bookAppointmentTest() {
        new StartPage(driver).acceptCoockie()
                .goToMedicoverOnline()
                .goToLogin()
                .loginUser(user)
                .clickPopup()
                .selectDoctor("Pobranie krwi i innych materiałów")
                .scheduleFacilityConsulation()
                .setDate("05-10-2024")
                .bookAppointment()
                .confimAppointment();
    }
}
