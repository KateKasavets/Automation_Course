package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class=\"user-menu\"]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@id=\"dropdown-1\"]/div/button[4]/div/span")
    private WebElement logoutBtn;

    public void clickUserMenu() {
        userMenu.click();

    }
    public void clickLogOutBtn(){
        logoutBtn.click();
    }

    }
