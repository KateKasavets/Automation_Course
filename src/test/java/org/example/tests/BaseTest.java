package org.example.tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.example.utils.WebDriverSingleton;

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
