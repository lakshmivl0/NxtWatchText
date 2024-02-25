import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NxtWatchLoginText {
    public static void main(String[] args) {
        // Set the path to chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laksh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://qanxtwatch.ccbp.tech/login");

        // Enter username
        WebElement usernameField = driver.findElement(By.id("USERNAME"));
        usernameField.sendKeys("rahul");

        // Enter password
        WebElement passwordField = driver.findElement(By.id("PASSWORD"));
        passwordField.sendKeys("rahul@2021");

        // Submit the form
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Wait for the redirection
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qanxtwatch.ccbp.tech/"));

        // Verify if logged in successfully
        String currentURL = driver.getCurrentUrl();
        if (currentURL.equals("https://qanxtwatch.ccbp.tech/")) {
            System.out.println("Logged in successfully");
            System.out.println("Page Title: " + driver.getTitle());
        }

        // Click Logout button
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        logoutButton.click();

        // Click Confirm button
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        // Wait for the redirection
        wait.until(ExpectedConditions.urlToBe("https://qanxtwatch.ccbp.tech/login"));

        // Verify if logged out successfully
        currentURL = driver.getCurrentUrl();
        if (currentURL.equals("https://qanxtwatch.ccbp.tech/login")) {
            System.out.println("Logged out successfully");
            System.out.println("Page Title: " + driver.getTitle());
        }

        // Close the browser window
        driver.quit();
    }
}