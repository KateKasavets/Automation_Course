package org.example.tests;

import org.example.utils.WebDriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = WebDriverSingleton.getDriver();
    }

    @AfterAll
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

}
