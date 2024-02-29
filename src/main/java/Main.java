import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static javax.swing.text.html.CSS.getAttribute;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //if (driver instanceof JavascriptExecutor) {
          //  ((JavascriptExecutor)driver).executeScript("alert('Привет, это JavaScriptExecutor');");
        //}

        //driver.get("https://google.com");


        //WebElement input = driver.findElement(By.xpath("//textarea[@aria-label=\"Найти\"]"));
        //input.click();
        //driver.findElement(By.xpath("//textarea[@aria-label=\"Найти\"]")).sendKeys("Hello");
        //driver.findElement(By.xpath("//textarea[@aria-label=\"Найти\"]")).submit();
        //driver.findElement(By.xpath("//textarea[@aria-label=\"Найти\"]")).sendKeys(Keys.ENTER);
        //String availableText= driver.findElement(By.xpath("//a[@aria-label=\"Почта (откроется новая вкладка)\"]")).getText();


        //String attributeValue = driver.findElement(By.name("btnI")).getAttribute("value");
        //System.out.println("Available attribute value is :"+attributeValue);


        //System.out.println("Text Available is :"+availableText);
        //driver.findElement(By.xpath("//a[contains(@href,\"accounts.google.com\")]")).click();

    }
}
