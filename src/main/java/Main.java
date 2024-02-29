import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;




public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://eu.account.battle.net");

        WebElement login=  driver.findElement(By.xpath("//input[@id=\"accountName\"]"));
        WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        WebElement login_button= driver.findElement(By.xpath("//button[@id=\"submit\"]"));
        login.sendKeys("evinasenla@gmail.com");
        password.sendKeys("kk25474kk");
        login_button.click();


    }
}
