package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DependentTests extends BaseTest {
    private LogPage logPage;
    private boolean isLoggedIn = false;
    private boolean isUserProfileButton = false;

    @BeforeAll
    public void setupAll() {
        setup();
        driver.get("https://auth.applitools.com/users/login");
        logPage = new LogPage(driver);
    }

    @Test
    @Order(1)
    public void loginTest() {
        logPage.login("evinasenla@gmail.com", "kk25474kkKK!");
        isLoggedIn = logPage.isUserProfileButtonDisplayed();
        assertTrue(isLoggedIn, "User profile button is not displayed - Login may have failed");
    }

    @Test
    @Order(2)
    public void navigateToProfileMenu() {
        Assumptions.assumeTrue(isLoggedIn, "Skipping this test because login test failed");
        logPage.clickUserProfileButton();
        isUserProfileButton = logPage.isProfileMenuDisplayed();
        assertTrue(isUserProfileButton, "Profile menu did not display after clicking user profile button");
        assertEquals("Eva Evina", logPage.getProfileMenuText(), "Имя не соответствует ожидаемому");
    }

    @Test
    @Order(3)
    public void logOutTest() {
        Assumptions.assumeTrue(isUserProfileButton, "Skipping this test because profile menu was not displayed");
        logPage.clickLogOutButton();
        assertTrue(logPage.isPageTitleDisplayed(), "Название страницы авторизации отображается");
        assertEquals("Sign in", logPage.getPageTitleText(), "Пользователь не на странице авторизации");
    }

    @AfterAll
    public void tearDownAll() {
        tearDown();
    }
}
