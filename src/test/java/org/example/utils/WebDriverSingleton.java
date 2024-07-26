package org.example.utils;

import org.example.utils.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() { //Одним из наиболее распространенных использований приватного конструктора является
        // реализация дизайн-паттерна "Одиночка" (Singleton). Его цель – гарантировать, что будет существовать только
        // один экземпляр класса и обеспечить глобальную точку доступа к этому объекту. Приватный конструктор
        // предотвращает создание дополнительных объектов и обеспечивает уникальность объекта. Это то, что я нашла.
        //НО возможно я что-то не так понимаю?

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", ConfProperties.getChromeDriverPath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
