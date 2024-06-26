package org.example;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AssertsTests extends BaseTest{

    private  RegistrationPage registrationPage;

    @BeforeEach
    public   void setupTests() {
        setup();
        registrationPage = new RegistrationPage(driver);
        driver.get("https://auth.applitools.com/users/general-register");
    }

    @Test
    public void testWithHardAsserts() {
        assertTrue(registrationPage.getFirstNameField().isDisplayed(), "FirstName Field is not displayed");
        assertTrue(registrationPage.getAgeField().isDisplayed(), "Age field is not displayed");
        assertTrue(registrationPage.getLastNameField().isDisplayed(), "LastName Field is not displayed");
    }

    @Test
    public void testWithSoftAsserts() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(registrationPage.getFirstNameField().isDisplayed(), "Firstname field is not displayed");
        softAssert.assertTrue(registrationPage.getAgeField().isDisplayed(), "Age field is not displayed");
        softAssert.assertTrue(registrationPage.getLastNameField().isDisplayed(), "Lastname field is not displayed");

        softAssert.assertAll();
    }
}