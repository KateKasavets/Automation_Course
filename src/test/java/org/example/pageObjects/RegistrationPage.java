package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By ageField = By.id("age");
    private By lastNameField = By.id("last-name");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRegistrationPage(String url) {
        driver.get(url);
    }

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }

    public WebElement getAgeField() {
        return driver.findElement(ageField);
    }

    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }

    public String getFirstNameFieldValue() {
        return getFirstNameField().getAttribute("value");
    }

    public String getAgeFieldValue() {
        return getAgeField().getAttribute("value");
    }

    public String getLastNameFieldValue() {
        return getLastNameField().getAttribute("value");
    }
}
