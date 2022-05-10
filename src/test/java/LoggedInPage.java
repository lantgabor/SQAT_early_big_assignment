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


class LoggedInPage extends PageBase {

    private By userFace = By.xpath("//span[@class='user-face']");
    private By logout = By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[1]/ul[1]/li[5]/div[1]/a[13]");

    private By searchField = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
    private By searchBtn = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/button[2]/span[2]");

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchField).click();
        this.waitAndReturnElement(searchField).sendKeys(searchQuery);
        
        this.waitAndReturnElement(searchBtn).click();
   
        return new SearchResultPage(this.driver);
    }

    public MainPage logout() {
        this.waitAndReturnElement(userFace).click();
        this.waitAndReturnElement(logout).click();

        return new MainPage(this.driver);
    }
}
