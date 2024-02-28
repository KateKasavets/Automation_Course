package test2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class links{
    public static void main(String[] args) {
        // Установите путь к драйверу
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com"); // Замените на URL вашей целевой страницы

        // Найдите все ссылки на странице
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("URL отсутствует");
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(url + " неработает. Код ответа: " + responseCode);
                } else {
                    System.out.println(url + " работает.");
                }
            } catch (Exception e) {
                System.out.println(url + " неработает. Ошибка: " + e.getMessage());
            }
        }

        driver.quit();
    }
}



