package org.example.tests;
import org.example.pageObjects.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testng.asserts.SoftAssert;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AssertsTests extends BaseTest {

    private RegistrationPage registrationPage;

    @BeforeEach
    public void setupAll() {
        setup();
        registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage("https://auth.applitools.com/users/general-register");
    }

    @Test
    public void testWithHardAsserts() {

        assertTrue(registrationPage.getFirstNameField().isDisplayed(), "FirstName Field is not displayed");
        assertTrue(registrationPage.getAgeField().isDisplayed(), "Age field is not displayed");
        assertTrue(registrationPage.getLastNameField().isDisplayed(), "LastName Field is not displayed");

        assertEquals("", registrationPage.getFirstNameFieldValue(), "FirstName Field is not empty");
        assertEquals("", registrationPage.getAgeFieldValue(), "Age Field is not empty");
        assertEquals("", registrationPage.getLastNameFieldValue(), "LastName Field is not empty");
    }

    @Test
    public void testWithSoftAsserts() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(registrationPage.getFirstNameField().isDisplayed(), "Firstname field is not displayed");
        softAssert.assertTrue(registrationPage.getAgeField().isDisplayed(), "Age field is not displayed");
        softAssert.assertTrue(registrationPage.getLastNameField().isDisplayed(), "Lastname field is not displayed");

        softAssert.assertEquals("", registrationPage.getFirstNameFieldValue(), "FirstName Field is not empty");
        softAssert.assertEquals("", registrationPage.getAgeFieldValue(), "Age Field is not empty");
        softAssert.assertEquals("", registrationPage.getLastNameFieldValue(), "LastName Field is not empty");

        softAssert.assertAll();
    }
}
