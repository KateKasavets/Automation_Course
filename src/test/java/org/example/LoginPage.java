package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "accountName")
    private WebElement loginField;

    @FindBy(id = "submit")
    private WebElement loginBtn;

    @FindBy(id = "password")
    private WebElement passwdField;

    @FindBy(xpath = "//button[@id='apple']")
    private WebElement loginExternal;

    @FindBy(xpath = "//div[@id='signin']/app-title")
    private WebElement loginWithAppleTitle;

    @FindBy(xpath = "//span[@class='error-helper error-helper-accountName status-warning']")
    private WebElement errorMessageElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void clickLoginExternal() {
        loginExternal.click();
    }

    public String getLoginWithAppleTitleText() {
        return loginWithAppleTitle.getText();
    }

    public String getErrorMessageText() {
        return errorMessageElement.getText();
    }
}
