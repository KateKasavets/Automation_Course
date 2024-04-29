package org.example;


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
    public static ProfilePage profilePage;
    public static WebDriver driver;


        @BeforeEach
        public void setup() {

            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

            driver = new ChromeDriver();
            loginPage = new LoginPage(driver);
            profilePage = new ProfilePage(driver);
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
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                loginPage.clickChooseProduct();

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

           WebElement pageTitle = driver.findElement(By.xpath("//label[@class=\"row-value\"]"));
            assertTrue(pageTitle.isDisplayed(), "Название страницы отображается");
                String expectedTitle = "Demo batch";
                String actualTitle = pageTitle.getText();
                assertEquals("Demo batch", expectedTitle, actualTitle);

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

      @AfterEach
       public  void tearDown() {
          profilePage.clickUserMenu();
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          profilePage.clickLogOutBtn();
          driver.manage().deleteAllCookies();
          driver.navigate().refresh();
            driver.quit();


        }
}

