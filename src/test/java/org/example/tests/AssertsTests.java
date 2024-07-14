package org.example.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testng.asserts.SoftAssert;
import org.example.page_objects.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(registrationPage.isFirstAndLastNameFieldsDisplayed(), "First Name and/or Last Name Fields are not displayed");
        assertTrue(registrationPage.isAgeFieldDisplayed(), "Age field is not displayed");
    }

    @Test
    public void testWithSoftAsserts() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(registrationPage.isFirstAndLastNameFieldsDisplayed(), "First Name and/or Last Name Fields are not displayed");
        softAssert.assertTrue(registrationPage.isAgeFieldDisplayed(), "Age field is not displayed");

        softAssert.assertAll();
    }
}
