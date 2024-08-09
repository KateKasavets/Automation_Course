package org.example.tests;
import org.example.pageObjects.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.example.utils.ConfProperties;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class PriorityTests extends BaseTest {
    public static LoginPage loginPage;

    @BeforeAll
    public void setupTests() {
        setup();
        loginPage = new LoginPage(driver);
        driver.get(ConfProperties.getLoginPageUrl());
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
        loginPage.clickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='error-helper error-helper-accountName status-warning']")));
        String errorMessageText = errorMessageElement.getText();
        System.out.println("Найдено сообщение об ошибке: " + errorMessageText);
        Assert.assertEquals(errorMessageText, "Введите имя учетной записи.");
    }
}
