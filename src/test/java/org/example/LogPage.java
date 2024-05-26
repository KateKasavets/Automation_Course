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
    private By chooseProduct = By.xpath("//a[@class=\"product eyesProduct\"]");


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
}
