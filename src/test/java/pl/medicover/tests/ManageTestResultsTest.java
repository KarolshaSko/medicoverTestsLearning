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
                .selectTestResults();
//                .setDate("04-10-2023");

        String testName = testResultsPage.getTestName();
        String testDoctorName = testResultsPage.getTestDoctorName();
        String[] parts = testDoctorName.split(" ");
        testDoctorName = parts[1] + " " + parts[0];
        String testPublicationDate = testResultsPage.getTestPublicationDate();

        TestResultsDetailsPage testResultsDetailsPage = testResultsPage.goToTestResultDetails();

        Assert.assertTrue(testResultsDetailsPage.assertTextExist(testName));
        Assert.assertEquals(testDoctorName,testResultsDetailsPage.getTestDoctorName());
        Assert.assertEquals(testPublicationDate, testResultsDetailsPage.getTestPublicationDate());
    }
}
