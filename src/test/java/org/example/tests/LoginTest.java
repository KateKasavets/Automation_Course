package org.example.tests;


import org.example.pageObjects.LoginPage;
import org.example.utils.ConfProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;


    @BeforeEach
    public void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    public void loginTest(String login, String password) {
        loginPage.inputLogin(login);
        loginPage.inputPasswd(password);
        loginPage.clickLoginBtn();

        WebElement pageTitle = driver.findElement(By.xpath("//*[@class=\"title\"]"));
        assertTrue(pageTitle.isDisplayed(), "Название страницы отображается");
        assertEquals("Обзор учетной записи", pageTitle.getText(), "Текст заголовка не соответствует ожидаемому");

    }

    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.quit();

    }
}

