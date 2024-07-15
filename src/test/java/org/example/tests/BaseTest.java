package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected  static WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = WebDriverSingleton.getDriver();
    }

    @AfterAll
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
