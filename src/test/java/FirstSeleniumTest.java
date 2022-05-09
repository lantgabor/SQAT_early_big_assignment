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
import java.util.*;

public class FirstSeleniumTest {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHeader() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getHeaderText().contains("Keress"));
    }

    @Test
    public void testSearch() {
        MainPage mainPage = new MainPage(this.driver);
        SearchResultPage searchResultPage = mainPage.search("valami");
        String bodyText = searchResultPage.getBodyText();
        System.out.print(bodyText);
        Assert.assertTrue(bodyText.contains("A"));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
