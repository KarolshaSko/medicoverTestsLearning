package pl.medicover.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.medicover.pages.LoggedUserPage;
import pl.medicover.pages.MenuPage;
import pl.medicover.pages.TestResultsDetailsPage;
import pl.medicover.pages.TestResultsPage;

public class ManageTestResultsTest extends BaseTest {

    @Test
    public void checkTestResultsTest() {
        loggedUserPage = new LoggedUserPage(driver);
        TestResultsPage testResultsPage = new MenuPage(driver)
                .goToTestResults()
                .setDate("04-10-2023")
                .confirmChosenCriteria();

        String testName = testResultsPage.getTestName();
        String testDoctorName = testResultsPage.getTestDoctorName();
        String testPublicationDate = testResultsPage.getTestPublicationDate();

        TestResultsDetailsPage testResultsDetailsPage = testResultsPage.goToTestReultDetails();

        Assert.assertEquals(testName,testResultsDetailsPage.getTestName());
        Assert.assertEquals(testDoctorName,testResultsDetailsPage.getTestDoctorName());
        Assert.assertEquals(testPublicationDate, testResultsDetailsPage.getTestPublicationDate());
    }

    @Test
    public void filterTestResultsTest() {
        loggedUserPage = new LoggedUserPage(driver);
        TestResultsPage testResultsPage = new MenuPage(driver)
                .goToTestResults()
                .setDate("04-10-2023")
                .setSpecialization("Ortopeda dziecięcy")
                .confirmChosenCriteria();

        Assert.assertEquals(testResultsPage.getTestResultAmount(),1);

    }
}
