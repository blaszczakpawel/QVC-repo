package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;

    public void init(WebDriver driver) {
        if (this.driver == null) {
            this.driver = driver;
            PageFactory.initElements(this.driver, this);
        }

    }
}
