package pages.resultPage;

import lombok.SneakyThrows;
import models.products.AbstractProduct;
import models.products.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends AbstractPage implements ResultPageInterface {
    @FindBy(xpath = "//div[@class='sortLink']")
    WebElement sortLink;
    @FindBy(xpath = "//div[contains(@class,'galleryItem')]")
    List<WebElement> products;

    @Override
    public void switchToSortType(String sortType)  {
        new WebDriverWait(driver, 20).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        sortLink.findElement(By.xpath("./span")).click();
        WebElement button = sortLink.findElement(By.xpath("./ul/li/a[text()='" + sortType + "']"));
        button.click();
    }

    @Override
    public List<AbstractProduct> getProducts() {
        List<AbstractProduct> products = new ArrayList<>();
        for(WebElement product : this.products){
            Product newProduct = new Product();
            newProduct.setDescription(product.findElement(By.xpath("./a/div/p[text()!='' and @class='productDesc']")).getText());
            products.add(newProduct);
        }
        return products;
    }
}
