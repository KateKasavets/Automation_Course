package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement loginField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passwdField;

    @FindBy(xpath = "//a[@class=\"product eyesProduct\"]")
    private WebElement chooseProduct;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
       }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLoginBtn() {
        loginBtn.click();
    }
    public void clickChooseProduct() {
        chooseProduct.click();


    }
    }






