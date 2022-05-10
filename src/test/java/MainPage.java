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

class MainPage extends PageBase {

    private By headerBy = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/h3[1]");
    private By searchBy = By
            .xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
    private By searchBtn = By.xpath(
            "/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/button[2]/span[2]");

    private By login = By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[1]/ul[1]/li[1]/button[1]/span[1]");

    private By profile = By.xpath("//li[@class='dropdown dropdown-user']/a");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://hardverapro.hu/");
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

    public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchBy).click();
        this.waitAndReturnElement(searchBy).sendKeys(searchQuery);
        this.waitAndReturnElement(searchBtn).click();

        return new SearchResultPage(this.driver);
    }

    public LoginPage openLogin() {
        this.waitAndReturnElement(login).click();

        return new LoginPage(this.driver);
    }

    public LoggedInPage openProfile() {
        this.waitAndReturnElement(profile).click();

        return new LoggedInPage(this.driver);
    }


}
