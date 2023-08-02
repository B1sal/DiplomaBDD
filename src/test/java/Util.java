import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {

    public void myImplicitWait(WebDriver driver, int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

//    public WebElement myExplicitWait(WebDriver driver, WebElement webElement, int timeInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        return wait.until(ExpectedConditions.visibilityOf(webElement));
//    }
}
