package libraryUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class libraryUtils {

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webElement, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));

        return element;
    }

    public static WebElement waitForElementToBeClicable(WebDriver driver, WebElement webElement, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));

        return element;
    }
}