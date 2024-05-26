package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(OrderAnnotation.class)
public class PriorityClasses {
    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeEach
    public void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));

    }
    @Test
    @Order(1)
    public void checkLoginPage() {

        WebElement pageTitle = driver.findElement(By.id("login-header"));
        assertTrue(pageTitle.isDisplayed(), "Название страницы отображается");
        assertEquals("Авторизоваться", pageTitle.getText(), "Страница логина не найдена");

    }

    @Test
    @Order(3)
    void testExternalLogin(){

        loginPage.clickLoginExternal();
        WebElement loginWithApple = driver.findElement(By.xpath("//div[@id=\"signin\"]/app-title"));
        assertTrue(loginWithApple.isDisplayed(), "Заголовок страницы");
        assertEquals("Используйте Apple ID для входа в приложение «Battle.net».", loginWithApple.getText(), "Текст заголовка не соответствует ожидаемому");
    }

    @Test
    @Order(2)
    void testLoginWithoutCredentials() {
        driver.findElement(By.id("submit")).click();
        WebElement errorMessageElement = driver.findElement(By.xpath("//span[@class=\"error-helper error-helper-accountName status-warning\"]"));
        String errorMessage = errorMessageElement.getText();
        System.out.println("Найдено сообщение об ошибке: " + "Please enter your account name");

    }

    @AfterAll
    public  static void tearDown(){
        driver.quit();
    }
}
