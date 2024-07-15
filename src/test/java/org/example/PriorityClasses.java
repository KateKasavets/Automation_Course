package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class PriorityClasses extends BaseTest{
    public static LoginPage loginPage;

    @BeforeAll
    public void setupTests() {
        setup();
        loginPage = new LoginPage(driver);
        driver.get(ConfProperties.getProperty("loginpage"));

    }
    @Test
    @Order(1)
    public void checkLoginPage() {

        WebElement pageTitle = driver.findElement(By.id("login-header"));
        assertTrue(pageTitle.isDisplayed(), "Название страницы отображается");
        assertEquals("Авторизоваться с помощью", pageTitle.getText(), "Страница логина не найдена");

    }

    @Test
    @Order(3)
    void testExternalLogin(){

        loginPage.clickLoginExternal();
        Assert.assertEquals(loginPage.getLoginWithAppleTitleText(), "Используйте Apple ID для входа в приложение «Battle.net».", "Текст заголовка не соответствует ожидаемому");
    }

    @Test
    @Order(2)
    void testLoginWithoutCredentials() {
        loginPage.clickLoginBtn(); // Вызывается метод для входа без учетных данных
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Явное ожидание с использованием Duration
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='error-helper error-helper-accountName status-warning']")));
        String errorMessageText = errorMessageElement.getText();
        System.out.println("Найдено сообщение об ошибке: " + errorMessageText);
        Assert.assertEquals(errorMessageText, "Введите имя учетной записи.");
    }
}
