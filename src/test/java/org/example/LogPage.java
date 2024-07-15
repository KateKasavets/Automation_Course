package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LogPage {

    private WebDriver driver;

    // Локаторы элементов на странице логина
    private By emailField = By.xpath("//input[@type='email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By signInButton = By.xpath("//button[@type='submit']");
    private By chooseProduct = By.xpath("//a[@class='product eyesProduct']");
    private By userProfileButton = By.xpath("//button[@aria-label='User']");
    private By profileMenu = By.xpath("//div[@class='user-name']");
    private By logOutButton = By.xpath("//*[@id='dropdown-1']/div/button[4]/div/span");
    private By pageTitle = By.xpath("//h1[@class='title']");

    public LogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        WebElement emailInput = driver.findElement(emailField);
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElement(signInButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(chooseProduct).click();
    }

    public boolean isUserProfileButtonDisplayed() {
        return driver.findElement(userProfileButton).isDisplayed();
    }

    public void clickUserProfileButton() {
        driver.findElement(userProfileButton).click();
    }

    public boolean isProfileMenuDisplayed() {
        return driver.findElement(profileMenu).isDisplayed();
    }

    public String getProfileMenuText() {
        return driver.findElement(profileMenu).getText();
    }

    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }

    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public String getPageTitleText() {
        return driver.findElement(pageTitle).getText();
    }
}
