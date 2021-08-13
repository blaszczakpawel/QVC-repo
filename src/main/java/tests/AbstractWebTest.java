package tests;

import com.google.inject.Inject;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;

@Guice
public abstract class AbstractWebTest {
    @Inject
    @Getter
    protected WebDriver webDriver;

    @AfterClass
    public void quitDriver(){
        webDriver.quit();
    }
}
