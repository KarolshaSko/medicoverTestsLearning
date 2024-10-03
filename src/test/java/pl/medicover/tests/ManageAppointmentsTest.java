package pl.medicover.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.medicover.pages.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManageAppointmentsTest extends BaseTest {

    @Test
    public void searchDoctorTest() {


        VisitsPage visitsPage = loggedUserPage
                .selectDoctor("Pobranie krwi i innych materiałów")
                .scheduleFacilityConsulation();

        Assert.assertTrue(visitsPage.getSpecialization("Punkt Pobrań - dorośli").contains("Punkt Pobrań - dorośli"));
    }

    @Test
    public void bookAppointmentTest() throws ParseException {

        String appointmentDate = "05-10-2024";

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(appointmentDate);
        SimpleDateFormat newFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String assertDate = newFormatter.format(date);


        VisitsPage visitsPage = loggedUserPage
                .selectDoctor("Pobranie krwi i innych materiałów")
                .scheduleFacilityConsulation()
                .setDate(appointmentDate);

        String appointmentTime = visitsPage.getTime();
        String appointmentFacility = visitsPage.getFacility();
        String appointmentSpecialization = visitsPage.getSpecialization();

        BookedAppointmentConfirmationPage bookedAppointmentConfirmationPage = visitsPage.bookAppointment()
                .confimAppointment();

        Assert.assertEquals(appointmentFacility,bookedAppointmentConfirmationPage.getFacilityName());
        Assert.assertEquals(appointmentSpecialization,bookedAppointmentConfirmationPage.getSpecialization());
        Assert.assertEquals(appointmentTime,bookedAppointmentConfirmationPage.getTime());
        Assert.assertEquals(assertDate,bookedAppointmentConfirmationPage.getDate());
    }

    @Test
    public void cancelAppointmentTest() {
        loggedUserPage = new LoggedUserPage(driver);
        MyVisitsPage myVisitsPage = new MenuPage(driver)
                .goToCancelAppointment()
                .cancelAppointment("Punkt Pobrań - dorośli");
    }
}
