package pl.medicover.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.medicover.pages.*;

public class ManageAppointmentsTest extends BaseTest {

    @Test
    public void searchDoctorTest() {

        VisitsPage visitsPage = loggedUserPage
                .selectSpecialization("Badania", "Pobranie krwi i innych materiałów")
                .selectAppointmentType("Punkt Pobrań");

        Assert.assertTrue(visitsPage.getSpecialization().contains("Punkt Pobrań"));
    }

    @Test
    public void bookAppointmentTest() {

        VisitsPage visitsPage = loggedUserPage
                .selectSpecialization("Badania", "Pobranie krwi i innych materiałów")
                .selectAppointmentType("Punkt Pobrań")
                .showAllAppointments();
//                .setDate("31");

        String appointmentTime = visitsPage.getTime();
        String appointmentFacility = visitsPage.getFacility();
        String appointmentSpecialization = visitsPage.getSpecialization();

        ConfirmAppointmentPage confirmAppointmentPage = visitsPage.bookAppointment();

        Assert.assertEquals(appointmentFacility, confirmAppointmentPage.getFacilityName());
        Assert.assertEquals(appointmentSpecialization, confirmAppointmentPage.getSpecialization());
        Assert.assertTrue(confirmAppointmentPage.getTimeAndDate().contains(appointmentTime));

        BookedAppointmentConfirmationPage bookedAppointmentConfirmationPage = confirmAppointmentPage.confimAppointment();

        Assert.assertEquals(bookedAppointmentConfirmationPage.getTitle(), "Wizyta została umówiona!");
    }

    @Test
    public void cancelAppointmentTest() {
        loggedUserPage = new LoggedUserPage(driver);
        CancelAppointmentPage cancelAppointmentPage = new MenuPage(driver)
                .selectFromVisitsDropdown("Odwołaj wizytę") // Odwołaj wizytę , Moje wizyty , Powiadomienie o dostępności , Zapytaj lekarza//
                .manageYourVisit("Odwołaj") // Szczegóły , Zmień termin , Odwołaj //
                .confirmCancelVisit();

        Assert.assertEquals(cancelAppointmentPage.getTitle(), "Wizyta została odwołana.");
    }
}
