package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DependentTests {
    private static WebDriver driver;
    private static LogPage logPage;
    private static boolean isLoggedIn = false;
    private static boolean isUserProfileButton = false;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://auth.applitools.com/users/login");
        logPage = new LogPage(driver);
    }

    @Test
    @Order(1)
    public void loginTest(){

        logPage.login("evinasenla@gmail.com", "kk25474kkKK!");
        WebElement userProfileButton = driver.findElement(By.xpath("//button[@aria-label=\"User\"]"));
        isLoggedIn = userProfileButton.isDisplayed();  // Установка флага на основе видимости кнопки
        assertTrue(isLoggedIn, "User profile button is not displayed - Login may have failed");
        assertTrue(userProfileButton.isDisplayed(), "users button is displayed");

    }
    @Test
    @Order(2)
    public void navigateToProfileMenu(){
        Assumptions.assumeTrue(isLoggedIn, "Skipping this test because login test failed");
        WebElement userProfileButton = driver.findElement(By.xpath("//button[@aria-label=\"User\"]"));
        userProfileButton.click();

        WebElement profileMenu = driver.findElement(By.xpath("//div[@class=\"user-name\"]"));
        isUserProfileButton= profileMenu.isDisplayed();
        assertTrue(profileMenu.isDisplayed(), "Profile menu did not display after clicking user profile button");
        assertEquals("Eva Evina", profileMenu.getText(), "Имя  не соответствует ожидаемому");

    }
    @Test
    @Order(3)
    public void logOutTest(){
        Assumptions.assumeTrue(isUserProfileButton, "Skipping this test because profile menu was not displayed");
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id=\"dropdown-1\"]/div/button[4]/div/span"));
        logOutButton.click();

        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class=\"title\"]"));
        assertTrue(pageTitle.isDisplayed(), "Название страницы  авторизации отображается");
        assertEquals("Sign in", pageTitle.getText(), "Пользователь не на странице авторизации");

    }

    @AfterAll
    public  static void tearDown(){
        driver.quit();
    }
}


