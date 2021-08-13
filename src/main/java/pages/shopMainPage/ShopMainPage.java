package pages.shopMainPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class ShopMainPage extends AbstractPage implements ShopMainPageInterface {
    private String path = "https://www.qvc.com";
    @FindBy(xpath = "//input[@id='txtMastheadSearch']")
    WebElement searchInput;

    @Override
    public void goToPage() {
        this.driver.get(path);
    }

    @Override
    public void search(String key) {
        searchInput.sendKeys(key);
        searchInput.sendKeys(Keys.ENTER);
    }
}
