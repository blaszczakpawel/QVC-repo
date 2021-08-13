package wrappers;

import interceptors.InitDriverBeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class WebDriverWrapper implements WebDriver, JavascriptExecutor {
    private WebDriver driver;

    @InitDriverBeforeMethod
    @Override
    public void get(String s) {
        this.driver.get(s);
    }

    @InitDriverBeforeMethod
    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    @InitDriverBeforeMethod
    @Override
    public String getTitle() {
        return this.driver.getTitle();
    }

    @InitDriverBeforeMethod
    @Override
    public List<WebElement> findElements(By by) {
        return this.driver.findElements(by);
    }

    @InitDriverBeforeMethod
    @Override
    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    @InitDriverBeforeMethod
    @Override
    public String getPageSource() {
        return this.driver.getPageSource();
    }

    @InitDriverBeforeMethod
    @Override
    public void close() {
        this.driver.close();
    }

    @InitDriverBeforeMethod
    @Override
    public void quit() {
        this.driver.quit();
    }

    @InitDriverBeforeMethod
    @Override
    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    @InitDriverBeforeMethod
    @Override
    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    @InitDriverBeforeMethod
    @Override
    public TargetLocator switchTo() {
        return this.driver.switchTo();
    }

    @InitDriverBeforeMethod
    @Override
    public Navigation navigate() {
        return this.driver.navigate();
    }

    @InitDriverBeforeMethod
    @Override
    public Options manage() {
        return this.driver.manage();
    }

    @InitDriverBeforeMethod
    @Override
    public Object executeScript(String s, Object... objects) {
        return ((JavascriptExecutor) this.driver).executeScript(s, objects);
    }

    @InitDriverBeforeMethod
    @Override
    public Object executeAsyncScript(String s, Object... objects) {
        return ((JavascriptExecutor) this.driver).executeAsyncScript(s, objects);
    }

    public void init() {
        if (this.driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }


}
