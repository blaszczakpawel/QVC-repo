package di;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import interceptors.InitDriverBeforeMethod;
import interceptors.InitializeWebDriverInterceptor;
import interceptors.InjectWebDriverIntoPagesInterceptor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.resultPage.ResultPage;
import pages.resultPage.ResultPageInterface;
import pages.shopMainPage.ShopMainPage;
import pages.shopMainPage.ShopMainPageInterface;
import tests.AbstractWebTest;
import wrappers.WebDriverWrapper;

public class MainInjector extends AbstractModule {
    @Override
    protected void configure() {
        //interceptors
        bindInterceptor(Matchers.subclassesOf(WebDriverWrapper.class), Matchers.annotatedWith(InitDriverBeforeMethod.class), new InitializeWebDriverInterceptor());
        bindInterceptor(Matchers.subclassesOf(AbstractWebTest.class), Matchers.annotatedWith(Test.class), new InjectWebDriverIntoPagesInterceptor());
        //helpers
        bind(WebDriver.class).to(WebDriverWrapper.class);
        //pages
        bind(ShopMainPageInterface.class).to(ShopMainPage.class);
        bind(ResultPageInterface.class).to(ResultPage.class);
    }
}
