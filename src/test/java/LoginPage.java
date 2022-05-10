import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;


class LoginPage extends PageBase {

    private By usernameBox = By.name("email");
    private By passwordBox = By.name("pass");

    private By submit = By.xpath("submit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoggedInPage login(String username, String password) {
        this.waitAndReturnElement(usernameBox).sendKeys(username);
        this.waitAndReturnElement(passwordBox).sendKeys(password + "\n");

        return new LoggedInPage(this.driver);
    }
}
