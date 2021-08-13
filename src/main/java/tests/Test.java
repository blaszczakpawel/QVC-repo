package tests;

import com.google.inject.Inject;
import interceptors.Page;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;
import pages.resultPage.ResultPageInterface;
import pages.shopMainPage.ShopMainPage;
import pages.shopMainPage.ShopMainPageInterface;
import wrappers.WebDriverWrapper;

@Guice
public class Test extends AbstractWebTest {
    @Inject
    @Page
    public ShopMainPageInterface mainPage;
    @Inject
    @Page
    public ResultPageInterface resultPage;
    
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        mainPage.goToPage();
        mainPage.search("Bracelets");
        resultPage.switchToSortType("Average Rating");
        System.out.println(resultPage.getProducts().get(0).getDescription());
    }

}
