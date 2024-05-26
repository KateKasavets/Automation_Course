package org.example;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckAsserts {
    public static WebDriver driver;
    public static RegistrationPage registrationpage;
    @BeforeAll
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        registrationpage = new RegistrationPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://auth.applitools.com/users/general-register");
    }



    @Test
    public void testWithHardAsserts() {

        List<WebElement> FirstName = driver.findElements(By.xpath("//input[@id='first-name']"));
        boolean isFirstNameDisplayed = ! FirstName.isEmpty() &&  FirstName.get(0).isDisplayed();
        assertTrue(isFirstNameDisplayed, "FirstName Field is not displayed");


        List<WebElement> AgeField = driver.findElements(By.xpath("//input[@id='age']"));
        boolean isAgeFieldDisplayed = ! AgeField.isEmpty() &&  AgeField.get(0).isDisplayed();
        assertTrue(isAgeFieldDisplayed, "Age field is not displayed");


        List<WebElement> LastName = driver.findElements(By.xpath("//input[@id='last-name']"));
        boolean isLastNameDisplayed = ! LastName.isEmpty() &&  LastName.get(0).isDisplayed();
        assertTrue(isLastNameDisplayed, "LastName Field is not displayed");

    }

    @Test
    public void testWithSoftAsserts() {
        SoftAssertions softAssertions = new SoftAssertions();

        List<WebElement> firstName = driver.findElements(By.xpath("//input[@id=\"first-name\"]"));
        softAssertions.assertThat(!firstName.isEmpty() && firstName.get(0).isDisplayed()).as("Check firstname field is displayed").isTrue();


        List<WebElement> AgeField = driver.findElements(By.xpath("//input[@id=\"age\"]"));
        softAssertions.assertThat(!AgeField.isEmpty() && AgeField.get(0).isDisplayed()).as("Age field is displayed").isTrue();

        List<WebElement> lastName = driver.findElements(By.xpath("//input[@id=\"last-name\"]"));
        softAssertions.assertThat(!lastName.isEmpty() && lastName.get(0).isDisplayed()).as("Check lastname field is displayed");

       //softAssertions.assertAll();
    }
}